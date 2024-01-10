package com.example.communitydemo.domain.board.repository;

import com.example.communitydemo.domain.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
