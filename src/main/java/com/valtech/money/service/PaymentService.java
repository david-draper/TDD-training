package com.valtech.money.service;

public interface PaymentService {
	
	public void makePayment(float money) throws PaymentException;

}
