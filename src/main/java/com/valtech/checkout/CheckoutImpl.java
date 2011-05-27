package com.valtech.checkout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckoutImpl implements Checkout {
	// Simple implementation of a price list
	private Map<String,Double> priceList = new java.util.HashMap<String,Double>();
	private List<String> items = new ArrayList<String>();
	private double total = 0.0;
	private StockControlSystem stockControlSystem = null;
 
	
	public CheckoutImpl() {
		priceList.put("banana", 1.0);
		priceList.put("apple", 2.0);
		priceList.put("pear", 1.99);
		priceList.put("grapes", 5.99);
		priceList.put("orange", 20.0);
	}
	
	public double total() {
//		double sum = 0.0;
//		for (String item : items){
//			sum += priceList.get(item);
//		}
//		return sum;
		return total;
	}	
	public void scan(String item) {
		if (!priceList.keySet().contains(item)) {
			throw new RuntimeException("Item not in the inventory: " + item);
		} else {
			items.add(item);
			total += priceList.get(item);
		}
	}
	public void complete() {
		for (String item : items)
			stockControlSystem.decrementStockCount(item);
	}
	public void setStockControlSystem(StockControlSystem sys) {
		this.stockControlSystem = sys;
	}
}
