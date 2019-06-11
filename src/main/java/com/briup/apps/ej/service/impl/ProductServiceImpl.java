package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.ProductExample;
import com.briup.apps.ej.dao.ProductMapper;
import com.briup.apps.ej.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
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
            throw new Exception("要删除的商品不存在");
        } else {
            productMapper.deleteByPrimaryKey(id);
        }
    }
}


