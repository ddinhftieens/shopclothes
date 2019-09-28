package com.ddinhftieens.shopclothes.Service.Impl;

import com.ddinhftieens.shopclothes.Entity.CatalogEntity;
import com.ddinhftieens.shopclothes.Entity.ColorEntity;
import com.ddinhftieens.shopclothes.Entity.ProductEntity;
import com.ddinhftieens.shopclothes.Model.CatalogDTO;
import com.ddinhftieens.shopclothes.Model.ColorDTO;
import com.ddinhftieens.shopclothes.Model.ProductDTO;
import com.ddinhftieens.shopclothes.Service.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ICommon<ProductDTO> {
    @Qualifier("productDAOImpl")
    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon iCommon;

    @Qualifier("catalogDAOImpl")
    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon catalogDAO;

    @Qualifier("catalogServiceImpl")
    @Autowired
    private ICommon catalogService;

    @Override
    public void add(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setIDcode(productDTO.getIDcode());
        productEntity.setTrademark(productDTO.getTrademark());
        productEntity.setModel(productDTO.getModel());
        productEntity.setMadein(productDTO.getMadein());
        productEntity.setJoindate(productDTO.getJoindate());
        productEntity.setCatalogEntity((CatalogEntity) catalogDAO.getbyID(productDTO.getCatalogDTO().getID()));
        iCommon.add(productEntity);
    }

    @Override
    public void edit(ProductDTO productDTO) {

    }

    @Override
    public void delete(ProductDTO productDTO) {
        iCommon.delete(iCommon.getbyID(productDTO.getID()));
    }

    @Override
    public ProductDTO getbyID(int ID) {
        ProductEntity productEntity = (ProductEntity) iCommon.getbyID(ID);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setID(productEntity.getId());
        productDTO.setTrademark(productEntity.getTrademark());
        productDTO.setModel(productEntity.getModel());
        productDTO.setMadein(productEntity.getMadein());
        productDTO.setJoindate(productEntity.getJoindate());
        productDTO.setIDcode(productEntity.getIDcode());
        productDTO.setCatalogDTO((CatalogDTO) catalogService.getbyID(productEntity.getCatalogEntity().getID()));
        return productDTO;
    }

    @Override
    public ProductDTO getbyName(String name) {
        return null;
    }

    @Override
    public List<ProductDTO> getAll() {
        List<ProductEntity> productEntityList = iCommon.getAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(ProductEntity i:productEntityList){
            ProductDTO productDTO = new ProductDTO();
            productDTO.setID(i.getId());
            productDTO.setTrademark(i.getTrademark());
            productDTO.setMadein(i.getMadein());
            productDTO.setModel(i.getModel());
            productDTO.setIDcode(i.getIDcode());
            productDTO.setJoindate(i.getJoindate());
            productDTO.setCatalogDTO((CatalogDTO) catalogService.getbyID(i.getCatalogEntity().getID()));
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }
}
