package com.valtech.money.dao;

import com.valtech.money.model.LineItem;

public interface ItemDAO {

	LineItem retrieveItemBySKU(long skuCode);

}
