package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.extend.CommentExtend;

import java.util.List;

public interface ICommentService {
    List<CommentExtend> queryBasic(Long orderId);

    List<CommentExtend> query(Long orderId);

    List<Comment> query(Comment comment);

    List<Comment> findAll();


    Comment findById(long id);
    void saveOrUpdate(Comment comment) throws Exception ;

    void deleteById(long id) throws Exception ;

    void batchDelete(long[] ids) throws Exception;
}
