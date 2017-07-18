/**
 * 
 */
package com.driver.manager.client;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.driver.entity.client.DriverType;

/**
 * @author dauvi
 *
 */
@Stateless(mappedName = "DriverTypeManager")
public class DriverTypeManagerImpl implements DriverTypeManager {
	@PersistenceUnit(unitName = "driverDataAccessClient")
	private EntityManagerFactory emf;
	
	@Override
	public List<DriverType> search(String code , String name) {
		EntityManager em = emf.createEntityManager();
		try {
			String sql = "SELECT o FROM DriverType o  WHERE 1=1 ";
			if(code != null && code.trim().isEmpty() == false) sql += ("o.code like '%" + code + "%'");
			if(name != null && name.trim().isEmpty() == false) sql += ("o.name like '%" + name + "%'");
			Query query = em.createQuery(sql);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return null;
	}

}
