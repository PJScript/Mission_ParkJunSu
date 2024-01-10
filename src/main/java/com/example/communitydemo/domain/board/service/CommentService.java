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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class CommentService {
    public final ArticleRepository articleRepository;
    public final CommentRepository commentRepository;

    /**
     * 댓글 생성 해주는 서비스 메서드
     * @param request
     * @param article_id
     */
    public void createComment(CommentDto.CommentCreateRequest request,Long article_id){
        Article article = articleRepository.findById(article_id).orElseThrow();
        Comment comment = CommentDto.CommentCreateRequest.toEntity(request,article);
        commentRepository.save(comment);
    }

    /**
     * 댓글 죄회 해주는 서비스 메서드
     */

    public List<CommentDto.CommentBaseResponse> getComment(Long articleId){
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        // Convert Comment entities to DTOs
        return comments.stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());

    }
}
