/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.spring.dal;

import net.seniorsteps.senior.spring.dal.entity.Area;
import net.seniorsteps.senior.spring.dal.entity.City;
import net.seniorsteps.senior.spring.dal.repo.CityRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



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
        ApplicationContext appCon = new ClassPathXmlApplicationContext("dal-spring-context.xml");
        CityRepo cityRepo = appCon.getBean("cityRepo", CityRepo.class);
//			cityDAO.add(new City("Test City 01", "Test City A"));
//			cityDAO.add(new City("Test City 03", "Test City 03"));
//			List<City> cityResultList = cityDAO.findLike("0");
//			List<City> cityResultList = cityDAO.findList();
//			List<City> cityResultList = cityDAO.findListByHQL();
//			List<City> cityResultList = cityDAO.findListByHQL();
//			for (City iCity : cityResultList) {
////				for (Area iArea : iCity.getAreas()) {
////				}
//			}
        City city = new City("HQL City Ar", "HQL City En");
        city.setId(13);
        City returnedCity = cityRepo.update(city);
//        for (Area iArea : returnedCity.getAreas()) {
//            System.out.println(iArea.getNameAr());
//        }
        System.out.println("ADDED");
//			for (City iCity : cityResultList) {
//				System.out.println(iCity.getNameAr() + " | " + iCity.getNameEn());
//				System.out.println("--  AREAS  --");
//				for (Area iArea : iCity.getAreas()) {
//					System.out.println("  -- | " + iArea.getNameAr());
//				}
//				System.out.println("-------------");
//			}
//			Long count = cityDAO.countLike("0");
//			System.out.println("CITIES COUNT : " + count);
        // 5. Close Connection`
        System.out.println("END");

    }
}
