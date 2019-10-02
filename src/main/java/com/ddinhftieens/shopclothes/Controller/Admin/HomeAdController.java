package com.ddinhftieens.shopclothes.Controller.Admin;

import com.ddinhftieens.shopclothes.DAO.Impl.StatusProductDAOImpl;
import com.ddinhftieens.shopclothes.DAO.JDBCTemplate;
import com.ddinhftieens.shopclothes.Entity.StatusProductEntity;
import com.ddinhftieens.shopclothes.Service.CustomerService.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class HomeAdController {
    @Autowired
    private JDBCTemplate jdbcTemplate;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private StatusProductDAOImpl statusProductDAO;
    @GetMapping("/home")
    public String home(){
        return "admin/admin-home";
    }

    @GetMapping("/home/logined")
    public String logined(HttpSession session){
        final String UserName = SecurityContextHolder.getContext().getAuthentication().getName();
        session.setAttribute("user",userService.getbyName(UserName));
        return "redirect:/admin/home";
    }
    @GetMapping("/home-page/newproduct")
    public String newproduct(Model model){
        List<StatusProductEntity> statusProductEntityList = statusProductDAO.getAll();
        model.addAttribute("newProduct",statusProductEntityList);
        return "admin/admin-homepage-newproduct";
    }
    @GetMapping("/home-page/newproduct/edit")
    public String editNewproduct(@RequestParam("IDstatus") int IDstatus){
        jdbcTemplate.statusProduct(IDstatus,"Old");
        return "redirect:/admin/home-page/newproduct";
    }
}
