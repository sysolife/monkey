package com.bulldog.monkey.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bulldog.monkey.api.model.ArticleEntity;
import com.bulldog.monkey.enums.UserSexEnum;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "articles")
public class Article implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)//指定自增策略
    private int id;
    private String title;
    private String content;
    private int user_id;
    private int star_status;

    public ArticleEntity toEntity(){
        ArticleEntity articleEntity = new ArticleEntity(this.getId(),
                this.getTitle(),
                this.getContent(),
                this.getUser_id(),
                this.getStar_status());
        return articleEntity;
    }

}
