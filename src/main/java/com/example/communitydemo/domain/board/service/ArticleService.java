package com.example.communitydemo.domain.board.service;

import com.example.communitydemo.domain.board.dto.ArticleDto;
import com.example.communitydemo.domain.board.entity.Article;
import com.example.communitydemo.domain.board.entity.Category;
import com.example.communitydemo.domain.board.repository.ArticleRepository;
import com.example.communitydemo.domain.board.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;





    /**
     * 하나의 article을 조회하는 메서드
     * @param id
     */
    public ArticleDto.ArticleBaseResponse articleRead(Long id){
        Article article = articleRepository.findById(id).orElseThrow();
        return ArticleDto.ArticleBaseResponse.toDTO(article);

    }

    /**
     * 특정 카테고리 게시판에 글 쓰는 메서드
     *  @param request {@link com.example.communitydemo.domain.board.dto.ArticleDto.ArticleBaseResponse}
     */
    public ArticleDto.ArticleBaseResponse create(ArticleDto.ArticleCreateRequest request){
        Category category = categoryRepository.findById(request.getCategory_id())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));


        Article article = new Article();
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
        article.setCategory(category);
        article.setPassword(request.getPassword());
        return ArticleDto.ArticleBaseResponse.toDTO(articleRepository.save(article));

    }

    public Boolean articlePasswordCheck(Long id,ArticleDto.ArticlePasswordCheckRequest request) {
        Optional<Article> result = articleRepository.findById(id);

        if (result.isPresent()) {
            Article article = result.get();
            return article.getPassword().equals(request.getPassword());
        }
        return false;
    }

    public void articleUpdate(
            Long id,ArticleDto.ArticleUpdateReuqest request

    ){
        Article article = articleRepository.findById(id).orElseThrow();
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());

        Article savedData = articleRepository.save(article);

//        return new ArticleDto.ArticleBaseResponse(
//                savedData.getId(),
//                savedData.getCategory_id(),
//                request.getCategory_name(),
//                savedData.getTitle(),
//                savedData.getContent(),
//                savedData.getView_count(),
//                savedData.getCreated_at(),
//                savedData.getUpdated_at()
//        );

    }
}
