package com.valtech.money.model;

import junit.framework.TestCase;

public class GoodsDeliveryTest extends TestCase {
	
	public void testAddItemsGetTotal() {
		
		LineItem lineItem1 = new LineItem();
		lineItem1.setItemCost(1);
		
		LineItem lineItem2 = new LineItem();
		lineItem2.setItemCost(2);	
		
		GoodsDelivery goodsDelivery = new GoodsDelivery();
		assertEquals(new Float(0), goodsDelivery.getDeliveryTotal());
		
		goodsDelivery.addItem(lineItem1);
		assertEquals(new Float(1), goodsDelivery.getDeliveryTotal());
		
		goodsDelivery.addItem(lineItem2);
		assertEquals(new Float(3), goodsDelivery.getDeliveryTotal());	
	}
	
	public void testExceedMaxValue() {
		LineItem lineItem1 = new LineItem();
		lineItem1.setItemCost(GoodsDelivery.MAX_SUPPORTED_VALUE);
		
		GoodsDelivery goodsDelivery = new GoodsDelivery();
		
		goodsDelivery.addItem(lineItem1);
		assertEquals(GoodsDelivery.MAX_SUPPORTED_VALUE, goodsDelivery.getDeliveryTotal());
		
		try {
			LineItem lineItem2 = new LineItem();
			lineItem2.setItemCost(1);
			goodsDelivery.addItem(lineItem2);
			fail("Expecting MonetaryValueTooLargeException");
		}
		catch(MonetaryValueTooLargeException e){
			// Expected
		}		
	
		assertEquals(GoodsDelivery.MAX_SUPPORTED_VALUE, goodsDelivery.getDeliveryTotal());
	}

}
