package com.example.communitydemo.domain.board.controller;

import com.example.communitydemo.domain.board.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RootController {
    private final CategoryService categoryService;
    @GetMapping()
    public String home(Model model){
        model.addAttribute("category",categoryService.findAllCategory());
        return "home";
    }
}
