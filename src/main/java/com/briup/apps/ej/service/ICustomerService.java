package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    Customer findById(long id);

    void saveOrUpdate(Customer customer) throws Exception ;

    void deleteById(long id) throws Exception ;

    List<Customer> query(Customer customer);
}

