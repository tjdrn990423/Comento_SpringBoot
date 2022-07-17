package com.comento.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    @GetMapping("/")
    public String main(){
        return "index";
    }
    @GetMapping("/boards")
    public String getBoards(){
        return "/board/list";
    }
}
