package com.ddinhftieens.shopclothes.Service.Impl;

import com.ddinhftieens.shopclothes.Entity.ColorEntity;
import com.ddinhftieens.shopclothes.Entity.SizeEntity;
import com.ddinhftieens.shopclothes.Model.ColorDTO;
import com.ddinhftieens.shopclothes.Model.SizeDTO;
import com.ddinhftieens.shopclothes.Service.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SizeServiceImpl implements ICommon<SizeDTO> {

    @Qualifier("colorDAOImpl")
    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon iCommoncolor;

    @Qualifier("sizeDAOImpl")
    @Autowired
    private com.ddinhftieens.shopclothes.DAO.ICommon iCommonsize;

    @Autowired
    private ICommon colorServiceImpl;

    @Override
    public void add(SizeDTO sizeDTO) {
        SizeEntity sizeEntity = new SizeEntity();
        sizeEntity.setSizeName(sizeDTO.getSizeName());
        sizeEntity.setCost(sizeDTO.getCost());
        sizeEntity.setQuantity(sizeDTO.getQuantity());
        sizeEntity.setSale(sizeDTO.getSale());
        sizeEntity.setJoindate(sizeDTO.getJoindate());
        sizeEntity.setColorEntity((ColorEntity) iCommoncolor.getbyID(sizeDTO.getColorDTO().getID()));
        iCommonsize.add(sizeEntity);
    }

    @Override
    public void edit(SizeDTO sizeDTO) {
        SizeEntity sizeEntity = (SizeEntity) iCommonsize.getbyID(sizeDTO.getID());
        sizeEntity.setSizeName(sizeDTO.getSizeName());
        sizeEntity.setCost(sizeDTO.getCost());
        sizeEntity.setQuantity(sizeDTO.getQuantity());
        sizeEntity.setSale(sizeDTO.getSale());
        sizeEntity.setJoindate(sizeDTO.getJoindate());
        iCommonsize.edit(sizeEntity);
    }

    @Override
    public void delete(SizeDTO sizeDTO) {
        iCommonsize.delete(iCommonsize.getbyID(sizeDTO.getID()));
    }

    @Override
    public SizeDTO getbyID(int ID) {
        SizeDTO sizeDTO = new SizeDTO();
        SizeEntity sizeEntity = (SizeEntity) iCommonsize.getbyID(ID);
        sizeDTO.setID(sizeEntity.getId());
        sizeDTO.setSizeName(sizeEntity.getSizeName());
        sizeDTO.setQuantity(sizeEntity.getQuantity());
        sizeDTO.setCost(sizeEntity.getCost());
        sizeDTO.setSale(sizeEntity.getSale());
        sizeDTO.setJoindate(sizeEntity.getJoindate());
        sizeDTO.setColorDTO((ColorDTO) colorServiceImpl.getbyID(sizeEntity.getColorEntity().getId()));
        return sizeDTO;
    }

    @Override
    public SizeDTO getbyName(String name) {
        return null;
    }

    @Override
    public List<SizeDTO> getAll() {
        return null;
    }
}
