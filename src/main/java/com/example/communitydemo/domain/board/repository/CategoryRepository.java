package com.example.communitydemo.domain.board.repository;

import com.example.communitydemo.domain.board.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
