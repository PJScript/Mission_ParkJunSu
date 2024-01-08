package com.example.communitydemo.domain.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ArticleHashTag{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int article_id;
    private int hashtag_id;


    public ArticleHashTag() {
    }
    public ArticleHashTag(Long id, int article_id, int hastag_id) {
        this.id = id;
        this.article_id = article_id;
        this.hashtag_id = hastag_id;
    }

    @Override
    public String toString() {
        return "ArticleHashTag{" +
                "id=" + id +
                ", article_id=" + article_id +
                ", hastag_id=" + hashtag_id +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getHastag_id() {
        return hashtag_id;
    }

    public void setHastag_id(int hastag_id) {
        this.hashtag_id = hastag_id;
    }


}
