package com.example.communitydemo.domain.board.service;

import com.example.communitydemo.domain.board.dto.CommentDto;
import com.example.communitydemo.domain.board.entity.Article;
import com.example.communitydemo.domain.board.entity.Comment;
import com.example.communitydemo.domain.board.repository.ArticleRepository;
import com.example.communitydemo.domain.board.repository.CommentRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class CommentService {
    public final ArticleRepository articleRepository;
    public final CommentRepository commentRepository;
    public void createComment(CommentDto.CommentCreateRequest request,Long article_id){
        Article article = articleRepository.findById(article_id).orElseThrow();
        Comment comment = CommentDto.CommentCreateRequest.toEntity(request,article);

        commentRepository.save(comment);

    }
}
