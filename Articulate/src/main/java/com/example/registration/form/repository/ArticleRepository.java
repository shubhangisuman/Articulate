package com.example.registration.form.repository;

import com.example.registration.form.model.DB.Article;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends CrudRepository<Article,Integer> {
    Article findByTitle(String articleTitle);
    Optional<Article> findById(Integer id);

    List<Article> findByUserId(Long id);

    List<Article> findAll(Sort by);
    @Query("SELECT a FROM Article a WHERE a.title LIKE %?1%")
    List<Article> search(String query);
}
