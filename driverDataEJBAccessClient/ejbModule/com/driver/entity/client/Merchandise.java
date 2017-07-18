/**
 * 
 */
package com.driver.entity.client;

import java.io.Serializable;

/**
 * @author dauvi
 *
 */
public interface Merchandise extends Serializable {

	int getId();

	void setId(int id);

	String getCode();

	void setCode(String code);

	String getName();

	void setName(String name);

}
