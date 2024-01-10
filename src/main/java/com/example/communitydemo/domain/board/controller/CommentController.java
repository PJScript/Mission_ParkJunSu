package com.example.communitydemo.domain.board.controller;

import com.example.communitydemo.domain.board.dto.CommentDto;
import com.example.communitydemo.domain.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public String createComment(
            @RequestParam("articleId")
            String article_id,
            CommentDto.CommentCreateRequest request) {
        System.out.println(article_id);
        Long id = Long.parseLong(article_id);
        commentService.createComment(request, id);
        return String.format("redirect:/article/%d", id);
    }

}
