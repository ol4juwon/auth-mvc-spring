package com.ol4juwon.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
public class TestController {

    @RequestMapping("/test")
    public String getTest(){
        // Users u = new Users("Ola", "juwon");
        // Users u1 = new Users("TOla", "juwon");
        // return u.toString()+"<br/><br/>"+ u1;
        return "usrers";
    }
    
}
