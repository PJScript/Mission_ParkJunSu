package com.example.communitydemo.domain.board.entity;

import com.example.communitydemo.domain.GlobalTypes;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import static com.example.communitydemo.domain.GlobalTypes.YesOrNo.N;
import static com.example.communitydemo.domain.GlobalTypes.YesOrNo.Y;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int category_id;
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

    public Article() {

    }
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public Article(Long id, int category_id, String title, String content, String password, Long view_count, Date created_at, Date updated_at) {
        this.id = id;
        this.category_id = category_id;
        this.title = title;
        this.content = content;
        this.password = password;
        this.view_count = 1;
        this.is_deleted = false;
    }




    public Long getId() {
        return id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPassword() {
        return password;
    }

    public int getView_count() {
        return view_count;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public boolean getIs_deleted() {
        return is_deleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", password='" + password + '\'' +
                ", view_count=" + view_count +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", is_deleted=" + is_deleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return category_id == article.category_id && Objects.equals(id, article.id) && Objects.equals(title, article.title) && Objects.equals(content, article.content) && Objects.equals(password, article.password) && Objects.equals(view_count, article.view_count) && Objects.equals(created_at, article.created_at) && Objects.equals(updated_at, article.updated_at) && is_deleted == article.is_deleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category_id, title, content, password, view_count, created_at, updated_at, is_deleted);
    }
}
