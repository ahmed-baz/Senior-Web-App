/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.dal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.seniorsteps.senior.dal.entity.Area;
import net.seniorsteps.senior.dal.entity.City;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author Senior Steps
 */
public class SeniorDALMain {
	// 1 ..... 0
	// 2 ..... pageSize
	// 3 .... 
	
	private static int getFirstResultRelativeToPageNumber(int pageNumber, int pageSize){
		return (pageNumber - 1) * pageSize;
	}
	
	public static void main(String[] args) {
		try (Session session = DBConnectionManager.getSessionFactory().openSession()) {
			// 1. Open Connection
			session.getTransaction().begin();
			System.out.println("STRAT");

			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			CriteriaQuery<City> cityCirteriaQuery = builder.createQuery(City.class);
			Root<City> from = cityCirteriaQuery.from(City.class);
			cityCirteriaQuery.select(from);
//			cityCirteriaQuery.where(builder.equal(from.get("id"), 55));
			
			Query<City> cityQuery = session.createQuery(cityCirteriaQuery);
			cityQuery.setFirstResult(getFirstResultRelativeToPageNumber(1, 5));
			cityQuery.setMaxResults(5);
			System.out.println(cityQuery.getQueryString());
			List<City> cityResultList = cityQuery.getResultList();
			System.out.println("AFTER LIST");
			for (City iCity : cityResultList) {
				System.out.println(iCity.getNameAr());
			}
			
			City citySingleResult = cityQuery.getSingleResult();
			System.out.println("AFTER SINGLE");
			System.out.println(citySingleResult.getNameAr());
			

			session.getTransaction().commit();
			// 5. Close Connection`
			System.out.println("END");
		} catch (Exception e) {
			System.err.println(e.getMessage());
//			e.printStackTrace();
			System.out.println("EXCEPTION");
			Transaction currentTransaction = DBConnectionManager.getSessionFactory().getCurrentSession().getTransaction();
			if (currentTransaction.isActive()) {
				currentTransaction.rollback();
			}
		} finally {

		}
	}
}
