package com.ddinhftieens.shopclothes.Service.Impl;

import com.ddinhftieens.shopclothes.Entity.CategoryEntity;
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
public class CategoryServiceImpl implements ICommon<CategoryDTO> {

    @Qualifier("categoryDAOImpl")
    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon categoryDAO;
    @Override
    public void add(CategoryDTO categoryDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setNamecategory(categoryDTO.getName());
        categoryEntity.setDatecreated(categoryDTO.getDatecreated());
        categoryDAO.add(categoryEntity);
    }

    @Override
    public void edit(CategoryDTO categoryDTO) {

    }

    @Override
    public void delete(CategoryDTO categoryDTO) {
        categoryDAO.delete(categoryDAO.getbyID(categoryDTO.getID()));
    }

    @Override
    public CategoryDTO getbyID(int ID) {
        CategoryEntity categoryEntity = (CategoryEntity) categoryDAO.getbyID(ID);
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setID(categoryEntity.getID());
        categoryDTO.setName(categoryEntity.getNamecategory());
        categoryDTO.setDatecreated(categoryEntity.getDatecreated());
        return categoryDTO;
    }

    @Override
    public CategoryDTO getbyName(String name) {
        return null;
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<CategoryEntity> categoryEntities = categoryDAO.getAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (CategoryEntity c : categoryEntities) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setID(c.getID());
            categoryDTO.setName(c.getNamecategory());
            categoryDTO.setDatecreated(c.getDatecreated());
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }
}
