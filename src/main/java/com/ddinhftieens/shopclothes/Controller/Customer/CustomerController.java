package com.ddinhftieens.shopclothes.Controller.Customer;

import com.ddinhftieens.shopclothes.DAO.JDBCTemplate;
import com.ddinhftieens.shopclothes.Model.CustomerDTO;
import com.ddinhftieens.shopclothes.Model.ViewDTO;
import com.ddinhftieens.shopclothes.Service.CustomerService.UserServiceImpl;
import com.ddinhftieens.shopclothes.Service.Impl.ProductServiceImpl;
import com.ddinhftieens.shopclothes.Service.Impl.ViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/home")
public class CustomerController {
    @Autowired
    private JDBCTemplate jdbcTemplate;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ViewServiceImpl viewService;
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/product")
    public String detailProduct(@RequestParam("IDproduct") int IDproduct){
        ViewDTO viewDTO = new ViewDTO();
        viewDTO.setProductDTO(productService.getbyID(IDproduct));
        viewService.add(viewDTO);
        return "redirect:/home";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("register") CustomerDTO customerDTO, HttpSession session){
        String IDimage = System.currentTimeMillis()+"";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SSS");
        String current = simpleDateFormat.format(new Date().getTime());
        customerDTO.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customerDTO.setJoindate(current);
        customerDTO.setRole("ROLE_USER");
        if(this.jdbcTemplate.checkRegister(customerDTO,"register") == 0){
            final String UpLoad = "D:\\shopclothes\\avatar";
            if(!customerDTO.getMultipartFile().isEmpty()){
                Path path = Paths.get(UpLoad + File.separator +IDimage +".jpg");
                try {
                    Files.write(path,customerDTO.getMultipartFile().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                IDimage = "0000000000000";
            }
            customerDTO.setImageUser(IDimage);
            userService.add(customerDTO);
            session.setAttribute("user",customerDTO);
            return "redirect:/home?message=dang ki thanh cong";
        }
        else{
            return "redirect:/home?message=dang ki khong thanh cong";
        }
    }
    @GetMapping("/login")
    public String login(){
        return "loginForm";
    }
    @GetMapping("/logined")
    public String loginAccess(HttpSession session){
        final String UserName = SecurityContextHolder.getContext().getAuthentication().getName();
        session.setAttribute("user",userService.getbyName(UserName));
        return "redirect:/home";
    }
}
