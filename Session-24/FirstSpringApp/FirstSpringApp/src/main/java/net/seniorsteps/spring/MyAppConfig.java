/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Mostafa.Gazzar
 */
@Configuration
public class MyAppConfig {

    @Bean
    public StudentRepo myStudentRepo() {
        StudentRepo studentRepo = new StudentRepo();
        studentRepo.setName("Using Java Configuration");
        return studentRepo;
    }

    @Bean
    public StudentManager myStudentManager() {
        StudentManager studentManager = new StudentManager();
//        studentManager.setStudentRepo(studentRepo);
        return studentManager;
    }

}
