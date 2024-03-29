package com.example.communitydemo.domain.board.service;

import com.example.communitydemo.domain.board.dto.CommentDto;
import com.example.communitydemo.domain.board.entity.Article;
import com.example.communitydemo.domain.board.entity.Comment;
import com.example.communitydemo.domain.board.repository.ArticleRepository;
import com.example.communitydemo.domain.board.repository.CommentRepository;
import jakarta.transaction.Transactional;
import jdk.jfr.Frequency;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
     * 댓글 조회 해주는 서비스 메서드
     */
    public List<CommentDto.CommentBaseResponse> getComment(Long articleId){
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        // Convert Comment entities to DTOs
        return comments.stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());

    }

    public Boolean commentPasswordCheck(Long commentId,String password){
        Optional<Comment> result = commentRepository.findById(commentId);

        if(result.isPresent()){
            Comment comment = result.get();
            return comment.getPassword().equals(password);
        }

        return false;
    }

    @Transactional
    public Optional<Comment> delete(Long commentId){
      Integer updateCount = commentRepository.updateCommentLogicalDelete(commentId);

      if(updateCount > 0){
          return commentRepository.findById(commentId);
      }
      return Optional.empty();
    }
}
