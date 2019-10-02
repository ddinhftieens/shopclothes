package com.ddinhftieens.shopclothes.DAO;

import com.ddinhftieens.shopclothes.Model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
@Transactional
public class JDBCTemplate {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataScoure(DataSource dataScoure){
        this.jdbcTemplate = new JdbcTemplate(dataScoure);
    }

    public void statusProduct(int ID,String status){
        String sql = "update status_product set status = ? where id = ?";
        this.jdbcTemplate.update(sql,new Object[]{status,ID});
    }

    public int checkRegister(CustomerDTO customerDTO,String type){
        String sql = "";
        if(type.equals("register")){
            sql = "select count(0) from customer where username = ? or email = ? or phone_number = ?";
            return this.jdbcTemplate.queryForObject(sql,new Object[]{customerDTO.getUsername(),customerDTO.getEmail(),customerDTO.getPhone()},Integer.class);
        }
        else{
            sql = "select count(0) from customer where (email = ? or phone_number = ?)and username!=?";
            return this.jdbcTemplate.queryForObject(sql,new Object[]{customerDTO.getEmail(),customerDTO.getPhone(),customerDTO.getUsername()},Integer.class);
        }
    }
}
