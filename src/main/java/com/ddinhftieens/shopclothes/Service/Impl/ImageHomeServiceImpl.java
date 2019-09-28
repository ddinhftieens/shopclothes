package com.ddinhftieens.shopclothes.Service.Impl;

import com.ddinhftieens.shopclothes.Entity.ImageHomeEntity;
import com.ddinhftieens.shopclothes.Model.ImageHomeDTO;
import com.ddinhftieens.shopclothes.Service.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class ImageHomeServiceImpl implements ICommon<ImageHomeDTO> {

    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon imageHomeDAOImpl;

    @Override
    public void add(ImageHomeDTO imageHomeDTO) {
        ImageHomeEntity imageHomeEntity = new ImageHomeEntity();
        imageHomeEntity.setImage(imageHomeDTO.getImage());
        imageHomeEntity.setDatecreated(imageHomeDTO.getDatecreated());
        imageHomeDAOImpl.add(imageHomeEntity);
    }

    @Override
    public void edit(ImageHomeDTO imageHomeDTO) {
    }

    @Override
    public void delete(ImageHomeDTO imageHomeDTO) {
        imageHomeDAOImpl.delete(imageHomeDAOImpl.getbyID(imageHomeDTO.getId()));
    }

    @Override
    public ImageHomeDTO getbyID(int ID) {
        ImageHomeEntity imageHomeEntity = (ImageHomeEntity) imageHomeDAOImpl.getbyID(ID);
        ImageHomeDTO imageHomeDTO = new ImageHomeDTO();
        imageHomeDTO.setId(imageHomeEntity.getId());
        imageHomeDTO.setImage(imageHomeEntity.getImage());
        imageHomeDTO.setDatecreated(imageHomeEntity.getDatecreated());
        return imageHomeDTO;
    }

    @Override
    public ImageHomeDTO getbyName(String name) {
        return null;
    }

    @Override
    public List<ImageHomeDTO> getAll() {
        List<ImageHomeEntity> imageHomeEntityList = imageHomeDAOImpl.getAll();
        List<ImageHomeDTO> imageHomeDTOList = new ArrayList<>();
        for(ImageHomeEntity i:imageHomeEntityList){
            ImageHomeDTO imageHomeDTO = new ImageHomeDTO();
            imageHomeDTO.setId(i.getId());
            imageHomeDTO.setImage(i.getImage());
            imageHomeDTO.setDatecreated(i.getDatecreated());
            imageHomeDTOList.add(imageHomeDTO);
        }
        return imageHomeDTOList;
    }
}
