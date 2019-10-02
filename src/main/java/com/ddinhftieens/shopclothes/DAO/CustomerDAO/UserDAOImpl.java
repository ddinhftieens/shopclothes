package com.ddinhftieens.shopclothes.DAO.CustomerDAO;

import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.CustomerEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements ICommon<CustomerEntity> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(CustomerEntity customerEntity) {
        entityManager.persist(customerEntity);
    }

    @Override
    public void edit(CustomerEntity customerEntity) {

    }

    @Override
    public void delete(CustomerEntity customerEntity) {

    }

    @Override
    public CustomerEntity getbyID(int ID) {
        return null;
    }

    @Override
    public CustomerEntity getbyName(String name) {
        String hql ="select e from CustomerEntity e where e.username = :user";
        Query query = entityManager.createQuery(hql,CustomerEntity.class);
        query.setParameter("user",name);
        return (CustomerEntity) query.getSingleResult();
    }

    @Override
    public List<CustomerEntity> getAll() {
        return null;
    }
}
