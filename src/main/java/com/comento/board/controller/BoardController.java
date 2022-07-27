package com.comento.board.controller;

import com.comento.board.domain.BoardDTO;
import com.comento.board.entity.Board;
import com.comento.board.repository.BoardRepository;
import com.comento.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


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

    //상세정보
    @GetMapping("/boards/{idx}")
    public String getDetail(@PathVariable("idx") int bno,Model model){
        BoardDTO boardDTO = boardService.findById(bno);
        boardService.updateView(bno);
        model.addAttribute("board",boardDTO);
        return "/board/detail";
    }
    //등록
    @GetMapping("/boards/register")
    public String getRegister(Model model){
        model.addAttribute("board", BoardDTO.builder().build());
        return "/board/register";
    }

    @PostMapping("/boards")
    public String postRegister(@ModelAttribute("board") BoardDTO boardDTO){
        boardService.register(boardDTO);
        return "redirect:/boards";
    }


    //수정
    @GetMapping("/boards/edit/{idx}")
    public String getUpdate(@PathVariable("idx") int bno, Model model){
        BoardDTO boardDTO = boardService.findById(bno);
        model.addAttribute("board",boardDTO);
        return "/board/upform";
    }
    @PutMapping("/boards/edit/{idx}")
    public String PutUpdate(@ModelAttribute("idx") BoardDTO boardDTO,Model model){
        boardService.update(boardDTO);
        model.addAttribute(boardDTO);
        return "redirect:/boards";
    }
    //삭제
    @DeleteMapping("/boards/{idx}")
    public String deleteBno(@PathVariable("idx") int bno){
        boardService.delete(bno);
        return "redirect:/boards";

    }

    /*
    @GetMapping("/boards/form")
    public String form(Model model,@RequestParam(required = false) Integer bno){
        if(bno == null){
            model.addAttribute("board",new Board());
        }else {
            BoardDTO board = boardService.findById(bno);
            model.addAttribute("board",board);
        }
        return "/board/form";
    }
    */


}
