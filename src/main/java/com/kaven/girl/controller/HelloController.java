package com.kaven.girl.controller;

import com.kaven.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

   @Autowired
   private GirlProperties girlProperties;

    @GetMapping(value = "/hello")
    public String say(@RequestParam(value = "id", required = false ,defaultValue = "110") Integer id){
        return id.toString();
    }
}
