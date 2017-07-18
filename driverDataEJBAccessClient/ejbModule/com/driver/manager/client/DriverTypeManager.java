/**
 * 
 */
package com.driver.manager.client;

import java.util.List;

import javax.ejb.Remote;

import com.driver.entity.client.DriverType;

/**
 * @author dauvi
 *
 */
@Remote
public interface DriverTypeManager {
	public List<DriverType> search(String code , String name);
}
