package com.briup.apps.ej.bean.vm;



import com.briup.apps.ej.bean.Order_line;
import io.swagger.annotations.ApiParam;

import java.util.List;

public class OrderAndOrderLineVM {
    @ApiParam(value = "顾客ID",required = true)
    private Long customerId;
    @ApiParam(value = "服务地址ID",required = true)
    private Long addressId;
    private List<Order_line> orderLines;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public List<Order_line> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<Order_line> orderLines) {
        this.orderLines = orderLines;
    }
}