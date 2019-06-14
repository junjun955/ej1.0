package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.bean.WaiterExample;
import com.briup.apps.ej.dao.WaiterMapper;
import com.briup.apps.ej.service.IWaiterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/waiter")
public class WaiterServiceImpl implements IWaiterService {
    @Resource
    private WaiterMapper waiterMapper;

    @Override
    public List<Waiter> query(Waiter waiter) {
        // 创建空模板
        WaiterExample example = new WaiterExample();
        // 在模板中添加条件
        if (waiter.getRealname() != null) {
            example
                    .createCriteria()
                    .andRealnameLike("%" + waiter.getRealname() + "%");
        }
        if (waiter.getTelephone() != null) {
            example
                    .createCriteria()
                    .andTelephoneLike("%" + waiter.getTelephone() + "%");
        }
        if (waiter.getRealname() != null) {
            example
                    .createCriteria()
                    .andRealnameLike("%" + waiter.getRealname() + "%");
        }
        if (waiter.getIdcard() != null) {
            example
                    .createCriteria()
                    .andIdcardLike("%" + waiter.getIdcard() + "%");
        }
        if (waiter.getStatus() != null) {
            example
                    .createCriteria()
                    .andStatusLike("%" + waiter.getStatus() + "%");
        }
        if (waiter.getPhoto() != null) {
            example
                    .createCriteria()
                    .andPhotoLike("%" + waiter.getPhoto() + "%");
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
        return waiterMapper.selectByPrimaryKey(id);

    }
    @Override
    public void saveOrUpdate(Waiter waiter) throws Exception {
        if (waiter.getId() == null) {
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
        if (waiter == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            waiterMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public void batchDelete(long[] ids) throws Exception {
        for (long id : ids) {
            waiterMapper.deleteByPrimaryKey(id);
        }
    }
}