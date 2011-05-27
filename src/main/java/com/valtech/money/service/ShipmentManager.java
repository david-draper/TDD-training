package com.valtech.money.service;

import com.valtech.money.dao.ItemDAO;
import com.valtech.money.model.Customer;
import com.valtech.money.model.GoodsDelivery;
import com.valtech.money.model.LineItem;

public class ShipmentManager {

	private static final float SHIPPING_CHARGE = 10.2f;
	private ItemDAO itemDAO;

	public GoodsDelivery buildNewShipment(Customer customer, long[] itemCodes){
		
		GoodsDelivery goodsDelivery = new GoodsDelivery();
		goodsDelivery.setShippingCharge(new Float(SHIPPING_CHARGE));
		
		for(int i = 0 ; i < itemCodes.length ; i++){
			LineItem lineItem = itemDAO.retrieveItemBySKU(itemCodes[i]);
			
			if(lineItem.getItemCost() != 0) {
				goodsDelivery.setShippingCharge(null);
			}	
			goodsDelivery.addItem(lineItem);
		}
	
		return goodsDelivery;
	}

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

}
