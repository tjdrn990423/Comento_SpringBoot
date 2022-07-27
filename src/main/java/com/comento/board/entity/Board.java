package com.comento.board.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "board")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board extends Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String writer;
    @Column(columnDefinition = "integer default 0", nullable = false)
    private int viewcnt;

}
