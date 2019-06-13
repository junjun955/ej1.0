package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.*;

import com.briup.apps.ej.dao.ProductMapper;
import com.briup.apps.ej.service.IProductService;
import com.briup.apps.ej.web.controller.ProductController;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@Service

public  class ProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> query(Product product) {
        //创建空模板
        ProductExample example=new ProductExample();
        //  在模板中添加条件
        if(product.getName()!=null){
            example
                    .createCriteria()
                    .andNameLike("%"+product.getName()+"%");
        }
        if(product.getDescription()!=null){
            example
                    .createCriteria()
                    .andDescriptionLike("%"+product.getDescription()+"%");
        }
        if(product.getStatus()!=null){
            example
                    .createCriteria()
                    .andStatusLike("%"+product.getName()+"%");
        }
        if(product.getName()!=null){
            example
                    .createCriteria()
                    .andNameLike("%"+product.getName()+"%");
        }
        if(product.getPhoto()!=null){
            example
                    .createCriteria()
                    .andPhotoLike("%"+product.getName()+"%");
        }

        return productMapper.selectByExample(example);

    }


    @Override
    public List<Product> findAll() {
        ProductExample example = new ProductExample();
        return productMapper.selectByExample(example);
    }

    @Override
    public Product findById(long id) {
        // 调用mapper层代码完成查询操作
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Product product) throws Exception {
        if(product.getId()!=null){
            productMapper.updateByPrimaryKey(product);
        } else {
            //comment.setStatus("正常");
            productMapper.insert(product);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Product product = productMapper.selectByPrimaryKey(id);
        if(product== null){
            throw new Exception("要删除的产品不存在");
        } else {
            productMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            productMapper.deleteByPrimaryKey(id);
        }
    }
}


