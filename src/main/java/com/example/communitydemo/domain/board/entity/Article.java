package com.example.communitydemo.domain.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;




@Getter
@Setter
@RequiredArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    private String title;
    private String content;
    private String password;
    private int view_count;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updated_at;
    private boolean is_deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return view_count == article.view_count && is_deleted == article.is_deleted && Objects.equals(id, article.id) && Objects.equals(category, article.category) && Objects.equals(title, article.title) && Objects.equals(content, article.content) && Objects.equals(password, article.password) && Objects.equals(created_at, article.created_at) && Objects.equals(updated_at, article.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, title, content, password, view_count, created_at, updated_at, is_deleted);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", password='" + password + '\'' +
                ", view_count=" + view_count +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", is_deleted=" + is_deleted +
                '}';
    }
}
