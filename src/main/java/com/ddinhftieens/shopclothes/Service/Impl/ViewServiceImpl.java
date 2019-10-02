package com.ddinhftieens.shopclothes.Service.Impl;

import com.ddinhftieens.shopclothes.DAO.Impl.ProductDAOImpl;
import com.ddinhftieens.shopclothes.DAO.Impl.ViewDAOImpl;
import com.ddinhftieens.shopclothes.Entity.ViewEntity;
import com.ddinhftieens.shopclothes.Model.ViewDTO;
import com.ddinhftieens.shopclothes.Service.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ViewServiceImpl implements ICommon<ViewDTO> {
    @Autowired
    private ViewDAOImpl viewDAOImpl;
    @Autowired
    private ProductDAOImpl productDAO;
    @Override
    public void add(ViewDTO viewDTO) {
        ViewEntity viewEntity = new ViewEntity();
        viewEntity.setProductEntity(productDAO.getbyID(viewDTO.getProductDTO().getID()));
        viewDAOImpl.add(viewEntity);
    }

    @Override
    public void edit(ViewDTO viewDTO) {

    }

    @Override
    public void delete(ViewDTO viewDTO) {

    }

    @Override
    public ViewDTO getbyID(int ID) {
        return null;
    }

    @Override
    public ViewDTO getbyName(String name) {
        return null;
    }

    @Override
    public List<ViewDTO> getAll() {
        return null;
    }
}
