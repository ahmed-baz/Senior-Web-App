/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.dal;

import org.hibernate.Session;

/**
 *
 * @author Senior Steps
 */
public class SeniorDALMain {
	public static void main(String[] args) {
		// 1. Open Connection
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Session Opened");
		
		
		// 5. Close Connection`
		session.close();
		System.out.println("Session Closed");
	}
}
