package com.valtech.money.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;

import com.valtech.money.dao.ItemDAO;
import com.valtech.money.model.Customer;
import com.valtech.money.model.GoodsDelivery;
import com.valtech.money.model.LineItem;

@RunWith(JMock.class)
public class ShipmentManagerUnitTest {

    Mockery context = new JUnit4Mockery();


	@Test
    public void testBuildShipment() {

        final ItemDAO mockItemDao = context.mock(ItemDAO.class);

		final LineItem lineItem = new LineItem();
		lineItem.setItemCost(0);

        context.checking(new Expectations(){{
            oneOf(mockItemDao).retrieveItemBySKU(1l);
                will(returnValue(lineItem));
        }});

		ShipmentManager shipmentManager = new ShipmentManager();
        shipmentManager.setItemDAO(mockItemDao);

		GoodsDelivery result = shipmentManager.buildNewShipment(new Customer(), new long[] {1});
		
		Assert.assertNotNull(result.getShippingCharge());
	}
	
	@Test
    public void testBuildShipmentWithNoCharge() {

        final ItemDAO mockItemDao = context.mock(ItemDAO.class);

		final LineItem lineItem = new LineItem();
		lineItem.setItemCost(1f);

        context.checking(new Expectations(){{
            oneOf(mockItemDao).retrieveItemBySKU(1l);
                will(returnValue(lineItem));
        }});

		ShipmentManager shipmentManager = new ShipmentManager();
        shipmentManager.setItemDAO(mockItemDao);

		
		GoodsDelivery result = shipmentManager.buildNewShipment(new Customer(), new long[] {1});
		
		Assert.assertNull(result.getShippingCharge());		
	}


}
