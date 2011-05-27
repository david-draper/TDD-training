package com.valtech.checkout;

public interface Checkout {
	double total();
	void scan(String item);
	void complete();
	void setStockControlSystem(StockControlSystem sys);
}
