package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Product;


import com.briup.apps.ej.bean.extend.CommentExtend;
import com.briup.apps.ej.bean.extend.ProductExtend;
import com.briup.apps.ej.bean.vm.ProductVM;

import com.briup.apps.ej.service.IProductService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@Api(description = "产品管理相关接口")
@Validated
@RestController
@RequestMapping("/product")

public class ProductController {
    @Autowired
    public IProductService productService;

    @GetMapping("queryBasic")
    @ApiOperation("查询产品信息，返回列表数据")
    public Message queryBasic(Long categoryId){
        List<ProductExtend> list = productService.queryBasic(categoryId);
        return MessageUtil.success("success",list);
    }

    @GetMapping("query")
    @ApiOperation("查询产品信息，并且产品级联关键的属性")
    public Message query(Long categoryId){
        List<ProductExtend> list = productService.query(categoryId);
        return MessageUtil.success("success",list);
    }





    @GetMapping("findAll")
    @ApiOperation("查询所有产品信息")
    public Message findAll(){
        List<Product> list = productService.findAll();
        return MessageUtil.success("success",list);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新产品信息")
    public Message saveOrUpdate(@Valid @ModelAttribute Product product) throws Exception{
        productService.saveOrUpdate(product);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除产品信息")
    public Message deleteById(@NotNull @RequestParam("id")Long id) throws Exception{
        productService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除产品信息")
    public Message batchDelete(long[] ids) throws Exception{
        productService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
