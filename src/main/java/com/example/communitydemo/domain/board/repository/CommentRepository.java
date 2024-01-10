package com.example.communitydemo.domain.board.repository;

import com.example.communitydemo.domain.board.entity.Comment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByArticleId(Long articleId);

    @Transactional
    @Modifying
    @Query("UPDATE Comment a SET a.is_deleted = true WHERE a.id = ?1")
    Integer updateCommentLogicalDelete(@Param("id") Long id);
}
