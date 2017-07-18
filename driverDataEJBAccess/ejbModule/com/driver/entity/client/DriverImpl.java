/**
 * 
 */
package com.driver.entity.client;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author dauvi
 *
 */
@Entity(name="Driver")
@Table(name="DRIVER")
@Cacheable(false)
public class DriverImpl implements Driver {
	@Id
	@SequenceGenerator(name = "DRIVER_ID_GENERATOR", 
					   sequenceName = "DRIVER_SEQ", allocationSize = 1)	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DRIVER_ID_GENERATOR")
	private int id;
	
	@Column(name = "NAME", length = 250, nullable = false)
	private String name;
	
	@Column(name = "IMAGE", length = 250, nullable = false)
	private String image;
	
	@Column(name = "PHONE", length = 250, nullable = false)
	private String phone;
	
	@Column(name = "CMT", length = 250, nullable = false)
	private String cmt;
	
	@Column(name = "CAR_NUMBER_PLATE", length = 250, nullable = false)
	private String carNumberPlate;
	
	@Column(name = "DRIVE_TYPE_ID", nullable = false)
	private String driverTypeID;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getImage() {
		return image;
	}

	@Override
	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String getCmt() {
		return cmt;
	}

	@Override
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	@Override
	public String getCarNumberPlate() {
		return carNumberPlate;
	}

	@Override
	public void setCarNumberPlate(String carNumberPlate) {
		this.carNumberPlate = carNumberPlate;
	}

	@Override
	public String getDriverTypeID() {
		return driverTypeID;
	}

	@Override
	public void setDriverTypeID(String driverTypeID) {
		this.driverTypeID = driverTypeID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DriverImpl other = (DriverImpl) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
