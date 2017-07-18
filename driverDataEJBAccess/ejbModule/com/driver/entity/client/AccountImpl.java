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
@Entity(name="Account")
@Table(name="ACCOUNT")
@Cacheable(false)
public class AccountImpl implements Account {
	@Id
	@SequenceGenerator(name = "ACCOUNT_ID_GENERATOR", 
					   sequenceName = "ACCOUNT_SEQ", allocationSize = 1)	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_ID_GENERATOR")
	private int id;
	
	@Column(name = "ID_SOCIAL", length = 2000, nullable = false)
	private String idSocial;
	
	@Column(name = "NAME", length = 2000, nullable = false)
	private String name;
	
	@Column(name = "PHONE", length = 2000, nullable = false)
	private String phone;
	
	@Column(name = "CMT", length = 2000, nullable = false)
	private String cmt;
	
	@Column(name = "SEX", nullable = false)
	private Double sex;
	
	@Column(name = "BIRTH_DAY", nullable = false)
	private Date birthDay;
	
	@Column(name = "USER_NAME", length = 2000, nullable = false)
	private Double userName;
	
	@Column(name = "PASSWORD", length = 2000, nullable = false)
	private Double passWord;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getIdSocial() {
		return idSocial;
	}

	@Override
	public void setIdSocial(String idSocial) {
		this.idSocial = idSocial;
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
	public Double getSex() {
		return sex;
	}

	@Override
	public void setSex(Double sex) {
		this.sex = sex;
	}

	@Override
	public Date getBirthDay() {
		return birthDay;
	}

	@Override
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public Double getUserName() {
		return userName;
	}

	@Override
	public void setUserName(Double userName) {
		this.userName = userName;
	}

	@Override
	public Double getPassWord() {
		return passWord;
	}

	@Override
	public void setPassWord(Double passWord) {
		this.passWord = passWord;
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
		AccountImpl other = (AccountImpl) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
