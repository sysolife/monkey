package com.bulldog.monkey.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Michael
 * @create 2019-07-13 18:33
 */
@ApiModel(description = "电影评论实体类")
public class CommentEntity {
    @ApiModelProperty(value = "id",dataType="int")
    private int id;
    @ApiModelProperty(value = "内容", required = true)
    private String content;
    @ApiModelProperty(value = "movieId",dataType="int")
    private int movieId;
    public CommentEntity(@JsonProperty("id") int id,
                         @JsonProperty("content") String content,
                         @JsonProperty("movieId") int movieId) {

        this.id = id;
        this.content = content;
        this.movieId = movieId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String title) {
        this.content = content;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}

