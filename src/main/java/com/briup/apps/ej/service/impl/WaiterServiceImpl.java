package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.bean.WaiterExample;
import com.briup.apps.ej.dao.WaiterMapper;
import com.briup.apps.ej.service.IWaiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class WaiterServiceImpl implements IWaiterService{
    // 自动注入mapper实例
    @Resource
    private WaiterMapper waiterMapper;

    @Override
    public List<Waiter> query(Waiter waiter) {
        // 创建空模板
        WaiterExample example = new WaiterExample();
        // 在模板中添加条件
        if(waiter.getRealname()!=null){
            example
                    .createCriteria()
                    .andRealnameLike("%"+waiter.getRealname()+"%");
        }
        if(waiter.getTelephone()!=null){
            example
                    .createCriteria()
                    .andTelephoneLike("%"+waiter.getTelephone()+"%");
        }

        return waiterMapper.selectByExample(example);
    }

    @Override
    public List<Waiter> findAll() {
        WaiterExample example = new WaiterExample();
        return waiterMapper.selectByExample(example);
    }

    @Override
    public Waiter findById(long id) {
        // 调用mapper层代码完成查询操作
        return waiterMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Waiter waiter) throws Exception {
        if(waiter.getId() == null){
            // 初始化属性
            waiter.setStatus("正常");
            waiterMapper.insert(waiter);
        } else {
            waiterMapper.updateByPrimaryKey(waiter);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Waiter waiter = waiterMapper.selectByPrimaryKey(id);
        if(waiter == null){
            throw new Exception("要删除的用户不存在");
        } else {
            waiterMapper.deleteByPrimaryKey(id);
        }
    }
}