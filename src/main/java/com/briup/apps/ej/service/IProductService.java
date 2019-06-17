package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.extend.ProductExtend;

import java.util.List;

public interface IProductService {
    List<ProductExtend> queryBasic(Long categoryId);

    List<ProductExtend> query(Long categoryId);



    List<Product> findAll();

    List<Product> query(Product product);

    Product findById( long id);



    void saveOrUpdate(Product product) throws Exception;

    void deleteById(long id) throws Exception ;

    void batchDelete(long[] ids) throws Exception;



}


