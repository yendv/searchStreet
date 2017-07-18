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
@Entity(name="History")
@Table(name="HISTORY")
@Cacheable(false)
public class HistoryImpl implements History {
	@Id
	@SequenceGenerator(name = "HISTORY_ID_GENERATOR", 
					   sequenceName = "HISTORY_SEQ", allocationSize = 1)	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HISTORY_ID_GENERATOR")
	private int id;
	

	@Column(name = "ORGIN", length = 2000, nullable = false)
	private String orgin;
	
	@Column(name = "DISTIRATION", length = 2000, nullable = false)
	private String distiration;
	
	@Column(name = "ACCOUNT_ID", nullable = false)
	private Long accountID;
	
	@Column(name = "DRIVER_ID", nullable = false)
	private Long driverID;
	
	@Column(name = "TOTAL_PRICE", nullable = false)
	private Long totalPrice;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getOrgin() {
		return orgin;
	}

	@Override
	public void setOrgin(String orgin) {
		this.orgin = orgin;
	}

	@Override
	public String getDistiration() {
		return distiration;
	}

	@Override
	public void setDistiration(String distiration) {
		this.distiration = distiration;
	}

	@Override
	public Long getAccountID() {
		return accountID;
	}

	@Override
	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}

	@Override
	public Long getDriverID() {
		return driverID;
	}

	@Override
	public void setDriverID(Long driverID) {
		this.driverID = driverID;
	}

	@Override
	public Long getTotalPrice() {
		return totalPrice;
	}

	@Override
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
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
		HistoryImpl other = (HistoryImpl) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
