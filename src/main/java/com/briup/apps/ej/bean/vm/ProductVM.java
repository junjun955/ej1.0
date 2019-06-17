package com.briup.apps.ej.bean.vm;

import io.swagger.annotations.ApiParam;

public class ProductVM {
    @ApiParam(value = "分类ID",required = true)

    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}