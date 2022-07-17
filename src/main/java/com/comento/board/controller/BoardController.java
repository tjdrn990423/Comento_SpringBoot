package com.comento.board.controller;

import com.comento.board.entity.Board;
import com.comento.board.repository.BoardRepository;
import com.comento.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardService boardService;

    //메인 (localhost:8181/)
    @GetMapping("/")
    public String main(){
        return "index";
    }
    //게시글 전체 조회
    @GetMapping("/boards")
    public String getBoards(Model model){
        List<Board> list = boardService.listAll();
        model.addAttribute("list",list);
        return "/board/list";
    }
}
