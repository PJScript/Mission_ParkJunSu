package com.example.communitydemo.domain.board.service;

import com.example.communitydemo.domain.board.dto.ArticleDto;
import com.example.communitydemo.domain.board.entity.Article;
import com.example.communitydemo.domain.board.repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleRepository repository;

    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public ArticleDto.ArticleBaseResponse create(
            ArticleDto.ArticleCreateRequest request
    ) {
        Article article = new Article();
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());
        article.setCategory_id(request.getCategory_id());
        article.setPassword(request.getPassword());

        Article savedData = repository.save(article);
        System.out.println(savedData.toString());

        ArticleDto.ArticleBaseResponse response = new ArticleDto.ArticleBaseResponse(
                savedData.getId(),
                savedData.getCategory_id(),
                request.getCategory_name(),
                savedData.getTitle(),
                savedData.getContent(),
                savedData.getView_count(),
                savedData.getCreated_at(),
                savedData.getUpdated_at()
        );


        return response;


    }


}
