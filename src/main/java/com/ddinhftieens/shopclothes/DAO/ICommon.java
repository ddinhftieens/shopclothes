package com.ddinhftieens.shopclothes.DAO;

import java.util.List;

public interface ICommon <T>{
    void add(T t);
    void edit(T t);
    void delete(T t);
    T getbyID(int ID);
    T getbyName(String name);
    List<T> getAll();
}
