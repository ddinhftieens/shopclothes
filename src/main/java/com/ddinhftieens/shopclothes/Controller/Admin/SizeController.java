package com.ddinhftieens.shopclothes.Controller.Admin;

import com.ddinhftieens.shopclothes.Entity.ColorEntity;
import com.ddinhftieens.shopclothes.Entity.SizeEntity;
import com.ddinhftieens.shopclothes.Model.ColorDTO;
import com.ddinhftieens.shopclothes.Model.SizeDTO;
import com.ddinhftieens.shopclothes.Service.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/admin/category/catalog/product/color/size")
public class SizeController {
    @Autowired
    private ICommon colorServiceImpl;

    @Autowired
    private ICommon sizeServiceImpl;

    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon colorDAOImpl;

    private int IDcolor,IDsize;

    @GetMapping("/all")
    public String all(@RequestParam("IDcolor") int IDcolor, Model model){
        this.IDcolor = IDcolor;
        model.addAttribute("color",(ColorDTO) colorServiceImpl.getbyID(IDcolor));
        ColorEntity colorEntity = (ColorEntity) colorDAOImpl.getbyID(IDcolor);
        List<SizeEntity> sizeEntityList = colorEntity.getSizeEntityList();
        model.addAttribute("sizeList",sizeEntityList);
        model.addAttribute("size",new SizeDTO());
        return "admin/admin-product-size-all";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("size") SizeDTO sizeDTO){
        sizeDTO.setJoindate(Calendar.getInstance());
        sizeDTO.setColorDTO((ColorDTO) colorServiceImpl.getbyID(IDcolor));
        sizeServiceImpl.add(sizeDTO);
        return "redirect:/admin/category/catalog/product/color/size/all?IDcolor="+this.IDcolor;
    }
    @GetMapping("/update")
    public String getUpdate(@RequestParam("IDsize") int IDsize,Model model){
        this.IDsize = IDsize;
        model.addAttribute("size",(SizeDTO) sizeServiceImpl.getbyID(IDsize));
        return "admin/admin-product-size-update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("size") SizeDTO sizeDTO){
        sizeDTO.setID(this.IDsize);
        sizeDTO.setJoindate(Calendar.getInstance());
        sizeServiceImpl.edit(sizeDTO);
        return "redirect:/admin/category/catalog/product/color/size/all?IDcolor="+this.IDcolor+"&message=update-success";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("IDsize") int IDsize){
        sizeServiceImpl.delete(sizeServiceImpl.getbyID(IDsize));
        return "redirect:/admin/category/catalog/product/color/size/all?IDcolor="+this.IDcolor+"&message=delete-success";
    }
}
