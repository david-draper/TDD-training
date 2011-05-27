/**
 * 
 */
package com.valtech.refactoring.decomposeConditionals;

import java.util.Calendar;
import junit.framework.Assert;

import org.junit.Test;


public class CodeTest {
	/**
	 * Test method for {@link com.valtech.refactoring.decomposeConditionals.Code#calculateEconomy7(java.util.Date, double)}.
	 */
	@Test
	public void calculateDayRate() {
		Code c = new Code();
		
		Calendar cal = Calendar.getInstance();		
		cal.set(2007, 10, 10, 13, 0, 0);

		Assert.assertEquals(2.0, c.calculateEconomy7(cal.getTime(), 20));
	}
	
	/**
	 * Test method for {@link com.valtech.refactoring.decomposeConditionals.Code#calculateEconomy7(java.util.Date, double)}.
	 */
	@Test
	public void calculateNightRate() {
		Code c = new Code();
		
		Calendar cal = Calendar.getInstance();		
		cal.set(2007, 10, 10, 23, 30, 0);

		Assert.assertEquals(1.6, c.calculateEconomy7(cal.getTime(), 20));
	}
}
