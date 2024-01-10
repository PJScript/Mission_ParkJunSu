package com.example.communitydemo.domain.board.controller;

import com.example.communitydemo.domain.board.dto.CommentDto;
import com.example.communitydemo.domain.board.entity.Comment;
import com.example.communitydemo.domain.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

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

    @GetMapping("{commentId}/delete/password-check")
    public String commentDeletePasswordCheckView(
            Model model,
            @PathVariable("articleId")
            String articleId,
            @PathVariable("commentId")
            String commentId
    ){
        model.addAttribute("articleId",articleId);
        model.addAttribute("commentId",commentId);
        return "commentDeletePasswordCheck";
    }
    @PostMapping("{commentId}/delete")
    public String deleteComment(
            @PathVariable("articleId")
            Long articleId,
            @PathVariable("commentId")
            Long commentId,
            @ModelAttribute CommentDto.CommentDeleteRequest request
    ){
        boolean isPossible = commentService.commentPasswordCheck(commentId,request.getPassword());

        if(isPossible){
            Optional<Comment> updateComment = commentService.delete(commentId);

            return updateComment
                    .map(article -> "redirect:/article/" + articleId)
                    .orElse("redirect:/article/" + articleId);
        }
        return "passwordError";

    }









}
