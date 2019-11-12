package com.bulldog.monkey.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lijian
 * @ClassName WorkingDayEntity
 * @description TODO
 * @date 2019-11-07
 */
@ApiModel(description = "工作日实体类")
public class WorkingDayEntity {
    @ApiModelProperty(value = "id",dataType="int")
    private int id;
    @ApiModelProperty(value = "名称", required = true)
    private String name;

    public WorkingDayEntity(@JsonProperty("id") int id,
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
