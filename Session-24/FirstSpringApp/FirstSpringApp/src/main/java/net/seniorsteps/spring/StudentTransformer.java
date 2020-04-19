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
public class StudentTransformer {

    private String name;

    public StudentTransformer() {
        this.name = "Transformer";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
