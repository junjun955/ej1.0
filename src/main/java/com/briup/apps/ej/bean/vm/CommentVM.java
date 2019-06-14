package com.briup.apps.ej.bean.vm;

import io.swagger.annotations.ApiParam;


public class CommentVM {
    @ApiParam(value = "订单ID",required = true)
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}