package com.example.communitydemo.domain.board.service;

import com.example.communitydemo.domain.board.dto.ArticleDto;
import com.example.communitydemo.domain.board.entity.Article;
import com.example.communitydemo.domain.board.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

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


        return new ArticleDto.ArticleBaseResponse(
                savedData.getId(),
                savedData.getCategory_id(),
                request.getCategory_name(),
                savedData.getTitle(),
                savedData.getContent(),
                savedData.getView_count(),
                savedData.getCreated_at(),
                savedData.getUpdated_at()
        );


    }


    public Boolean articlePasswordCheck(Long id,ArticleDto.ArticlePasswordCheckRequest request) {
        Optional<Article> result = repository.findById(id);

        if (result.isPresent()) {
            Article article = result.get();
            return article.getPassword().equals(request.getPassword());
        }
        return false;
    }

    public ArticleDto.ArticleBaseResponse articleUpdate(
            Long id,ArticleDto.ArticleUpdateReuqest request

    ){
        Article article = repository.findById(id).orElseThrow();
        article.setTitle(request.getTitle());
        article.setContent(request.getContent());

        Article savedData = repository.save(article);

        return new ArticleDto.ArticleBaseResponse(
                savedData.getId(),
                savedData.getCategory_id(),
                request.getCategory_name(),
                savedData.getTitle(),
                savedData.getContent(),
                savedData.getView_count(),
                savedData.getCreated_at(),
                savedData.getUpdated_at()
        );

    }
}
