package com.ddinhftieens.shopclothes.Service.CustomerService;

import com.ddinhftieens.shopclothes.DAO.CustomerDAO.UserDAOImpl;
import com.ddinhftieens.shopclothes.DAO.ICommon;
import com.ddinhftieens.shopclothes.Entity.CustomerEntity;
import com.ddinhftieens.shopclothes.Model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements ICommon<CustomerDTO>, UserDetailsService {
    @Autowired
    private UserDAOImpl userDAOImpl;
    @Override
    public void add(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstname(customerDTO.getFirseName());
        customerEntity.setLastname(customerDTO.getLastName());
        customerEntity.setUsername(customerDTO.getUsername());
        customerEntity.setPassword(customerDTO.getPassword());
        customerEntity.setPhoneNumber(customerDTO.getPhone());
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setAvatarFileName(customerDTO.getImageUser());
        customerEntity.setJoindate(customerDTO.getJoindate());
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setRole(customerDTO.getRole());
        userDAOImpl.add(customerEntity);
    }

    @Override
    public void edit(CustomerDTO customerDTO) {

    }

    @Override
    public void delete(CustomerDTO customerDTO) {

    }

    @Override
    public CustomerDTO getbyID(int ID) {
        return null;
    }

    @Override
    public CustomerDTO getbyName(String name) {
        CustomerEntity customerEntity = userDAOImpl.getbyName(name);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setRole(customerEntity.getRole());
        customerDTO.setPassword(customerEntity.getPassword());
        customerDTO.setFirseName(customerEntity.getFirstname());
        customerDTO.setLastName(customerEntity.getLastname());
        customerDTO.setJoindate(customerEntity.getJoindate());
        customerDTO.setAddress(customerEntity.getAddress());
        customerDTO.setEmail(customerEntity.getEmail());
        customerDTO.setPhone(customerEntity.getPhoneNumber());
        customerDTO.setUsername(customerEntity.getUsername());
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAll() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        CustomerDTO customerDTO = getbyName(s);
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(customerDTO.getRole());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);
        return new User(s, customerDTO.getPassword(), authorities);
    }
}
