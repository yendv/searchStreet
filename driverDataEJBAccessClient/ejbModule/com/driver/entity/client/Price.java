/**
 * 
 */
package com.driver.entity.client;

/**
 * @author dauvi
 *
 */
public interface Price extends java.io.Serializable{

	
	int getId();

	
	void setId(int id);

	
	Long getDriverTypeID();

	
	void setDriverTypeID(Long driverTypeID);

	
	String getHourBegin();

	
	void setHourBegin(String hourBegin);

	
	String getHourEnd();

	
	void setHourEnd(String hourEnd);

	
	Long getMerchandiseID();

	
	void setMerchandiseID(Long merchandiseID);

}
