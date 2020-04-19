/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.dal;

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
			City city = new City("Aswan Ar", "Aswan EN");
			session.save(city);
			session.getTransaction().commit();
			// some code
			// 5. Close Connection`
			System.out.println("END");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			Transaction currentTransaction = DBConnectionManager.getSessionFactory().getCurrentSession().getTransaction();
			if (currentTransaction.isActive()) {
				currentTransaction.rollback();
			}
		} finally {

		}
	}
}
