package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order_line;
import com.briup.apps.ej.service.IOrder_lineService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order_line")
public class Order_lineController {
    @Autowired
    private IOrder_lineService order_lineService;

    @GetMapping("findAll")
    public Message findAll(){
        List<Order_line> list = order_lineService.findAll();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "id") long id){
        Order_line order_line = order_lineService.findById(id);
        return MessageUtil.success("success",order_line);
    }

    @ApiOperation("保存或更新订单信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Order_line order_line){
        try {
            order_lineService.saveOrUpdate(order_line);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id删除订单项")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
            order_lineService.deleteById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

}
