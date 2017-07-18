package com.driver.entity.client;

public interface Driver extends java.io.Serializable{

	int getId();

	void setId(int id);

	String getName();

	void setName(String name);

	String getImage();

	void setImage(String image);

	String getPhone();

	void setPhone(String phone);

	String getCmt();

	void setCmt(String cmt);

	String getCarNumberPlate();

	void setCarNumberPlate(String carNumberPlate);

	String getDriverTypeID();

	void setDriverTypeID(String driverTypeID);

}
