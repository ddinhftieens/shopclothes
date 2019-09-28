package com.ddinhftieens.shopclothes.Controller.Admin;

import com.ddinhftieens.shopclothes.Entity.CatalogEntity;
import com.ddinhftieens.shopclothes.Entity.CategoryEntity;
import com.ddinhftieens.shopclothes.Model.CatalogDTO;
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
@RequestMapping("/admin/category/catalog")
public class CatalogController {

    @Qualifier("categoryServiceImpl")
    @Autowired
    private ICommon categoryService;

    @Qualifier("catalogServiceImpl")
    @Autowired
    private ICommon catalogService;

    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon categoryDAOImpl;

    private int IDcategory;

    @GetMapping("/all")
    public String addcatalog(@RequestParam("IDcategory") int IDcategory,Model model){
        this.IDcategory = IDcategory;
        CategoryEntity categoryEntity = (CategoryEntity) categoryDAOImpl.getbyID(IDcategory);
        List<CatalogEntity> catalogEntityList = categoryEntity.getCatalogEntityList();
        model.addAttribute("catalogs",catalogEntityList);
        return "admin/admin-catalog-all";
    }
    @PostMapping("/add")
    public String postcatalog(@RequestParam("catalog-myInput") String myInput){
        CatalogDTO catalogDTO = new CatalogDTO(myInput, Calendar.getInstance(),(CategoryDTO) categoryService.getbyID(this.IDcategory));
        catalogService.add(catalogDTO);
        return "redirect:/admin/category/catalog/all?IDcategory="+this.IDcategory+"&message=add-success";
    }
    @GetMapping("/delete")
    public String deletecatalog(@RequestParam("IDcatalog") int ID){
        catalogService.delete(catalogService.getbyID(ID));
        return "redirect:/admin/category/catalog/all?IDcategory="+this.IDcategory+"&message=delete-success";
    }
}
