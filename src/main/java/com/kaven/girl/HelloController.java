package com.kaven.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Kaven
 * @date 2018/10/12 14:18
 */
@RestController
public class HelloController {

   @Autowired
   private  GirlProperties girlProperties;

    @GetMapping(value = "/hello")
    public String say(@RequestParam(value = "id", required = false ,defaultValue = "110") Integer id){
        return id.toString();
    }
}
