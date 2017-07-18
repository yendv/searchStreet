package com.driver.entity.client;

import java.io.Serializable;
import java.util.Date;

public interface Guide extends Serializable{

	int getId();

	void setId(int id);

	String getTen();

	void setTen(String ten);

	String getDuongDan();

	void setDuongDan(String duongDan);

	Date getNgayCapNhat();

	void setNgayCapNhat(Date ngayCapNhat);
	
}
