package com.valtech.checkout;

import org.junit.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;

@RunWith(JMock.class)
public class CheckoutImplTest {

    Mockery context = new JUnit4Mockery();
    
	private Checkout checkout = null;
	
	@Before
	public void beforeTests() {
		checkout = new CheckoutImpl();
	}
	
	@Test
	public void totalIsZeroWhenNothingScanned() {
		assertEquals(0.0,checkout.total(), 0.00001);
	}
	
	@Test
	public void testItemNotFound() {
		try {
			checkout.scan("rubbish item");
			Assert.assertFalse(true);
		} catch (RuntimeException e) {
			Assert.assertTrue(true);
		}
		
	}
	@Test
	public void scanOneItem() {
		checkout.scan("apple");
		Assert.assertEquals(2.0, checkout.total(), 0.00001);
	}
	@Test
	public void scanTwoItems() {
		checkout.scan("apple");
		checkout.scan("banana");
		Assert.assertEquals(3.0, checkout.total(), 0.00001);
	}
	@Test
	public void testCheckoutOneItem() {


        final StockControlSystem mockScs = context.mock(StockControlSystem.class);

        // expectations
        context.checking(new Expectations() {{
            oneOf (mockScs).decrementStockCount("apple");
        }});


		checkout.setStockControlSystem(mockScs);
		
		checkout.scan("apple");
		checkout.complete();
		
		Assert.assertEquals(2.0, checkout.total(), 0.00001);
	}

    @Test
	public void testCheckoutMultipleItemsTheSame() {


        final StockControlSystem mockScs = context.mock(StockControlSystem.class);

        // expectations
        context.checking(new Expectations() {{
            exactly(2).of (mockScs).decrementStockCount("apple");
        }});


		checkout.setStockControlSystem(mockScs);

        checkout.scan("apple");
        checkout.scan("apple");
		checkout.complete();

		Assert.assertEquals(2.0 + 2.0, checkout.total(), 0.00001);
	}

    @Test
	public void testCheckout_MixedCart() {


        final StockControlSystem mockScs = context.mock(StockControlSystem.class);

        // expectations
        context.checking(new Expectations() {{
            exactly(2).of (mockScs).decrementStockCount("apple");
            exactly(1).of (mockScs).decrementStockCount("orange");
        }});


		checkout.setStockControlSystem(mockScs);

        checkout.scan("apple");
        checkout.scan("orange");
        checkout.scan("apple");
		checkout.complete();

		Assert.assertEquals(2.0 + 2.0 + 20.0, checkout.total(), 0.00001);
	}}
