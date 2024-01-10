package com.example.communitydemo.domain.board.repository;

import com.example.communitydemo.domain.board.dto.ArticleDto;
import com.example.communitydemo.domain.board.entity.Article;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT a FROM Article a WHERE a.category.value = ?1")
    List<Article> findArticleByCategory(String category_value);



    @Transactional
    @Modifying
    @Query("UPDATE Article a SET a.is_deleted = true WHERE a.id = ?1")
    Integer updateArticleLogicalDelete(@Param("id") Long id);

}
