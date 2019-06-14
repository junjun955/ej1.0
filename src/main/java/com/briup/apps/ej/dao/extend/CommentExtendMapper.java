package com.briup.apps.ej.dao.extend;

import com.briup.apps.ej.bean.extend.CommentExtend;
import com.briup.apps.ej.bean.vm.CommentVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentExtendMapper {
    List<CommentExtend> query(
            @Param("commentId") Long commentId,
            @Param("commentTime") Long commentTime
    );


    List<CommentVM> queryBasic(
            @Param("commentId") Long commentId,
             @Param("commentTime") Long commentTime
    );
}
