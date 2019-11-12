package com.bulldog.monkey.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Michael
 * @create 2019-07-13 18:33
 */
@ApiModel(description = "ArticleEntityAttr 实体类")
public class ArticleEntityAttr {
    @ApiModelProperty(value = "标题", required = true)
    private String title;
    @ApiModelProperty(value = "内容", required = true)
    private String content;
    @ApiModelProperty(value = "用户ID", required = true, dataType = "int")
    private int user_id;
    @ApiModelProperty(value = "收藏状态，0否1是", dataType = "int")
    private int star_status;


    public ArticleEntityAttr(@JsonProperty("title") String title,@JsonProperty("content") String content,@JsonProperty("user_id") int user_id,@JsonProperty("star_status") int star_status) {

        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.star_status = star_status;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStar_status() {
        return star_status;
    }

    public void setStar_status(int start_status) {
        this.star_status = start_status;
    }
}

