package com.comento.board.repository;

import com.comento.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board,Integer> {
    @Modifying
    @Query("update Board b set b.viewcnt = b.viewcnt + 1 where b.bno = :bno")
    int updateView(@Param("bno")int bno);
}
