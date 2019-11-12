package com.bulldog.monkey.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bulldog.monkey.api.model.CommentEntity;
import com.bulldog.monkey.api.model.MovieEntity;
import com.bulldog.monkey.api.model.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael
 * @create 2019-07-13 18:36
 */
@RestController
@RequestMapping("/api/v1/")
@Api(tags = {"电影相关接口"}, value = "电影模块")
public class MovieApiController {

    // 模拟数据库
    public static List<MovieEntity> movies = new ArrayList<>();
    public static List<CommentEntity> comments = new ArrayList<>();

    static {
        MovieEntity user1 = new MovieEntity(1, "盗梦空间");
        MovieEntity user2 = new MovieEntity(2, "老人与海");
        movies.add(user1);
        movies.add(user2);
        CommentEntity comment1 = new CommentEntity(1, "电影不错",1);
        CommentEntity comment2 = new CommentEntity(2, "真好看",1);
        comments.add(comment1);
        comments.add(comment2);
    }

    @ApiOperation(value = "获取电影列表", notes = "获取全部电影信息")
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<MovieEntity> getMovies() {
        return movies;
    }

    @ApiOperation(value = "电影详情", notes = "根据电影id 查询其信息")
    @ApiImplicitParam(name = "id", value = "电影id", paramType = "path", required = true)
    @GetMapping("/movies/{id}")
    public MovieEntity getMovie(@PathVariable("id") int id) {
        MovieEntity movie = movies.get(id);
        return movie;
    }

    @ApiOperation(value = "电影评论详情", notes = "根据电影id 查询其评论")
    @ApiImplicitParam(name = "id", value = "电影id", paramType = "path", required = true)
    @GetMapping("/movies/{id}/comments")
    public List<CommentEntity> getMovieComments(@PathVariable("id") int id) {
        return comments;
    }

    @ApiOperation(value = "评论", notes = "新增评论")
    @ApiImplicitParam(name = "id", value = "电影id", paramType = "path", required = true)
    @RequestMapping(value = "/movies/{id}/comment", method = RequestMethod.POST)
    public CommentEntity saveComment(@ApiParam(value = "评论信息", required = true)
                                         @PathVariable("id") int id,
                               @RequestBody CommentEntity comment) {
        comment.setMovieId(id);
        comments.add(comment);
        return comment;
    }
}

