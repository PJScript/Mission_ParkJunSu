package com.example.communitydemo.domain.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String caption;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private boolean is_deleted;

    @ManyToOne(fetch = FetchType.EAGER)
    private Article article;
}
