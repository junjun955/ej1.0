package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.bean.Order_line;
import com.briup.apps.ej.bean.extend.OrderExtend;
import com.briup.apps.ej.bean.vm.OrderAndOrderLineVM;
import com.briup.apps.ej.bean.vm.OrderVM;
import com.briup.apps.ej.dao.Order_lineMapper;
import com.briup.apps.ej.dao.OrderMapper;
import com.briup.apps.ej.dao.extend.OrderExtendMapper;
import com.briup.apps.ej.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderExtendMapper orderExtendMapper;
    @Resource
    private Order_lineMapper order_lineMapper;

    @Override
    public List<OrderVM> queryBasic(Long customerId, Long waiterId) {
        return orderExtendMapper.queryBasic(customerId, waiterId);
    }

    @Override
    public List<OrderExtend> query(Long customerId, Long waiterId) {
        return orderExtendMapper.query(customerId,waiterId);
    }

@Override
public Order findById(long id) {
    // 调用mapper层代码完成查询操作
    return orderMapper.selectByPrimaryKey(id);
}
    @Override
    public List<Order> findAll() {
        OrderExample example = new OrderExample();
        return orderMapper.selectByExample(example);
    }

    @Override
    public void save(OrderAndOrderLineVM order) throws Exception {
        // 先保存订单
        Order o = new Order();
        o.setOrderTime(new Date().getTime());
        o.setTotal(100.0);
        o.setCustomerId(order.getCustomerId());
        o.setAddressId(order.getAddressId());
        orderMapper.insert(o);
        // 再保存订单项
        List<Order_line> list = order.getOrderLines();
        for(Order_line ol : list){
            // 维护订单项与订单之间的关系
            ol.setOrderId(o.getId());
            order_lineMapper.insert(ol);
        }
    }


    @Override
    public void deleteById(long id) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(id);
        if(order == null){
            throw new Exception("要删除的订单信息不存在");
        }
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            orderMapper.deleteByPrimaryKey(id);
        }
    }
}