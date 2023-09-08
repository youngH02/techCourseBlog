package com.example._0907_pjt_blog.controller;

import com.example._0907_pjt_blog.controller.dto.ArticlePatchDto;
import com.example._0907_pjt_blog.controller.dto.ArticlePostDto;
import com.example._0907_pjt_blog.controller.mapper.ArticleMapper;
import com.example._0907_pjt_blog.entity.Article;
import com.example._0907_pjt_blog.entity.Member;
import com.example._0907_pjt_blog.repository.ArticleRepository;
import com.example._0907_pjt_blog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ArticleApiController {
    private final ArticleService articleService;
    private final ArticleMapper mapper;

    //게시글 업데이트
    @PatchMapping("/{articleId}")
    public ResponseEntity updateArticle(@PathVariable("articleId") long articleId, @RequestBody ArticlePatchDto articlePatchDto){
        articlePatchDto.setArticleId(articleId);
        Article article = articleService.updateArticle(mapper.articlePatchDtoToArticle(articlePatchDto));
        return new ResponseEntity(HttpStatus.OK);
    }

    //게시글 삭제
    @DeleteMapping("/{articleId}")
    public ResponseEntity deleteArticle(@PathVariable("articleId") long articleId){
        articleService.deleteArticle(articleId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //게시글 생성
    @PostMapping("/new")
    public ResponseEntity postArticle(@RequestBody ArticlePostDto articlePostDto){
        Article mappedArticle = mapper.articlePostDtoToArticle(articlePostDto);
        //Article mappedArticle = ArticlePostDto.articlePostDtoToArticle(articlePostDto);
        articleService.createArticle(mappedArticle);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
