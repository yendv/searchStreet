package com.driver.entity.client;

public interface History extends java.io.Serializable{

	int getId();

	void setId(int id);

	String getOrgin();

	void setOrgin(String orgin);

	String getDistiration();

	void setDistiration(String distiration);

	Long getAccountID();

	void setAccountID(Long accountID);

	Long getDriverID();

	void setDriverID(Long driverID);

	Long getTotalPrice();

	void setTotalPrice(Long totalPrice);

}
