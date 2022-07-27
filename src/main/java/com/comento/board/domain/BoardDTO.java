package com.comento.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private int bno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdDate;
    private int viewcnt;
}
