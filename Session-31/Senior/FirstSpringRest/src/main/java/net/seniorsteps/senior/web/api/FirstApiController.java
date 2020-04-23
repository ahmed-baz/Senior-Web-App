/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.seniorsteps.senior.web.api;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mostafa.Gazzar
 */
@RestController
public class FirstApiController {

    @Autowired

    @GetMapping("getHome")
    public String getHome() {
        return "Hello get";
    }

    @PostMapping("/postHome")
    public CityBean postHome(@RequestBody CityBean cityBean) {
        cityBean.setNameEn("Server Name");
        return cityBean;
    }

    @PutMapping("/putHome")
    public void putHome() {
    }

    @DeleteMapping("/deleteHome")
    public void deleteHome() {
    }
}
