package com.example.communitydemo.domain.board.repository;

import com.example.communitydemo.domain.board.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
