/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Mostafa.Gazzar
 */
public class StudentDemo {

    public static void main(String[] args) {
//        ApplicationContext appCon = new ClassPathXmlApplicationContext("annotationContext.xml");
//        StudentManager studentManager = appCon.getBean("studentManager", StudentManager.class);
//        studentManager.displayInfo();
//        System.out.println(studentManager.getRepo().getName());
//        System.out.println(studentManager.getRepo1().getName());
//        System.out.println(studentManager.getTransformer().getName());
//        StudentRepo repo1 = appCon.getBean("studentRepo", StudentRepo.class);
//        StudentRepo repo2 = appCon.getBean("studentRepo", StudentRepo.class);
//        System.out.println(repo1.getName());
//        System.out.println(repo1.getName());
//        System.out.println(repo1.getName());
//        System.out.println(repo1.getCount());
//        System.out.println(repo2.getCount());
//        StudentTransformer transformer
//                = (StudentTransformer) appCon.getBean("studentTransformer", "Physics");
//        StudentTransformer transformer2
//                = (StudentTransformer) appCon.getBean("studentTransformer", "Math");
//        System.out.println(transformer.getName());
//        System.out.println(transformer2.getName());
//
//        StudentManager studentManager = appCon.getBean("studentManager", StudentManager.class);
//
//        System.out.println(studentManager.getStudentRepo().getCount());
//        StudentManager anotherStudentBean = new StudentManager();
//        anotherStudentBean.setName("Out of Context");
//        anotherStudentBean.displayInfo();
        ApplicationContext appCon = new AnnotationConfigApplicationContext(MyAppConfig.class);
        StudentManager studentManager = appCon.getBean(StudentManager.class);
        System.out.println(studentManager.getStudentRepo().getName());
    }
}
