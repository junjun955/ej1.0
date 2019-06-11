package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> query(Product product);

    List<Product> findAll();

    Product findById(long id);

    void saveOrUpdate(Product product) throws Exception;
    void deleteById(long id) throws Exception ;
}

