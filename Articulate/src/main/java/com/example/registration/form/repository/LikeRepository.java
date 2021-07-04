package com.example.registration.form.repository;

import com.example.registration.form.model.DB.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends CrudRepository<Like,Integer> {

    List<Like> findByArticleId(Integer id);
    Like findByArticleIdAndUserId(Integer article_id, Long user_id);
    List<Like> findByUserId(Long id);
}
