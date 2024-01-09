package com.example.communitydemo.domain.board.repository;

import com.example.communitydemo.domain.board.entity.Article;
import com.example.communitydemo.domain.board.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT a FROM Category a WHERE a.value = ?1")
    Category findByCategoryValue(String value);
}
