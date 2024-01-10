
package com.example.communitydemo.domain.board.controller;


import com.example.communitydemo.domain.board.dto.ArticleDto;
import com.example.communitydemo.domain.board.dto.CommentDto;
import com.example.communitydemo.domain.board.service.ArticleService;
import com.example.communitydemo.domain.board.service.CategoryService;
import com.example.communitydemo.domain.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 1. 게시글 조회
 * 2. 게시글 삭제
 * 3. 게시글 수정
 * 4. 게시글 수정 가능 여부 체크
 * 5. 게시글 이미지 추가
 */
@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;
    private final CommentService commentService;



    // 게시글 조회 view
    @GetMapping("{id}")
    public String articleReadView(Model model, @PathVariable Long id) {
        model.addAttribute("article",articleService.articleRead(id));
        List<CommentDto.CommentBaseResponse> comments = commentService.getComment(id);
        model.addAttribute("comments",comments);
        return "article";
    }

    /**
     * 게시글 작성 컨트롤러. @ModelAttribute 를 통해 dto로 인자를 컨트롤 할 수 있음
     * @param request {@link com.example.communitydemo.domain.board.dto.ArticleDto.ArticleCreateRequest}
     */
    @PostMapping
    public String write(Model model,
                        @ModelAttribute ArticleDto.ArticleCreateRequest request
    ) {
        Long newId = articleService.create(request).getId();
        return String.format("redirect:/article/%d", newId);

    }

    /**

     * 게시글 수정 view
     */
    @GetMapping("{id}/modify")
    public String articleModifyView(
            Model model,
            @PathVariable Long id,
            @RequestParam("token") String token
    ){
        if(token == null){
            return "accessDenied";
        }
        boolean isPossible = Long.parseLong(token) == id;

        if(isPossible){
            model.addAttribute("article",articleService.articleRead(id));
            return "articleModify";
        }else{
            return "accessDenied";
        }
    }


    /**
     * 게시글 수정 전 비밀번호 검증 페이지
     * @return
     */
    @GetMapping("{id}/modify/password-check")
    public String articleModifyPasswordCheckView(
            Model model,
            @PathVariable("id") Long id){
        model.addAttribute("articleId",id);
        return "articleModifyPasswordCheck";
    }


    /**
     * 게시글 수정 페이지 접근 가능 여부 확인 후 접근 가능하면 리다이렉트
     */
    @PostMapping("{id}/modify/password-check")
    public String articleModifyPasswordCheck(
            @PathVariable Long id,
            @ModelAttribute ArticleDto.ArticlePasswordCheckRequest request
          ) {
        boolean isPossible = articleService.articlePasswordCheck(id, request);

        System.out.printf("요청 체크");
        if (isPossible) {
            Long token = id; // 일회용 토큰 생성
            return "redirect:/article/" + id + "/modify?token=" + token;
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("{id}/delete/password-check")
    public void articleDeletePasswordCheck(
            @PathVariable Long id,
            @RequestBody ArticleDto.ArticlePasswordCheckRequest request
    ) {
//        return articleService.articlePasswordCheck(id,request);

    }

    // 게시글 수정
    @PatchMapping("{id}/modify")
    public void articleModify(
            Model model,
            @PathVariable
            Long id
    ) {

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
