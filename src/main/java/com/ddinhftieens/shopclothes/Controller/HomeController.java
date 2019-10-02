package com.ddinhftieens.shopclothes.Controller;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.DAO.Impl.NewsDAOImpl;
import com.ddinhftieens.shopclothes.DAO.Impl.StatusProductDAOImpl;
import com.ddinhftieens.shopclothes.Entity.CategoryEntity;
import com.ddinhftieens.shopclothes.Entity.ImageHomeEntity;
import com.ddinhftieens.shopclothes.Entity.NewsEntity;
import com.ddinhftieens.shopclothes.Entity.StatusProductEntity;
import com.ddinhftieens.shopclothes.Model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Qualifier("categoryDAOImpl")
    @Autowired
    private ICommon categoryDAOImpl;
    @Qualifier("imageHomeDAOImpl")
    @Autowired
    private ICommon imageHomeDAOImpl;

    @Autowired
    private StatusProductDAOImpl statusProductDAOImpl;
    @Autowired
    private NewsDAOImpl newsDAO;

    @GetMapping("/home")
    public String home(Model model, HttpSession session){
        List<CategoryEntity> categoryEntityList = categoryDAOImpl.getAll();
        List<ImageHomeEntity> imageHomeEntityList = imageHomeDAOImpl.getAll();
        model.addAttribute("imageHomeList",imageHomeEntityList);
        model.addAttribute("category",categoryEntityList);
        List<StatusProductEntity> statusProductEntityList = statusProductDAOImpl.getAll();
        model.addAttribute("newProduct",statusProductEntityList);
        model.addAttribute("register",new CustomerDTO());
        List<NewsEntity> newsEntityList = newsDAO.getAll();
        model.addAttribute("listNews",newsEntityList);
        return "home";
    }
}
