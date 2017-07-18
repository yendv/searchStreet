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

@Entity(name="Guide")
@Table(name="GUIDE")
@Cacheable(false)
public class GuideImpl implements Guide {
private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "GUIDE_ID_GENERATOR", 
					   sequenceName = "GUIDE_SEQ", allocationSize = 1)	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GUIDE_ID_GENERATOR")
	private int id;
	
	@Column(name = "NAME", length = 250, nullable = false)
	private String name;
	
	@Column(name = "URL", length = 2000, nullable = false)
	private String url;
	
	@Column(name = "UPDATE_DATE", nullable = false)
	private Date updateDate;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getTen() {
		return name;
	}

	@Override
	public void setTen(String ten) {
		this.name = ten;
	}

	@Override
	public String getDuongDan() {
		return url;
	}

	@Override
	public void setDuongDan(String duongDan) {
		this.url = duongDan;
	}

	@Override
	public Date getNgayCapNhat() {
		return updateDate;
	}

	@Override
	public void setNgayCapNhat(Date ngayCapNhat) {
		this.updateDate = ngayCapNhat;
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
		GuideImpl other = (GuideImpl) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
