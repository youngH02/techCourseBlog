package com.example._0907_pjt_blog.controller.dto;

import com.example._0907_pjt_blog.entity.Article;
import com.example._0907_pjt_blog.entity.Member;
import com.example._0907_pjt_blog.service.MemberService;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ArticlePostDto {
    private String title;
    private String content;
    @Setter
    private String loginId;

    public Member getMember(){
        Member member = new Member();
        member.setLoginId(loginId);
        return member;
    }

    public static Article articlePostDtoToArticle(ArticlePostDto articlePostDto) {
        if (articlePostDto == null) {
            return null;
        } else {
            Article.ArticleBuilder article = Article.builder();
            article.title(articlePostDto.getTitle());
            article.content(articlePostDto.getContent());
            article.member(articlePostDto.getMember());
            return article.build();
        }
    }


}
