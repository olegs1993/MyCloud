package com.javapro.cloudservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Oleg on 05.03.2017.
 */
@Controller
public class Authorization {
    @RequestMapping(value = "/")
    public String start(){
        return "start";
    }
}
