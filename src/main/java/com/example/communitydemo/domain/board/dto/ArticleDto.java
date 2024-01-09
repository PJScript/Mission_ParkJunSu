package com.example.communitydemo.domain.board.dto;

import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;


public class ArticleDto {
    public static class ArticleBaseResponse {
        public ArticleBaseResponse(Long id, int category_id, String category_name, String title, String content, int view_count, LocalDateTime created_at, LocalDateTime updated_at) {
            this.id = id;
            this.category_id = category_id;
            this.category_name = category_name;
            this.title = title;
            this.content = content;
            this.view_count = view_count;
            this.created_at = created_at;
            this.updated_at = updated_at;
        }

        private Long id;
        private int category_id;
        private String category_name;
        private String title;
        private String content;
        private int view_count;


        private LocalDateTime created_at;

        private LocalDateTime updated_at;
        // static factory method
        // static factory method



        public Long getId() {
            return id;
        }
        public int getCategory_id(){return category_id;}
        public String getCategory_name() {
            return category_name;
        }
        public String getTitle() {
            return title;
        }
        public String getContent() {
            return content;
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

        public void setId(Long id) {
            this.id = id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
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
    }

    public static class ArticleCreateRequest {
        private String title;
        private String content;
        private int view_count;
        private String password;
        private int category_id;
        private String category_name;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getView_count() {
            return view_count;
        }

        public void setView_count(int view_count) {
            this.view_count = view_count;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }
    }
    public static class ArticlePasswordCheckRequest{

        private String password;



        public void setPassword(String password) {
            this.password = password;
        }

        public ArticlePasswordCheckRequest(Long id, String password) {

            this.password = password;
        }



        public String getPassword() {
            return password;
        }
    }
    public static class ArticleUpdateReuqest {
      private int category_id;
      private String category_name;
      private String title;
      private String content;

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    }


