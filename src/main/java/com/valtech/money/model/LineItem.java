package com.valtech.money.model;

import java.text.NumberFormat;

public class LineItem {
	
	private static final float MAX_SUPPORTED_VALUE = 999999.99f;
	private float itemCost;
	private long skuCode;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(long skuCode) {
		this.skuCode = skuCode;
	}

	public float getItemCost() {
		return itemCost;
	}

	public void setItemCost(float itemCost) {
		if(itemCost > MAX_SUPPORTED_VALUE)
			throw new MonetaryValueTooLargeException();
		
		this.itemCost = itemCost;
	}

	public String getFormattedCost() {
		NumberFormat formater = NumberFormat.getCurrencyInstance();
		return formater.format(itemCost);
	}
	
	

}
