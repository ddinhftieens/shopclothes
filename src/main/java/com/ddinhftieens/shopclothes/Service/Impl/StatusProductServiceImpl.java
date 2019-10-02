package com.ddinhftieens.shopclothes.Service.Impl;

import com.ddinhftieens.shopclothes.DAO.Impl.ProductDAOImpl;
import com.ddinhftieens.shopclothes.Entity.StatusProductEntity;
import com.ddinhftieens.shopclothes.Model.StatusProductDTO;
import com.ddinhftieens.shopclothes.Service.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StatusProductServiceImpl implements ICommon<StatusProductDTO> {
    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon statusProductDAOImpl;

    @Autowired
    private ProductDAOImpl productDAOImpl;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Override
    public void add(StatusProductDTO statusProductDTO) {
        StatusProductEntity statusProductEntity = new StatusProductEntity();
        statusProductEntity.setStatus(statusProductDTO.getStatus());
        statusProductEntity.setProductEntity(productDAOImpl.getbyIDcode(statusProductDTO.getProductDTO().getIDcode()));
        statusProductDAOImpl.add(statusProductEntity);
    }

    @Override
    public void edit(StatusProductDTO statusProductDTO) {

    }

    @Override
    public void delete(StatusProductDTO statusProductDTO) {

    }

    @Override
    public StatusProductDTO getbyID(int ID) {
        return null;
    }

    @Override
    public StatusProductDTO getbyName(String name) {
        return null;
    }

    @Override
    public List<StatusProductDTO> getAll() {
        List<StatusProductEntity> statusProductEntityList = statusProductDAOImpl.getAll();
        List<StatusProductDTO> productDTOList = new ArrayList<>();
        for(StatusProductEntity i:statusProductEntityList){
            StatusProductDTO statusProductDTO = new StatusProductDTO();
            statusProductDTO.setId(i.getId());
            statusProductDTO.setStatus(i.getStatus());
            statusProductDTO.setProductDTO(productServiceImpl.getbyID(i.getProductEntity().getId()));
            productDTOList.add(statusProductDTO);
        }
        return productDTOList;
    }
}
