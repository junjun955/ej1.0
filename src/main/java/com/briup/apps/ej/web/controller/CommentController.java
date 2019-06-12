package com.briup.apps.ej.web.controller;
import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.service.ICommentService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("/comment")
public class CommentController {
    /**
     *
     */
    @Autowired
    public ICommentService commentService;



    @GetMapping("findAll")
    @ApiOperation("查询所有顾客评论信息")
    public Message findAll(){
        List<Comment> list = commentService.findAll();
        return MessageUtil.success("success",list);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新顾客信息")
    public Message saveOrUpdate(Comment comment) throws Exception{
        commentService.saveOrUpdate(comment);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除")
    public Message deleteById(Long id) throws Exception{
        commentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除顾客信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        commentService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}

