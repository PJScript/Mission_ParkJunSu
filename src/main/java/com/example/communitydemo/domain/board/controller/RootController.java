package com.example.communitydemo.domain.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping()
    public String home(){
        return "home";
    }
}
