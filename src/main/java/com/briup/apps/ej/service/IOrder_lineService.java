package com.briup.apps.ej.service;


import com.briup.apps.ej.bean.Order_line;

import java.util.List;

public interface IOrder_lineService {
    List<Order_line> query(Order_line order_line);

    List<Order_line> findAll();

    Order_line findById(long id);

    void saveOrUpdate(Order_line order_line) throws Exception ;

    void deleteById(long id) throws Exception ;
}
