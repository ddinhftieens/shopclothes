package com.ddinhftieens.shopclothes.Controller;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.CategoryEntity;
import com.ddinhftieens.shopclothes.Entity.ImageHomeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Qualifier("categoryDAOImpl")
    @Autowired
    private ICommon categoryDAOImpl;
    @Qualifier("imageHomeDAOImpl")
    @Autowired
    private ICommon imageHomeDAOImpl;

    @GetMapping("/home")
    public String home(Model model){
        List<CategoryEntity> categoryEntityList = categoryDAOImpl.getAll();
        List<ImageHomeEntity> imageHomeEntityList = imageHomeDAOImpl.getAll();
        model.addAttribute("imageHomeList",imageHomeEntityList);
        model.addAttribute("category",categoryEntityList);
        return "home";
    }
}
