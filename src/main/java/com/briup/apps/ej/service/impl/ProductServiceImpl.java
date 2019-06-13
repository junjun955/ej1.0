package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.ProductExample;
import com.briup.apps.ej.dao.CommentMapper;
import com.briup.apps.ej.dao.ProductMapper;
import com.briup.apps.ej.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
@Service
@RestController
@RequestMapping
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> query(Product product) {
        return null;
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
    public void saveOrUpdate(Product product) {
        if(product.getId() == null){
            // 初始化属性
            //order.setStatus("正常");
            productMapper.insert(product);
        } else {
            productMapper.updateByPrimaryKey(product);
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


