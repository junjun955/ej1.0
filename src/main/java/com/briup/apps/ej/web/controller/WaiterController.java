package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.service.IWaiterService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/waiter")
public class WaiterController {
    @Autowired
    private IWaiterService waiterService;


    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Waiter waiter){
        List<Waiter> list = waiterService.query(waiter);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("查询所有工人信息")
    @GetMapping("findAll")
    public Message findAll(){
        List<Waiter> waiter = waiterService.findAll();
        return MessageUtil.success("success",waiter);

    }
    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "id") long id){
        Waiter waiter = waiterService.findById(id);
        return MessageUtil.success("success",waiter);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新顾客信息")
    public Message saveOrUpdate(@Valid @ModelAttribute Waiter waiter) throws Exception{
        waiterService.saveOrUpdate(waiter);
        return MessageUtil.success("操作成功");
    }


    @ApiOperation("通过id删除用户信息")
    @GetMapping("deleteById")
    public Message deleteById(@NotNull @RequestParam("id") Long id) throws Exception{
        waiterService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation("批量删除工人信息")
    @PostMapping("batchDelete")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        waiterService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}



