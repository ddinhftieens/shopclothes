package com.ddinhftieens.shopclothes.Controller.Admin;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.ImageHomeEntity;
import com.ddinhftieens.shopclothes.Model.ImageHomeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ImgEventController {
    @Autowired
    private ICommon imageHomeDAOImpl;
    @Autowired
    private com.ddinhftieens.shopclothes.Service.ICommon imageHomeServiceImpl;

    @GetMapping("/image/home-page")
    public String imagePage(Model model){
        List<ImageHomeEntity> imageHomeEntityList = imageHomeDAOImpl.getAll();
        model.addAttribute("imageHomeEntityList",imageHomeEntityList);
        model.addAttribute("imageHomeDTO",new ImageHomeDTO());
        return "admin/admin-image-homepage";
    }
    @PostMapping("/image/home-page")
    public String add(@ModelAttribute("imageHomeDTO") ImageHomeDTO imageHomeDTO){
        final String UP_LOAD = "D:\\shopclothes\\home";
        String IDcode = System.currentTimeMillis()+"";
        String image = IDcode + ".jpg";
        Path path = Paths.get(UP_LOAD + File.separator+image);
        try {
            Files.write(path,imageHomeDTO.getMultipartFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        imageHomeDTO.setImage(IDcode);
        imageHomeDTO.setDatecreated(Calendar.getInstance());
        imageHomeServiceImpl.add(imageHomeDTO);
        return "redirect:/admin/image/home-page";
    }
    @GetMapping("/image/home-page/delete")
    public String delete(@RequestParam("IDimage") int IDimage){
        imageHomeServiceImpl.delete(imageHomeServiceImpl.getbyID(IDimage));
        return "redirect:/admin/image/home-page";
    }
}
