package com.bulldog.monkey.api.model;

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
    private Long id;
    @ApiModelProperty(value = "用户名", required = true)
    private String name;

    public UserEntity(@JsonProperty("id") Long id,
                 @JsonProperty("name") String name) {

        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

