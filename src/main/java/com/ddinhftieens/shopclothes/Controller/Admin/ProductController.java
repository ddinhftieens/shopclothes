package com.ddinhftieens.shopclothes.Controller.Admin;

import com.ddinhftieens.shopclothes.Entity.CatalogEntity;
import com.ddinhftieens.shopclothes.Entity.ProductEntity;
import com.ddinhftieens.shopclothes.Model.*;
import com.ddinhftieens.shopclothes.Service.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/admin/category/catalog/product")
public class ProductController {
    @Qualifier("catalogServiceImpl")
    @Autowired
    private ICommon catalogService;

    @Qualifier("productServiceImpl")
    @Autowired
    private ICommon iCommonproduct;

    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon catalogDAOImpl;

    @Autowired
    private ICommon statusProductServiceImpl;

    private int IDcatalog;

    @GetMapping("/all")
    public String product(@RequestParam("IDcatalog") int IDcatalog, Model model){
        this.IDcatalog = IDcatalog;
        CatalogEntity catalogEntity = (CatalogEntity) catalogDAOImpl.getbyID(IDcatalog);
        List<ProductEntity> productEntityList = catalogEntity.getProductEntityList();
        model.addAttribute("productList",productEntityList);
        model.addAttribute("product",new ProductDTO());
        return "admin/admin-product-all";
    }
    @PostMapping("/add")
    public String postproduct(@ModelAttribute("product") ProductDTO productDTO){
        final String UP_LOAD = "D:\\shopclothes\\product";
        String IDcode = System.currentTimeMillis()+"";
        String image = IDcode + ".jpg";
        Path path = Paths.get(UP_LOAD + File.separator+image);
        try {
            Files.write(path,productDTO.getMultipartFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        productDTO.setIDcode(IDcode);
        productDTO.setJoindate(Calendar.getInstance());
        productDTO.setCatalogDTO((CatalogDTO) catalogService.getbyID(this.IDcatalog));
        iCommonproduct.add(productDTO);
        statusProductServiceImpl.add(new StatusProductDTO("New",productDTO));
        return "redirect:/admin/category/catalog/product/all?IDcatalog=" + this.IDcatalog +"&message=save-success";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("IDproduct") int ID){
//        statusProductServiceImpl.delete(statusProductServiceImpl.);
        iCommonproduct.delete(iCommonproduct.getbyID(ID));
        return "redirect:/admin/category/catalog/product/all?IDcatalog=" + this.IDcatalog +"&message-delete-success";
    }
}
