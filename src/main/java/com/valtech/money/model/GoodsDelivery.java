package com.valtech.money.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GoodsDelivery {
	
	static final float MAX_SUPPORTED_VALUE = 999999.99f;
	private Float shippingCharge;
	private List<LineItem> itemsForDelivery = new ArrayList<LineItem>();

	public void setShippingCharge(Float shappingCharge) {
		this.shippingCharge = shappingCharge;
	}

	public void addItem(LineItem lineItem) {
		
		// Added in response to defect #622 - total exceeds max support val
		if(getDeliveryTotal().floatValue() + lineItem.getItemCost() > MAX_SUPPORTED_VALUE) {
			throw new MonetaryValueTooLargeException();
		}
		
		itemsForDelivery.add(lineItem);
	}

	public List<LineItem> getItemsForDelivery() {
		return itemsForDelivery;
	}

	public void setItemsForDelivery(List<LineItem> itemsForDelivery) {
		this.itemsForDelivery = itemsForDelivery;
	}

	public Float getShippingCharge() {
		return shippingCharge;
	}
	
	public Float getDeliveryTotal() {
		float total = 0;
		Iterator<LineItem> itr = itemsForDelivery.iterator();
		while(itr.hasNext()){
			total += itr.next().getItemCost();
		}
		return new Float(total);
	}

}
