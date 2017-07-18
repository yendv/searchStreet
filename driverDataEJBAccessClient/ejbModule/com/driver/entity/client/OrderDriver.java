package com.driver.entity.client;

import java.util.Date;

public interface OrderDriver extends java.io.Serializable{

	int getId();

	void setId(int id);

	Long getAccountID();

	void setAccountID(Long accountID);

	String getOrgin();

	void setOrgin(String orgin);

	String getDestination();

	void setDestination(String destination);

	String getTotalPrice();

	void setTotalPrice(String totalPrice);

	Long getStatus();

	void setStatus(Long status);

	Date getUpdateDate();

	void setUpdateDate(Date updateDate);

	Date getDeliveryDate();

	void setDeliveryDate(Date deliveryDate);

	Long getMerchandiseID();

	void setMerchandiseID(Long merchandiseID);

	Long getQuanlity();

	void setQuanlity(Long quanlity);

}
