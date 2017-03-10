package com.javapro.cloudservice.controllers;

import com.javapro.cloudservice.entities.Files;
import com.javapro.cloudservice.entities.Folders;
import com.javapro.cloudservice.entities.Users;
import com.javapro.cloudservice.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Oleg on 05.03.2017.
 */
@Controller
@SessionAttributes(types=Users.class)
public class AuthorizationController {
    @Autowired
    Service service;

    @RequestMapping(value = "/")
    public String start(){
        return "start";
    }

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String main(@RequestParam ("nickname")String nickname, Model model, HttpServletRequest request){
        model.addAttribute(service.getUser(nickname));
        List<Folders> foldersList=service.getFolders(nickname);
        List<Files> filesList=service.getFiles(nickname,nickname);
        model.addAttribute("folders",foldersList);
        model.addAttribute("files",filesList);
        model.addAttribute("path",request.getRequestURI());
        return "home";
    }
 }
