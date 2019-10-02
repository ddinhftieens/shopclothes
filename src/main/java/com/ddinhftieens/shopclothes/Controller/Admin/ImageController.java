package com.ddinhftieens.shopclothes.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ImageController {
    @GetMapping("/image/product")
    public void getImage(@RequestParam("IDcode") String IDcode, HttpServletResponse httpServletResponse){
        final String UP_LOAD = "D:\\shopclothes\\product";
        File file = new File(UP_LOAD+File.separator+IDcode+".jpg");
        if(file.exists()){
            try {
                Files.copy(file.toPath(),httpServletResponse.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @GetMapping("/image/product/color")
    public void getImageColor(@RequestParam("IDcode") String IDcode, HttpServletResponse httpServletResponse){
        final String UP_LOAD = "D:\\shopclothes\\product\\color";
        File file = new File(UP_LOAD+File.separator+IDcode+".jpg");
        if(file.exists()){
            try {
                Files.copy(file.toPath(),httpServletResponse.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @GetMapping("/image/logo")
    public void getImageLogo(HttpServletResponse httpServletResponse){
        final String UP_LOAD = "C:\\Users\\Dell\\IdeaProjects\\shopclothes\\src\\main\\resources\\static\\images";
        File file = new File(UP_LOAD+File.separator+"logo.jpg");
        if(file.exists()){
            try {
                Files.copy(file.toPath(),httpServletResponse.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @GetMapping("/image/home-page")
    public void getImageHome(@RequestParam("IDcode") String IDcode, HttpServletResponse httpServletResponse){
        final String UP_LOAD = "D:\\shopclothes\\home";
        File file = new File(UP_LOAD+File.separator+IDcode+".jpg");
        if(file.exists()){
            try {
                Files.copy(file.toPath(),httpServletResponse.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @GetMapping("/image/news")
    public void getNews(@RequestParam("IDcode") String IDcode, HttpServletResponse httpServletResponse){
        final String UP_LOAD = "D:\\shopclothes\\news";
        File file = new File(UP_LOAD+File.separator+IDcode+".jpg");
        if(file.exists()){
            try {
                Files.copy(file.toPath(),httpServletResponse.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
