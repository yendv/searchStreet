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

@Entity(name="Price")
@Table(name="PRICE")
@Cacheable(false)
public class PriceImpl implements Price {
	@Id
	@SequenceGenerator(name = "PRICE_ID_GENERATOR", 
					   sequenceName = "PRICE_SEQ", allocationSize = 1)	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRICE_ID_GENERATOR")
	private int id;
	

	@Column(name = "DRIVER_TYPE_ID", nullable = false)
	private Long driverTypeID;
	
	@Column(name = "HOUR_BEGIN", nullable = false)
	private String hourBegin;
	
	@Column(name = "HOUR_END", nullable = false)
	private String hourEnd;
	
	@Column(name = "MERCHANDISE_ID", nullable = false)
	private Long merchandiseID;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Long getDriverTypeID() {
		return driverTypeID;
	}

	@Override
	public void setDriverTypeID(Long driverTypeID) {
		this.driverTypeID = driverTypeID;
	}

	@Override
	public String getHourBegin() {
		return hourBegin;
	}

	@Override
	public void setHourBegin(String hourBegin) {
		this.hourBegin = hourBegin;
	}

	@Override
	public String getHourEnd() {
		return hourEnd;
	}

	@Override
	public void setHourEnd(String hourEnd) {
		this.hourEnd = hourEnd;
	}

	@Override
	public Long getMerchandiseID() {
		return merchandiseID;
	}

	@Override
	public void setMerchandiseID(Long merchandiseID) {
		this.merchandiseID = merchandiseID;
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
		PriceImpl other = (PriceImpl) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
