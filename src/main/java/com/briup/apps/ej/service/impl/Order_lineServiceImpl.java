package com.briup.apps.ej.service.impl;



import com.briup.apps.ej.bean.Order_line;
import com.briup.apps.ej.bean.Order_lineExample;
import com.briup.apps.ej.dao.Order_lineMapper;
import com.briup.apps.ej.service.IOrder_lineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Order_lineServiceImpl implements IOrder_lineService{
    @Resource
    private Order_lineMapper order_lineMapper;
    @Override
    public List<Order_line> query(Order_line order) {
        return null;
    }

    @Override
    public List<Order_line> findAll() {
        Order_lineExample example = new Order_lineExample();
        return order_lineMapper.selectByExample(example);
    }

    @Override
    public Order_line findById(long id) {
        // 调用mapper层代码完成查询操作
        return order_lineMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Order_line order_line) throws Exception {
        if(order_line.getId() == null){
            // 初始化属性
            //order.setStatus("正常");
            order_lineMapper.insert(order_line);
        } else {
            order_lineMapper.updateByPrimaryKey(order_line);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Order_line order_line = order_lineMapper.selectByPrimaryKey(id);
        if(order_line == null){
            throw new Exception("要删除的订单项不存在");
        } else {
            order_lineMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            order_lineMapper.deleteByPrimaryKey(id);
        }
    }
}
