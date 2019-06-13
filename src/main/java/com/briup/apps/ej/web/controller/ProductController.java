package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.service.IProductService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    public IProductService productService;


    @GetMapping("findAll")
    @ApiOperation("查询所有顾客评论信息")
    public Message findAll(){
        List<Product> list = productService.findAll();
        return MessageUtil.success("success",list);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新顾客信息")
    public Message saveOrUpdate(Product product) throws Exception{
        productService.saveOrUpdate(product);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除")
    public Message deleteById(Long id) throws Exception{
        productService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除顾客信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        productService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
