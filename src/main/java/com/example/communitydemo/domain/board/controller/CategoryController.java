package com.example.communitydemo.domain.board.controller;

import com.example.communitydemo.domain.board.dto.ArticleDto;
import com.example.communitydemo.domain.board.repository.CategoryRepository;
import com.example.communitydemo.domain.board.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{value}")
    public String allArticleView(
            Model model,
            @PathVariable String value
    ) {
        model.addAttribute("articles", categoryService.getArticleListPreview(value));
        model.addAttribute("category", categoryService.findByValue(value));
        return "board";
    }

    @GetMapping("{value}/write")
    public String writeView(
            Model model,
            @PathVariable String value
    ) {
        model.addAttribute("category", categoryService.findAllCategory());
        return "articleWrite";
    }


}
