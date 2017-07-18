/**
 * 
 */
package com.driver.entity.client;

import java.util.Date;

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
@Entity(name="OrderDriver")
@Table(name="ORDER_DRIVER")
@Cacheable(false)
public class OrderDriverImpl implements OrderDriver {
	@Id
	@SequenceGenerator(name = "ORDER_DRIVER_ID_GENERATOR", 
					   sequenceName = "ORDER_DRIVER_SEQ", allocationSize = 1)	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_DRIVER_ID_GENERATOR")
	private int id;
	
	@Column(name = "ACCOUNT_ID", nullable = false)
	private Long accountID;
	
	@Column(name = "ORGIN", length = 2000, nullable = false)
	private String orgin;
	
	@Column(name = "DESTINATION", length = 2000, nullable = false)
	private String destination;
	
	@Column(name = "TOTAL_PRICE", length = 2000, nullable = false)
	private String totalPrice;
	
	@Column(name = "STATUS", nullable = false)
	private Long status;
	
	@Column(name = "UPDATE_DATE", nullable = false)
	private Date updateDate;
	
	@Column(name = "DELIVERY_DATE", nullable = false)
	private Date deliveryDate;
	
	@Column(name = "MERCHANDISE_ID", nullable = false)
	private Long merchandiseID;
	
	@Column(name = "QUANLITY", nullable = false)
	private Long quanlity;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
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
	public String getOrgin() {
		return orgin;
	}

	@Override
	public void setOrgin(String orgin) {
		this.orgin = orgin;
	}

	@Override
	public String getDestination() {
		return destination;
	}

	@Override
	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String getTotalPrice() {
		return totalPrice;
	}

	@Override
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public Long getStatus() {
		return status;
	}

	@Override
	public void setStatus(Long status) {
		this.status = status;
	}

	@Override
	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	@Override
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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
	public Long getQuanlity() {
		return quanlity;
	}

	@Override
	public void setQuanlity(Long quanlity) {
		this.quanlity = quanlity;
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
		OrderDriverImpl other = (OrderDriverImpl) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
