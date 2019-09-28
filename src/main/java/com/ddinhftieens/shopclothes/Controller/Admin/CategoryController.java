package com.ddinhftieens.shopclothes.Controller.Admin;

import com.ddinhftieens.shopclothes.Model.CategoryDTO;
import com.ddinhftieens.shopclothes.Service.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    @Qualifier("categoryServiceImpl")
    @Autowired
    private ICommon categoryService;

    @GetMapping("/all")
    public String all(Model model){
        List<CategoryDTO> dtoList = categoryService.getAll();
        model.addAttribute("listcategory",dtoList);
        return "admin/admin-category-all";
    }
    @PostMapping("/add")
    public String add(@RequestParam("category-myInput") String category){
        CategoryDTO categoryDTO = new CategoryDTO(category,Calendar.getInstance());
        categoryService.add(categoryDTO);
        return "redirect:/admin/category/all?message=add-success";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("IDcategory") int ID){
        categoryService.delete(categoryService.getbyID(ID));
        return "redirect:/admin/category/all?message=delete-success";
    }
}
