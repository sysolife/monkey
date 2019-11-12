package com.bulldog.monkey.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bulldog.monkey.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}