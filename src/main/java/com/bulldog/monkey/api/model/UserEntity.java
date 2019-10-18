package com.bulldog.monkey.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Michael
 * @create 2019-07-13 18:33
 */
@ApiModel(description = "UserEntity 实体类")
public class UserEntity {
    @ApiModelProperty(value = "用户id",dataType="int")
    private int id;
    @ApiModelProperty(value = "用户名", required = true)
    private String name;

    public UserEntity(@JsonProperty("id") int id,
                 @JsonProperty("name") String name) {

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

