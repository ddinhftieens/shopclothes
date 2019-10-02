package com.ddinhftieens.shopclothes.Controller.Admin;

import com.ddinhftieens.shopclothes.DAO.Impl.NewsDAOImpl;
import com.ddinhftieens.shopclothes.Entity.NewsEntity;
import com.ddinhftieens.shopclothes.Model.CustomerDTO;
import com.ddinhftieens.shopclothes.Model.NewsDTO;
import com.ddinhftieens.shopclothes.Service.Impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class NewsController {
    @Autowired
    private NewsServiceImpl newsService;
    @Autowired
    private NewsDAOImpl newsDAO;

    @GetMapping("/news/all")
    public String news(Model model){
        model.addAttribute("news",new NewsDTO());
        List<NewsEntity> newsEntityList = newsDAO.getAll();
        model.addAttribute("listNews",newsEntityList);
        return "admin/admin-news";
    }
    @PostMapping("/news/all")
    public String addNews(@ModelAttribute("news") NewsDTO newsDTO, HttpSession session){
        String IDimage = System.currentTimeMillis()+"";
        newsDTO.setIDimage(IDimage);
        Date date = new Date();
        SimpleDateFormat datecreated = new SimpleDateFormat("yyyy-MM-dd");
        String current = datecreated.format(new Date().getTime());
        newsDTO.setDatecreated(current);
        final String UPLOAD = "D:\\shopclothes\\news";
        Path path = Paths.get(UPLOAD + File.separator + IDimage + ".jpg");
        try {
            Files.write(path,newsDTO.getMultipartFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        CustomerDTO customerDTO = (CustomerDTO) session.getAttribute("user");
        newsDTO.setCustomerDTO(customerDTO);
        newsService.add(newsDTO);
        return "redirect:/admin/news/all";
    }

}
