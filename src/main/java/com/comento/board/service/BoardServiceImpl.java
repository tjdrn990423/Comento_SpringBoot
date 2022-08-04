package com.comento.board.service;

import com.comento.board.domain.BoardDTO;
import com.comento.board.entity.Board;
import com.comento.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;


    @Override
    @Transactional
    public List<Board> listAll() {
        return boardRepository.findAll();
    }

    @Override
    @Transactional
    public Integer register(BoardDTO dto) {
        Board board = dtoToEntity(dto);
        boardRepository.save(board);
        return board.getBno();
    }

    @Override
    @Transactional
    public BoardDTO findById(int bno) {
        BoardDTO boardDTO = null;
        Optional<Board> board = boardRepository.findById(bno);
        if(board.isPresent()){
            boardDTO = entityToDto(board.get());
        }
        return boardDTO;
    }

    @Override
    @Transactional
    public void update(BoardDTO boardDTO) {
        Board board = dtoToEntity(boardDTO);
        boardRepository.save(board);

    }

    @Override
    @Transactional
    public void delete(int bno) {
        boardRepository.deleteById(bno);
    }

    @Override
    @Transactional
    public int updateView(int bno) {
        return boardRepository.updateView(bno);
    }


}
