package com.comento.board.service;

import com.comento.board.domain.BoardDTO;
import com.comento.board.entity.Board;

import java.util.List;

public interface BoardService {
    List<Board> listAll();
    Integer register(BoardDTO dto);
    BoardDTO findById(int bno);
    void update(BoardDTO boardDTO);
    void delete(int bno);
    int updateView(int bno);


    default Board dtoToEntity(BoardDTO dto){
        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .viewcnt(dto.getViewcnt())
                .build();
        return board;
    }

    default BoardDTO entityToDto(Board entity){
        BoardDTO dto = BoardDTO.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .viewcnt(entity.getViewcnt())
                .build();
        return dto;
    }

}
