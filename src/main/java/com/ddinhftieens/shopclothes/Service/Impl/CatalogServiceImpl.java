package com.ddinhftieens.shopclothes.Service.Impl;

import com.ddinhftieens.shopclothes.Entity.CatalogEntity;
import com.ddinhftieens.shopclothes.Entity.CategoryEntity;
import com.ddinhftieens.shopclothes.Model.CatalogDTO;
import com.ddinhftieens.shopclothes.Model.CategoryDTO;
import com.ddinhftieens.shopclothes.Service.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CatalogServiceImpl implements ICommon<CatalogDTO> {
    @Qualifier("categoryServiceImpl")
    @Autowired
    private ICommon categoryService;
    @Qualifier("categoryDAOImpl")
    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon categoryDAO;
    @Qualifier("catalogDAOImpl")
    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon catalogDAO;
    @Override
    public void add(CatalogDTO catalogDTO) {
        CatalogEntity catalogEntity = new CatalogEntity();
        catalogEntity.setNamecatalog(catalogDTO.getName());
        catalogEntity.setDatecreated(catalogDTO.getDatecreated());
        catalogEntity.setCategoryEntity((CategoryEntity) categoryDAO.getbyID(catalogDTO.getCategoryDTO().getID()));
        catalogDAO.add(catalogEntity);
    }

    @Override
    public void edit(CatalogDTO catalogDTO) {

    }

    @Override
    public void delete(CatalogDTO catalogDTO) {
        catalogDAO.delete(catalogDAO.getbyID(catalogDTO.getID()));
    }

    @Override
    public CatalogDTO getbyID(int ID) {
        CatalogEntity catalogEntity = (CatalogEntity) catalogDAO.getbyID(ID);
        CatalogDTO catalogDTO = new CatalogDTO();
        catalogDTO.setID(catalogEntity.getID());
        catalogDTO.setName(catalogEntity.getNamecatalog());
        catalogDTO.setDatecreated(catalogEntity.getDatecreated());
        catalogDTO.setCategoryDTO((CategoryDTO) categoryService.getbyID(catalogEntity.getCategoryEntity().getID()));
        return catalogDTO;
    }

    @Override
    public CatalogDTO getbyName(String name) {
        return null;
    }

    @Override
    public List<CatalogDTO> getAll() {
        List<CatalogEntity> catalogEntityList = catalogDAO.getAll();
        List<CatalogDTO> catalogDTOList = new ArrayList<>();
        for(CatalogEntity i:catalogEntityList){
            CatalogDTO catalogDTO = new CatalogDTO();
            catalogDTO.setID(i.getID());
            catalogDTO.setName(i.getNamecatalog());
            catalogDTO.setDatecreated(i.getDatecreated());
            catalogDTO.setCategoryDTO((CategoryDTO) categoryService.getbyID(i.getCategoryEntity().getID()));
            catalogDTOList.add(catalogDTO);
        }
        return catalogDTOList;
    }
}
