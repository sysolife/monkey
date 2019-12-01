package com.bulldog.monkey.api.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("api接口通用返回对象")
public class ArticleResultEntity implements Serializable {

    @ApiModelProperty(value = "返回码", dataType = "int")
    private int code;

    @ApiModelProperty(value = "提示信息", dataType = "String")
    private String msg;

    public ArticleEntity getData() {
        return data;
    }

    public void setData(ArticleEntity data) {
        this.data = data;
    }

    private ArticleEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}