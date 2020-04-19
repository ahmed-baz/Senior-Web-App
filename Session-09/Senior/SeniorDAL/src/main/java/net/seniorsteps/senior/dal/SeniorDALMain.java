/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.dal;

import java.util.HashSet;
import java.util.Set;
import net.seniorsteps.senior.dal.entity.Area;
import net.seniorsteps.senior.dal.entity.City;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Senior Steps
 */
public class SeniorDALMain {

	public static void main(String[] args) {
		try (Session session = DBConnectionManager.getSessionFactory().openSession()) {
			// 1. Open Connection
			session.getTransaction().begin();
			System.out.println("STRAT");
			
			City city = new City("UPDATED Beni Suef AR", "UPDATED Beni Suef EN");
			city.setId(10);
//			Area area = new Area(city, "Maadi AR", "Maadi EN");
//			Set<Area> areas = new HashSet<>();
//			areas.add(new Area(city, "Maadi Ar", "Maadi En"));
//			areas.add(new Area(city, "Nasr City Ar", "Nasr City En"));
//			areas.add(new Area(city, "Heliopolis Ar", "Heliopolis En"));
//			city.setAreas(areas);
			session.merge(city);

//			session.persist(city);
//			session.delete(city);
//			System.out.println(city.getId());
//			City getCity = session.get(City.class, 2);
//			System.out.println("GET_CITY : " + getCity.getNameAr());
//			City loadCity = session.load(City.class, 1);
//			System.out.println("LOAD_CITY Name : " + loadCity.getNameAr());
			session.getTransaction().commit();
			// some code
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
