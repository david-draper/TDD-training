package com.valtech.money.model;

import junit.framework.TestCase;

public class LineItemTest extends TestCase {
	
	public void testValueFormat() {
		
		LineItem lineItem = new LineItem();
		lineItem.setItemCost(1f);
		assertEquals("£1.00", lineItem.getFormattedCost());
	}

	public void testMaxValueFormatted() {
		
		LineItem lineItem = new LineItem();
		lineItem.setItemCost(123456.78f);
		assertEquals("£123,456.78", lineItem.getFormattedCost());
	}
}
