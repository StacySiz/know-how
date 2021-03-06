package com.base.knowhow.repositories;

import com.base.knowhow.models.Article;
import com.base.knowhow.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article,Long> {
    List<Article> findAll();

    Article getArticleById(Long id);

    Article deleteById(Long id);

    List<Article> findAllByUser(User user);
}
