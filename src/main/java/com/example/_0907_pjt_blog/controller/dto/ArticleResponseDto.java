package com.example._0907_pjt_blog.controller.dto;

import com.example._0907_pjt_blog.entity.Article;
import com.example._0907_pjt_blog.entity.Member;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Builder
public class ArticleResponseDto {
    private long articleId;
    private String title;
    private String content;
    private String memberName;
    @DateTimeFormat(pattern = "yy-MM-dd HH:mm")
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ArticleResponseDto articleToArticleResponseDto(Article article) {
        if (article == null) {
            return null;
        } else {
            ArticleResponseDto.ArticleResponseDtoBuilder articleResponseDto = ArticleResponseDto.builder();
            articleResponseDto.articleId(article.getArticleId());
            articleResponseDto.title(article.getTitle());
            articleResponseDto.memberName(article.getMember().getName());
            articleResponseDto.content(article.getContent());
            articleResponseDto.createdAt(article.getCreatedAt());
            articleResponseDto.updatedAt(article.getUpdatedAt());
            return articleResponseDto.build();
        }
    }

    public static List<ArticleResponseDto> articleToArticleResponseDtos(List<Article> articles) {
        if (articles == null) {
            return null;
        } else {
            List<ArticleResponseDto> list = new ArrayList(articles.size());
            Iterator var3 = articles.iterator();

            while(var3.hasNext()) {
                Article article = (Article)var3.next();
                list.add(articleToArticleResponseDto(article));
            }

            return list;
        }
    }
}
