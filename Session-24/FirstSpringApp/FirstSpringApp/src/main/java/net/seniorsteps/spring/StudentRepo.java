/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.spring;

import org.springframework.stereotype.Component;

/**
 *
 * @author Mostafa.Gazzar
 */
@Component
public class StudentRepo {

    private String name;
    private int count;

    public StudentRepo() {
        this.name = "TEST";
    }

    public String getName() {
        count++;
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

}
