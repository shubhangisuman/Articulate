package com.example.registration.form.repository;

import com.example.registration.form.model.DB.TaggedArticle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaggedArticleRepository extends CrudRepository<TaggedArticle,Integer> {
    List<TaggedArticle> findByArticleId(Integer id);
}
