package com.javapro.cloudservice.controllers;
import com.javapro.cloudservice.entities.Files;
import com.javapro.cloudservice.entities.Folders;
import com.javapro.cloudservice.entities.Users;
import com.javapro.cloudservice.service.Service;
import com.javapro.cloudservice.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * Created by Oleg on 23.02.2017.
 */
@Controller
@SessionAttributes(types=Users.class)
//@RequestMapping(value = "/home/**")
public  class HomeController {
    @Autowired
    FileUtils fileUtils;
    @Autowired
    Service service;
    @RequestMapping(value ="/home/**/{name}")
    public String getFolderContent(@PathVariable("name") String name, Model model, @ModelAttribute Users users, HttpServletRequest request){
        List<Folders> foldersList=service.getFolders(name);
        List<Files> filesList=service.getFiles(users.getNickname(),name);
        model.addAttribute("folders",foldersList);
        model.addAttribute("files",filesList);
        model.addAttribute("path",request.getRequestURI());
        return "home";
    }
    @RequestMapping(value = "/home/**/{name}/addfile", method = RequestMethod.POST)//headers="Accept=application/json"
    @ResponseBody
    public String typedUploadFile(@PathVariable("name") String name, @RequestParam("file")MultipartFile multipartFile,@ModelAttribute Users users){
        service.addFiles(multipartFile.getOriginalFilename(),users.getNickname().trim(),name,multipartFile);
        return "Success";
    }
    @RequestMapping(value ="/home/addfile",method = RequestMethod.POST)//headers="Accept=application/json"
    @ResponseBody
    public String uploadFile(@RequestParam("file")MultipartFile multipartFile,@ModelAttribute Users users){
        service.addFiles(multipartFile.getOriginalFilename(),users.getNickname().trim(),users.getNickname().trim(),multipartFile);
        return "Success";
    }
    @RequestMapping(value = "/home/**/{name}/download", method = RequestMethod.GET )
    @ResponseBody
    public void typedDownloadFile(@PathVariable("name") String name, @ModelAttribute Users users, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename="+name);
        service.downloadFile(name,users.getNickname().trim(),httpServletResponse.getOutputStream());
        httpServletResponse.flushBuffer();

    }
    @RequestMapping(value = "/home/{name}/download", method = RequestMethod.GET )
    @ResponseBody
    public void downloadFile(@PathVariable("name") String name, @ModelAttribute Users users, HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename="+name);
        service.downloadFile(name,users.getNickname().trim(),httpServletResponse.getOutputStream());
        httpServletResponse.flushBuffer();

    }
}
