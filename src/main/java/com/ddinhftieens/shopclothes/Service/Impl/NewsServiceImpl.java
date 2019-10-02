package com.ddinhftieens.shopclothes.Service.Impl;

import com.ddinhftieens.shopclothes.DAO.CustomerDAO.UserDAOImpl;
import com.ddinhftieens.shopclothes.DAO.Impl.NewsDAOImpl;
import com.ddinhftieens.shopclothes.Entity.NewsEntity;
import com.ddinhftieens.shopclothes.Model.NewsDTO;
import com.ddinhftieens.shopclothes.Service.ICommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class NewsServiceImpl implements ICommon<NewsDTO> {
    @Autowired
    private UserDAOImpl userDAO;
    @Autowired
    private NewsDAOImpl newsDAO;
    @Override
    public void add(NewsDTO newsDTO) {
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setTitel(newsDTO.getTitel());
        newsEntity.setContent(newsDTO.getContent());
        newsEntity.setDatecreated(newsDTO.getDatecreated());
        newsEntity.setIDimage(newsDTO.getIDimage());
        newsEntity.setCustomerEntity(userDAO.getbyName(newsDTO.getCustomerDTO().getUsername()));
        newsDAO.add(newsEntity);
    }

    @Override
    public void edit(NewsDTO newsDTO) {

    }

    @Override
    public void delete(NewsDTO newsDTO) {

    }

    @Override
    public NewsDTO getbyID(int ID) {
        return null;
    }

    @Override
    public NewsDTO getbyName(String name) {
        return null;
    }

    @Override
    public List<NewsDTO> getAll() {
        return null;
    }
}
