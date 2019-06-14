package com.briup.apps.ej.web.controller;
import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.extend.CommentExtend;
import com.briup.apps.ej.bean.vm.CommentVM;
import com.briup.apps.ej.service.ICommentService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(description = "顾客评论管理相关接口")
@Validated
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    public ICommentService commentService;

    @GetMapping("queryBasic")
    @ApiOperation("查询评论信息，返回列表数据")
    public Message queryBasic(Long commentId,Long commentTime){
        List<CommentVM> list = commentService.queryBasic(commentId,commentTime);
        return MessageUtil.success("success",list);
    }

    @GetMapping("query")
    @ApiOperation("查询评论信息，并且评论级联关键的属性")
    public Message query(Long commentId,Long commentTime){
        List<CommentExtend> list = commentService.query(commentId,commentTime);
        return MessageUtil.success("success",list);
    }


    @GetMapping("findAll")
    @ApiOperation("查询所有顾客评论信息")
    public Message findAll(){
        List<Comment> list = commentService.findAll();
        return MessageUtil.success("success",list);
    }

    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或者更新顾客信息")
    public Message saveOrUpdate(@Valid @ModelAttribute Comment comment) throws Exception{
        commentService.saveOrUpdate(comment);
        return MessageUtil.success("操作成功");
    }

    @GetMapping("deleteById")
    @ApiOperation("通过ID删除")
    public Message deleteById(@NotNull @RequestParam("id")Long id) throws Exception{
        commentService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除顾客信息")
    public Message batchDelete(long[] ids) throws Exception{
        commentService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}

