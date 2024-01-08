package com.example.communitydemo.domain.board.entity;

import com.example.communitydemo.domain.GlobalTypes;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private int article_id;
    private Date created_at;
    private Date updated_at;
    private GlobalTypes.YesOrNo is_deleted;

    public Comment(){

    }
    public Comment(Long id, String content, int article_id, Date created_at, Date updated_at, GlobalTypes.YesOrNo is_deleted) {
        this.id = id;
        this.content = content;
        this.article_id = article_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.is_deleted = is_deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public GlobalTypes.YesOrNo getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(GlobalTypes.YesOrNo is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", article_id=" + article_id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", is_deleted=" + is_deleted +
                '}';
    }
}
