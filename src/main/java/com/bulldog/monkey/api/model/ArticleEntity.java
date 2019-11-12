package com.bulldog.monkey.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Michael
 * @create 2019-07-13 18:33
 */
@ApiModel(description = "UserEntity 实体类")
public class MovieEntity {
    @ApiModelProperty(value = "id",dataType="int")
    private int id;
    @ApiModelProperty(value = "标题", required = true)
    private String title;

    public MovieEntity(@JsonProperty("id") int id,
                       @JsonProperty("title") String title) {

        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

