package com.example.communitydemo.domain.board.controller;

import com.example.communitydemo.domain.board.dto.ArticleDto;
import com.example.communitydemo.domain.board.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 1. 게시글 조회
 * 2. 게시글 삭제
 * 3. 게시글 수정
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("{id}")
    public String articleView(Model model, @PathVariable String id) {
        return "article";
    }

    @PostMapping("{id}")
    public ArticleDto.ArticleBaseResponse articleCreate(
            @RequestBody ArticleDto.ArticleCreateRequest request) {


        return articleService.create(request);
    }

}
