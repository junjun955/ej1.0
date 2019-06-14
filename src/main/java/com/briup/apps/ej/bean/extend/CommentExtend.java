package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.Order;

public class CommentExtend extends Comment {
    private Order order;
    public  Order getOrder() {return  order;}
    public  void  setOrder(Order order){this.order = order;}
}
