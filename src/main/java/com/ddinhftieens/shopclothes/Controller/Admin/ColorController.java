package com.ddinhftieens.shopclothes.Controller.Admin;

import com.ddinhftieens.shopclothes.Entity.ColorEntity;
import com.ddinhftieens.shopclothes.Entity.ProductEntity;
import com.ddinhftieens.shopclothes.Entity.SizeEntity;
import com.ddinhftieens.shopclothes.Model.ColorDTO;
import com.ddinhftieens.shopclothes.Model.ProductDTO;
import com.ddinhftieens.shopclothes.Service.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/category/catalog/product/color")
public class ColorController {

    @Qualifier("productServiceImpl")
    @Autowired
    private ICommon productServiceImpl;

    @Autowired
    private ICommon colorServiceImpl;

    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon productDAOImpl;

    private int ID;

    @GetMapping("/all")
    public String all(@RequestParam("IDproduct") int IDproduct, Model model, HttpServletRequest httpServletRequest){
        this.ID = IDproduct;
        ProductEntity productEntity = (ProductEntity) productDAOImpl.getbyID(IDproduct);
        List<ColorEntity> colorEntityList = productEntity.getColorEntityList();
        Map<ColorEntity,Integer> colorEntityIntegerMap = new HashMap<>();
        for(ColorEntity i:colorEntityList){
            List<SizeEntity> sizeEntityList = i.getSizeEntityList();
            int quantity = 0;
            for(SizeEntity j:sizeEntityList){
                quantity = quantity + j.getQuantity();
            }
            colorEntityIntegerMap.put(i,quantity);
        }
        model.addAttribute("colorEntityIntegerMap",colorEntityIntegerMap);
        model.addAttribute("product",(ProductDTO) productServiceImpl.getbyID(IDproduct));
        model.addAttribute("color",new ColorDTO());
        return "admin/admin-product-color-all";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("color") ColorDTO colorDTO){
        final String UP_LOAD = "D:\\shopclothes\\product\\color";
        String IDcode = System.currentTimeMillis()+"";
        String image = IDcode + ".jpg";
        Path path = Paths.get(UP_LOAD + File.separator+image);
        try {
            Files.write(path,colorDTO.getMultipartFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        colorDTO.setJoinDate(Calendar.getInstance());
        colorDTO.setFileImage(IDcode);
        colorDTO.setProductDTO((ProductDTO) productServiceImpl.getbyID(ID));
        colorServiceImpl.add(colorDTO);
        return "redirect:/admin/category/catalog/product/color/all?IDproduct="+this.ID;
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("IDcolor") int ID){
        colorServiceImpl.delete(colorServiceImpl.getbyID(ID));
        return "redirect:/admin/category/catalog/product/color/all?IDproduct="+this.ID+"&message=delete-success";
    }
}
