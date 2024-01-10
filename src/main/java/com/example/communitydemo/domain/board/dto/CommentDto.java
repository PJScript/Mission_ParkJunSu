package com.example.communitydemo.domain.board.dto;

import com.example.communitydemo.domain.GlobalTypes;
import com.example.communitydemo.domain.board.entity.Article;
import com.example.communitydemo.domain.board.entity.Comment;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class CommentDto {


    public static CommentBaseResponse toDto(Comment entity){
        CommentBaseResponse commentResponse = new CommentBaseResponse();
        commentResponse.setId(entity.getId());
        commentResponse.setContent(entity.getContent());
        commentResponse.setNickname(entity.getNickname());
        commentResponse.setCreated_at(entity.getCreated_at());
        commentResponse.setUpdated_at(entity.getUpdated_at());
        commentResponse.set_deleted(entity.is_deleted());
        return commentResponse;
    }

    /**
     * @Field id - 댓글의 고유 아이디
     * @Field nickname - 댓글의 작성자
     * @Field content - 댓글 내용
     * @Field created_at - 작성일
     * @Field updated_at - 수정일
     * @Field is_deleted - 삭제여부
     */
    @Getter
    @Setter
    public static class CommentBaseResponse{
        private Long id;
        private String nickname;
        private String content;
        private LocalDateTime created_at;
        private LocalDateTime updated_at;
        private boolean is_deleted;
    }

    /**
     * 카테고리 생성 요청 dto
     * @Field post_id - 어떤 게시글에 달린 댓글인지 판별하는 식별값
     * @Field nickname - 댓글 단 사람의 아이디 ( 사용자가 임의로 입력 가능한 값임. 고유 식별 값 아님 )
     * @Field content - 댓글 내용
     *
     */

    @Getter
    @Setter
    public static class CommentCreateRequest{
        private Long article_id;
        private String nickname;
        private String content;
        private String password;

        public static Comment toEntity(CommentCreateRequest dto, Article article){
            Comment comment = new Comment();
            comment.setContent(dto.getContent());
            comment.setNickname(dto.getNickname());
            comment.setArticle(article);
            comment.setPassword(dto.getPassword());
            return comment;
        }
    }


}
