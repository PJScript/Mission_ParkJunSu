
package com.example.communitydemo.domain.board.controller;


import com.example.communitydemo.domain.board.dto.ArticleDto;
import com.example.communitydemo.domain.board.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 1. 게시글 조회
 * 2. 게시글 삭제
 * 3. 게시글 수정
 * 4. 게시글 수정 가능 여부 체크
 * 5. 게시글 이미지 추가
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // 게시글 조회
    @GetMapping("{id}")
    public String articleRead(Model model, @PathVariable Long id) {
        model.addAttribute("article",articleService.articleRead(id));
        return "article";
    }



    // 게시글 작성
    @PostMapping("{id}")
    public void articleCreate(
            @RequestBody ArticleDto.ArticleCreateRequest request) {
//        return articleService.create(request);
    }

    // 게시글 수정 가능 여부 체크 ( 비밀번호 )
    @PostMapping("{id}/password-check")
    public Boolean articlePasswordCheck(
            @PathVariable Long id,
            @RequestBody ArticleDto.ArticlePasswordCheckRequest request
    ) {
        return articleService.articlePasswordCheck(id,request);
    }

    // 게시글 수정
    @PatchMapping("{id}")
    public void articleModify(
            @PathVariable
            Long id,
            @RequestBody ArticleDto.ArticleUpdateReuqest request


    ) {

//        return articleService.articleUpdate(
//                id,request
//        );
        // TODO: 게시글 최종 수정 버튼 클릭 시 비밀번호 다시 체크
    }

    // 게시글 삭제
    @PostMapping("{id}/delete")
    public void articleDelete(@PathVariable Long id, @RequestParam("password") String password
    ) {
        // TODO: 인자로 받은 id에 해당하는 게시물의 password 를 비교후 삭제 가능 여부 처리
    }


    // 게시글 이미지 추가
    @PostMapping("{id}/add-images")
    public void articleAddImages() {
        // TODO: 받아온 이미지를 별도 파일 형태로 저장 후 파일 위치 혹은 url로 변환 후 db에 저장
    }
}
