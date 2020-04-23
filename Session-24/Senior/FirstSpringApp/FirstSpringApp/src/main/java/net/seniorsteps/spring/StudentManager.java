/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mostafa.Gazzar
 */
@Component
public class StudentManager {

    private String name;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired(required = false)
    private StudentTransformer transformer;

    public StudentManager() {
        this.name = "DEFAULT";
    }

    public StudentManager(String firatName, String lastName) {
        this.name = firatName + " " + lastName;

    }

    public StudentManager(int x) {
        this.name = "" + x;
    }

    public StudentManager(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Hello: " + name);
    }

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public StudentTransformer getTransformer() {
        return transformer;
    }

    public void setTransformer(StudentTransformer transformer) {
        this.transformer = transformer;
    }

}
