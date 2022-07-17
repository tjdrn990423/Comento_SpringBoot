package com.comento.board.service;

import com.comento.board.domain.BoardDTO;
import com.comento.board.entity.Board;
import com.comento.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<Board> listAll() {
        return boardRepository.findAll();
    }
}
