package com.javapro.cloudservice.controllers;
import com.javapro.cloudservice.entities.*;
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
@RequestMapping(value = "/",headers = "Accept= application/json")
public  class HomeController {
    @Autowired
    FileUtils fileUtils;
    @Autowired
    Service service;
    @RequestMapping(value ="/home/**/{name}/test",method = RequestMethod.GET)
    @ResponseBody
    public ContentList getFolderContent(@PathVariable("name") String name, @ModelAttribute Users users){
        List<Folders> foldersList=service.getFolders(name);
        List<Files> filesList=service.getFiles(users.getNickname(),name);
        ContentList contentList=new ContentList();
        contentList.setFilesList(filesList);
        contentList.setFoldersList(foldersList);
        return contentList;
    }
    @RequestMapping(value = "/home/**/{name}/addfile", method = RequestMethod.POST)
    @ResponseBody
    public void typedUploadFile(@PathVariable("name") String name, @RequestParam("file")MultipartFile multipartFile,@ModelAttribute Users users) throws IOException {
        service.addFiles(multipartFile.getOriginalFilename(),users.getNickname().trim(),name,multipartFile);

    }
    @RequestMapping(value ="/home/addfile",method = RequestMethod.POST)
    @ResponseBody
    public void uploadFile(@RequestParam("file")MultipartFile multipartFile,@ModelAttribute Users users) throws IOException {
        service.addFiles(multipartFile.getOriginalFilename(),users.getNickname().trim(),users.getNickname().trim(),multipartFile);

    }
    @RequestMapping(value = "/home/**/{name}/download", method = RequestMethod.GET )
    @ResponseBody
    public void typedDownloadFile(@PathVariable("name") String name, @ModelAttribute Users users,HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        service.downloadFile(name,users.getNickname().trim(),httpServletRequest,httpServletResponse);

    }
    @RequestMapping(value = "/home/**/{parentfolder}/addfolder", method = RequestMethod.POST)
    public String typedAddFolder( @RequestParam("foldername") String foldername,@PathVariable("parentfolder") String parentfolder,@ModelAttribute Users users){
      service.addFolder(foldername,parentfolder);
        return "redirect:/home/**/"+ parentfolder+"/test";
    }
    @RequestMapping(value = "/home/addfolder", method = RequestMethod.POST)
    public String dAddFolder( @RequestParam("foldername") String foldername,@ModelAttribute Users users){
        service.addFolder(foldername,users.getNickname());
        return "redirect:/home/test";
    }

}
