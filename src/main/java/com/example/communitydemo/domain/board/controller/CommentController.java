package com.example.communitydemo.domain.board.controller;

import com.example.communitydemo.domain.board.dto.CommentDto;
import com.example.communitydemo.domain.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/article/{articleId}/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public String createComment(
            @PathVariable("articleId")
            String article_id,
            CommentDto.CommentCreateRequest request) {
        System.out.println(article_id);
        Long id = Long.parseLong(article_id);
        commentService.createComment(request, id);
        return String.format("redirect:/article/%d", id);
    }




}
