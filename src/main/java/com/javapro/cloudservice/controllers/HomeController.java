package com.javapro.cloudservice.controllers;
import com.javapro.cloudservice.entities.Files;
import com.javapro.cloudservice.entities.Folders;
import com.javapro.cloudservice.entities.Users;
import com.javapro.cloudservice.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * Created by Oleg on 23.02.2017.
 */
@Controller
//@RequestMapping(value = "/home")
public  class HomeController {
    Users user;
    @Autowired
    Service service;
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String main(@RequestParam ("nickname")String nickname, Model model){
        user=service.getUser(nickname);
        List<Folders> foldersList=service.getFolders(nickname);
        List<Files> filesList=service.getFiles(nickname,nickname);
        model.addAttribute("folders",foldersList);
        model.addAttribute("files",filesList);
        return "home";
    }
    @RequestMapping(value = "/{name}")
    public String getFolderContent(@PathVariable("name") String name, Model model){
        List<Folders> foldersList=service.getFolders(name);
        List<Files> filesList=service.getFiles(user.getNickname(),name);
        model.addAttribute("folders",foldersList);
        model.addAttribute("files",filesList);
        return "home";
    }
}
