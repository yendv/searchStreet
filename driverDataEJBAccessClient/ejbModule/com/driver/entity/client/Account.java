package com.driver.entity.client;

import java.util.Date;

public interface Account extends java.io.Serializable {

	int getId();

	void setId(int id);

	String getIdSocial();

	void setIdSocial(String idSocial);

	String getName();

	void setName(String name);

	String getPhone();

	void setPhone(String phone);

	String getCmt();

	void setCmt(String cmt);

	Double getSex();

	void setSex(Double sex);

	Date getBirthDay();

	void setBirthDay(Date birthDay);

	Double getUserName();

	void setUserName(Double userName);

	Double getPassWord();

	void setPassWord(Double passWord);

}
