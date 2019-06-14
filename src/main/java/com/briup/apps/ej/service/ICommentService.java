package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.extend.CommentExtend;
import com.briup.apps.ej.bean.vm.CommentVM;

import java.util.List;

public interface ICommentService {
    List<CommentVM> queryBasic(Long commentId, Long commentTime);

    List<CommentExtend> query(Long commentId, Long commentTime);

    List<Comment> query(Comment comment);

    List<Comment> findAll();

    Comment findById(long id);

    void saveOrUpdate(Comment comment) throws Exception ;

    void deleteById(long id) throws Exception ;

    void batchDelete(long[] ids) throws Exception;
}
