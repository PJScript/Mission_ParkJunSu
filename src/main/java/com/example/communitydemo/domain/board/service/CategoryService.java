package com.example.communitydemo.domain.board.service;

import com.example.communitydemo.domain.board.dto.ArticleDto;
import com.example.communitydemo.domain.board.dto.CategoryDto;
import com.example.communitydemo.domain.board.entity.Article;
import com.example.communitydemo.domain.board.entity.Category;
import com.example.communitydemo.domain.board.repository.ArticleRepository;
import com.example.communitydemo.domain.board.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final ArticleRepository articleRepository;

    public List<Category> findAllCategory(){
        List<Category> category = repository.findAll();
        return  category;
    }
    public CategoryDto.CategoryBaseResponse findById(Long id){

        Category category = repository.findById(id).orElseThrow();

        return new CategoryDto.CategoryBaseResponse(
                category.getId(),
                category.getLabel(),
                category.getValue(),
                category.getSort_order(),
                category.getCreated_at(),
                category.getUpdated_at()
        );

    }

    /**
     * 카테고리 아이디를 통해 해당 카테고리의 게시물만 불러오는 메서드
     * @param category_value 카테고리의 고유 값입니다.
     */
    public List<ArticleDto.ArticleListPreviewResponse> getArticleListPreview(String category_value){
        List<Article> articles = articleRepository.findArticleByCategory(category_value);
        if(articles.isEmpty()){
            return null;
        }else{
            List<ArticleDto.ArticleListPreviewResponse> list = new ArrayList<>();
            for (Article article : articles) {
                list.add(ArticleDto.ArticleListPreviewResponse.toDTO(article));
            }
            return list;
        }
    }
}
