package com.javapro.cloudservice.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




/**
 * Created by Oleg on 23.02.2017.
 */
@Controller
public  class Main {
 
    @RequestMapping(value = "/")

    public String main(){

        return "end";
    }
}
