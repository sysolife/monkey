package com.bulldog.monkey.api.controller;

import com.bulldog.monkey.api.model.ArticleEntity;
import com.bulldog.monkey.api.model.ResultEntity;
import com.bulldog.monkey.entity.Article;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bulldog.monkey.mapper.ArticleMapper;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael
 * @create 2019-07-13 18:36
 */
@RestController
@RequestMapping("/api/v1/articles")
@Api(tags = {"笔记相关接口"}, value = "笔记模块")
public class ArticleApiController {

    @Autowired
    public ArticleMapper articleMapper;

    @ApiOperation(value = "获取笔记列表", notes = "获取全部笔记信息")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ArticleEntity> getArticles() {
        List<ArticleEntity> articleEntityList = new ArrayList<>();
        List<Article> articleList = articleMapper.selectList(null);
        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            ArticleEntity articleEntity = article.toEntity();
            articleEntityList.add(articleEntity);
        }
        return articleEntityList;
    }

    @ApiOperation(value = "笔记详情", notes = "根据笔记id 查询其信息")
    @ApiImplicitParam(name = "id", value = "笔记id", paramType = "path", required = true)
    @GetMapping("/{id}")
    public ArticleEntity getArticle(@PathVariable("id") int id) {
        Article article = articleMapper.selectById(id);
        return article.toEntity();
    }

    @ApiOperation(value = "保存笔记", notes = "保存笔记")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "标题", required = true, dataType = "string"),
            @ApiImplicitParam(name = "content", value = "内容", required = true, dataType = "string"),
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "int"),
            @ApiImplicitParam(name = "starStatus", value = "收藏状态", required = true, dataType = "int")
    })
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultEntity saveArticle(String title,String content,int userId,int starStatus) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setStar_status(starStatus);
        article.setUser_id(userId);
        int insert = articleMapper.insert(article);
        ResultEntity resultEntity = new ResultEntity();
        if (insert == 1) {
            resultEntity.setCode(1);
            resultEntity.setMsg("保存成功");
        } else {
            resultEntity.setCode(0);
            resultEntity.setMsg("保存失败");
        }
        return resultEntity;
    }


    @ApiOperation(value = "更新笔记", notes = "更新笔记")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章id", required = true, dataType = "int"),
            @ApiImplicitParam(name = "title", value = "标题", dataType = "string"),
            @ApiImplicitParam(name = "content", value = "内容", dataType = "string"),
            @ApiImplicitParam(name = "starStatus", value = "收藏状态", dataType = "int")
    })
    @RequestMapping(value = "/", method = RequestMethod.PATCH)
    public ResultEntity updateArticle(int id,String title,String content,String starStatus) {
        Article article = articleMapper.selectById(id);
        ResultEntity resultEntity = new ResultEntity();
        if(article == null){
            resultEntity.setCode(0);
            resultEntity.setMsg("文章不存在！");
            return resultEntity;
        }
        if(title != null && !title.isEmpty()){
            article.setTitle(title);
        }
        if(content != null && !content.isEmpty()){
            article.setContent(content);
        }

        if(starStatus != null && Integer.parseInt(starStatus) != article.getStar_status()){
            article.setStar_status(Integer.parseInt(starStatus));
        }
        int i = articleMapper.updateById(article);
        if (i == 1) {
            resultEntity.setCode(1);
            resultEntity.setMsg("更新成功");
        } else {
            resultEntity.setCode(0);
            resultEntity.setMsg("更新失败");
        }
        return resultEntity;
    }


    @ApiOperation(value = "删除笔记", notes = "根据电影id 删除笔记")
    @ApiImplicitParam(name = "id", value = "笔记id", paramType = "path", required = true)
    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
    public ResultEntity deleteArticle(@PathVariable("id") int id) {
        ResultEntity resultEntity = new ResultEntity();
        int i = articleMapper.deleteById(id);
        if(i == 1){
            resultEntity.setCode(1);
            resultEntity.setMsg("删除成功");
        }else {
            resultEntity.setCode(0);
            resultEntity.setMsg("删除失败");
        }
        return resultEntity;
    }
}

