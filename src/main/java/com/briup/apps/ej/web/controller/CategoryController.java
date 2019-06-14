package com.briup.apps.ej.web.controller;
import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.service.ICategoryService;
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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Category category){
        List<Category> list = categoryService.query(category);
        return MessageUtil.success("success",list);
    }

    @GetMapping("findAll") public Message findAll(){
        List<Category> list = categoryService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(@ApiParam(value = "主键",required = true) @RequestParam(value = "id") long id){
        Category category=categoryService.findById(id);
        return MessageUtil.success("success",category);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新分类信息")
    public Message saveOrUpdate(@Valid @ModelAttribute Category category) throws Exception{
        categoryService.savaOrUpdate(category);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation("通过id删除分类信息")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
            categoryService.deleteById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除分类信息")
    public Message batchDelete(long[] ids) throws Exception{
        categoryService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
