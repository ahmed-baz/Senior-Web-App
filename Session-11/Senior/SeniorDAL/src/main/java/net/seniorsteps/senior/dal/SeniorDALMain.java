/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.dal;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import net.seniorsteps.senior.dal.entity.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import static net.seniorsteps.senior.dal.DBConnectionManager.*;
import net.seniorsteps.senior.dal.dao.CityDAO;

/**
 *
 * @author Senior Steps
 */
public class SeniorDALMain {
	// 1 ..... 0
	// 2 ..... pageSize
	// 3 .... 

	private static int getFirstResultRelativeToPageNumber(int pageNumber, int pageSize) {
		return (pageNumber - 1) * pageSize;
	}

	public static void main(String[] args) {
		try (Session session = openSession()) {
			// 1. Open Connection
			beginTransaction();
			System.out.println("STRAT");
			CityDAO cityDAO = new CityDAO();
//			cityDAO.add(new City("Test City 01", "Test City A"));
//			cityDAO.add(new City("Test City 03", "Test City 03"));
			List<City> cityResultList = cityDAO.findLike("0");
//			List<City> cityResultList = cityDAO.findList();
			System.out.println("AFTER LIST");
			for (City iCity : cityResultList) {
				System.out.println(iCity.getNameAr() + " | " + iCity.getNameEn());
			}
			Long count = cityDAO.countLike("0");
			System.out.println("CITIES COUNT : " + count);
			commitTransaction();
			// 5. Close Connection`
			System.out.println("END");
		} catch (Exception e) {
			System.err.println(e.getMessage());
//			e.printStackTrace();
			System.out.println("EXCEPTION");
			if (isActiveTransaction()) {
				rollbackTransaction();
			}
		} finally {

		}
	}
}
