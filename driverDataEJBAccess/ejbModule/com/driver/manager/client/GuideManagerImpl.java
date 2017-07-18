package com.driver.manager.client;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.driver.entity.client.Guide;


@Stateless(mappedName = "GuideManager")
public class GuideManagerImpl  implements GuideManager {
	@PersistenceUnit(unitName = "driverDataAccessClient")
	private EntityManagerFactory emf;

	@Override
	public List<Guide> getDmHuongDanSuDungList(String ten, String duongDan, Date ngayCapNhat) {
		String sql = "";
		EntityManager em = null;
		if(ten != null && ten.isEmpty() == false){
			if(sql.isEmpty() == true){
				sql = "WHERE ";
			}else{
				sql = (sql + " AND ");
			}
			sql = (sql + "o.ten like :ten ");
		}
		if(duongDan != null && duongDan.isEmpty() == false){
			if(sql.isEmpty() == true){
				sql = "WHERE ";
			}else{
				sql = (sql + " AND ");
			}
			sql = (sql + "o.duongDan like :duongDan ");
		}
		if(ngayCapNhat != null){
			if(sql.isEmpty() == true){
				sql = "WHERE ";
			}else{
				sql = (sql + " AND ");
			}
			sql = (sql + "o.ngayCapNhat = :ngayCapNhat ");
		}
		try {
			em = this.emf.createEntityManager();
			Query query = em.createQuery((("SELECT o FROM Guide o "+ sql)+""));
			if(ten != null && ten.isEmpty() == false){
				query.setParameter("ten", ten);
			}
			if(duongDan != null && duongDan.isEmpty() == false){
				query.setParameter("duongDan", duongDan);
			}
			if(ngayCapNhat != null ){
				query.setParameter("ngayCapNhat", ngayCapNhat);
			}
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		return null;
	}

	

}
