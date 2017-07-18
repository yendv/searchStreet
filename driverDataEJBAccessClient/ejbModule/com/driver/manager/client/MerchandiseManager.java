/**
 * 
 */
package com.driver.manager.client;

import java.util.List;

import javax.ejb.Remote;

import com.driver.entity.client.Merchandise;

/**
 * @author dauvi
 *
 */
@Remote
public interface MerchandiseManager {
	public List<Merchandise> search(String code, String name);
}
