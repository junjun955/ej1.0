package com.briup.apps.ej.service.impl;


import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.dao.OrderMapper;
import com.briup.apps.ej.service.IOrderService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    // 自动注入mapper实例
    @Resource
    private OrderMapper orderMapper;

   // @Override
    //public List<Order> query(Order order) {
        // 创建空模板
        //OrderExample example = new OrderExample();
        // 在模板中添加条件
       // if(order.getOrderTime()!=null){
         //   example
           //         .createCriteria()
            //        .andOrderTimeLike("%"+order.getOrderTime()+"%");
      //  }
       // if(order.getTotal()!=null){
        //    example
         //           .createCriteria()
          //          .andTotalLike("%"+order.getTotal()+"%");
       // }
       // if(order.getCustomerId()!=null){
       //     example.createCriteria().andCustomerIdEqualTo(order.getCustomerId());
       // }

        //return orderMapper.selectByExample(example);
    //}

    @Override
    public List<Order> query(Order order) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        OrderExample example = new OrderExample();
        return orderMapper.selectByExample(example);
    }

    @Override
    public Order findById(long id) {
        // 调用mapper层代码完成查询操作
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Order order) throws Exception {
        if(order.getId() == null){
            // 初始化属性
            //order.setStatus("正常");
            orderMapper.insert(order);
        } else {
            orderMapper.updateByPrimaryKey(order);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Order order = orderMapper.selectByPrimaryKey(id);
        if(order == null){
            throw new Exception("要删除的订单不存在");
        } else {
            orderMapper.deleteByPrimaryKey(id);
        }
    }
}
