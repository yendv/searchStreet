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
@Entity(name="DriverType")
@Table(name="DRIVER_TYPE")
@Cacheable(false)
public class DriverTypeImpl implements DriverType {
	@Id
	@SequenceGenerator(name = "DRIVER_TYPE_ID_GENERATOR", 
					   sequenceName = "DRIVER_TYPE_SEQ", allocationSize = 1)	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DRIVER_TYPE_ID_GENERATOR")
	private int id;
	
	@Column(name = "CODE", length = 20, nullable = false)
	private String code;
	
	@Column(name = "NAME", length = 20, nullable = false)
	private String name;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
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
		DriverTypeImpl other = (DriverTypeImpl) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
