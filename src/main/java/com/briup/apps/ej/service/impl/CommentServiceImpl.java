package com.briup.apps.ej.service.impl;
import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.CommentExample;
import com.briup.apps.ej.dao.CommentMapper;
import com.briup.apps.ej.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    private CommentMapper commentMapper;


    @Override
    public List<Comment> query(Comment comment) {
        //创建空模板
        CommentExample example=new CommentExample();
        //  在模板中添加条件
        if(comment.getContent()!=null){
            example
                    .createCriteria()
                    .andContentLike("%"+comment.getContent()+"%");
        }
        if(comment.getCommentTime()!=null){
            example
                    .createCriteria()
                    .andCommentTimeLike("%"+comment.getCommentTime()+"%");
        }
        if(comment.getOrderId()!=null){
            example
                    .createCriteria()
                    .andOrderId("%"+comment.getOrderId()+"%");
        }

        return commentMapper.selectByExample(example);
    }

    @Override
    public List<Comment> findAll() {
        CommentExample example = new CommentExample();
        return commentMapper.selectByExample(example);
    }

    @Override
    public Comment findById(long id) {
        // 调用mapper层代码完成查询操作
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Comment comment) throws Exception {
        if(comment.getId()!=null){
            commentMapper.updateByPrimaryKey(comment);
        } else {
            //comment.setStatus("正常");
            commentMapper.insert(comment);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        if(comment == null){
            throw new Exception("要删除的用户不存在");
        } else {
            commentMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void batchDelete(long[] ids) throws Exception {
        for(long id :ids){
            commentMapper.deleteByPrimaryKey(id);
        }
    }
}