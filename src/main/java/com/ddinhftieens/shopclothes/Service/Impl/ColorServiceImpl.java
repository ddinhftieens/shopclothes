package com.ddinhftieens.shopclothes.Service.Impl;

import com.ddinhftieens.shopclothes.Entity.ColorEntity;
import com.ddinhftieens.shopclothes.Entity.ProductEntity;
import com.ddinhftieens.shopclothes.Model.ColorDTO;
import com.ddinhftieens.shopclothes.Model.ProductDTO;
import com.ddinhftieens.shopclothes.Service.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ColorServiceImpl implements ICommon<ColorDTO> {

    @Qualifier("productDAOImpl")
    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon iCommonproduct;

    @Qualifier("colorDAOImpl")
    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon iCommoncolor;

    @Autowired
    private ICommon productServiceImpl;

    @Override
    public void add(ColorDTO colorDTO) {
        ColorEntity colorEntity = new ColorEntity();
        colorEntity.setColorName(colorDTO.getColorName());
        colorEntity.setDescription(colorDTO.getDescription());
        colorEntity.setFileImage(colorDTO.getFileImage());
        colorEntity.setMeterial(colorDTO.getMaterial());
        colorEntity.setJoindate(colorDTO.getJoinDate());
        colorEntity.setProductEntity((ProductEntity) iCommonproduct.getbyID(colorDTO.getProductDTO().getID()));
        iCommoncolor.add(colorEntity);
    }

    @Override
    public void edit(ColorDTO colorDTO) {

    }

    @Override
    public void delete(ColorDTO colorDTO) {
        iCommoncolor.delete(iCommoncolor.getbyID(colorDTO.getID()));
    }

    @Override
    public ColorDTO getbyID(int ID) {
        ColorEntity colorEntity = (ColorEntity) iCommoncolor.getbyID(ID);
        ColorDTO colorDTO = new ColorDTO();
        colorDTO.setColorName(colorEntity.getColorName());
        colorDTO.setDescription(colorEntity.getDescription());
        colorDTO.setFileImage(colorEntity.getFileImage());
        colorDTO.setMaterial(colorEntity.getMeterial());
        colorDTO.setID(colorEntity.getId());
        colorDTO.setJoinDate(colorEntity.getJoindate());
        colorDTO.setProductDTO((ProductDTO) productServiceImpl.getbyID(colorEntity.getProductEntity().getId()));
        return colorDTO;
    }

    @Override
    public ColorDTO getbyName(String name) {
        return null;
    }

    @Override
    public List<ColorDTO> getAll() {
        return null;
    }
}
