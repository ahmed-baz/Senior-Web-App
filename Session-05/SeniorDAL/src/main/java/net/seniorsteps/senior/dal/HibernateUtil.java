/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.dal;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Senior Steps
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null){
			buildSessionFactory();
		}
		return sessionFactory;
	}

	private static void buildSessionFactory() {
		StandardServiceRegistry registry = null;
		try {
			registry = new StandardServiceRegistryBuilder()
					.configure()
					.build();

			MetadataSources sources = new MetadataSources(registry);

			Metadata metadata = sources.getMetadataBuilder().build();

			sessionFactory = metadata.getSessionFactoryBuilder().build();
		} catch (Exception e) {
			if (registry != null) {
				StandardServiceRegistryBuilder.destroy(registry);
			}
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
