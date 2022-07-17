package com.comento.board.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "board")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String writer;
    @Column
    private Date regdate;
    @Column
    private int viewcnt;

}
