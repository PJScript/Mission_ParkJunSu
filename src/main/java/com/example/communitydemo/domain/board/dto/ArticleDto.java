package com.example.communitydemo.domain.board.dto;

import com.example.communitydemo.domain.board.entity.Article;
import com.example.communitydemo.domain.board.entity.Category;
import lombok.*;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;




public class ArticleDto {


    /**
     * @Field id - 게시물의 고유 아이디
     * @Field Category - {@link com.example.communitydemo.domain.board.entity.Category}
     */
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class ArticleBaseResponse {
        private Long id;
        private Category category;
        private String title;
        private String content;
        private int view_count;
        private LocalDateTime created_at;
        private LocalDateTime updated_at;

        /**
         * 조회후 반환된 엔티티를 DTO로 변환해주는 메서드
         * @param entity {@link com.example.communitydemo.domain.board.entity.Article}
         *
         */
        public static ArticleBaseResponse toDTO(Article entity){
            return ArticleBaseResponse.builder()
                    .id(entity.getId())
                    .content(entity.getContent())
                    .category(entity.getCategory())
                    .title(entity.getTitle())
                    .view_count(entity.getView_count())
                    .created_at(entity.getCreated_at())
                    .updated_at(entity.getUpdated_at())
                    .build();
        }


    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class ArticleListPreviewResponse {
        private Long id;
        private String title;
        private int view_count;
        private LocalDateTime created_at;

        public static ArticleListPreviewResponse toDTO(Article entity){
            return ArticleListPreviewResponse.builder()
                    .id(entity.getId())
                    .title(entity.getTitle())
                    .view_count(entity.getView_count())
                    .created_at(entity.getCreated_at())
                    .build();
        }
    }


    /**
     * article 생성 요청 dto
     * @http-type request
     */
    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @RequiredArgsConstructor
    public static class ArticleCreateRequest {
        private String title;
        private String content;
        private String password;
        private Long category_id;
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class ArticlePasswordCheckRequest{

        private String password;



        public void setPassword(String password) {
            this.password = password;
        }

        public ArticlePasswordCheckRequest(Long id, String password) {

            this.password = password;
        }


    }


    /**
     * article 수정 요청 dto
     * @http-type request
     */
    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class ArticleUpdateReuqest {
      private int category_id;
      private String category_name;
      private String title;
      private String content;

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
    }


}


