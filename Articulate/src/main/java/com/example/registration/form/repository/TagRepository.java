package com.example.registration.form.repository;

import com.example.registration.form.model.DB.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
    Tag findByName(String s);
}
