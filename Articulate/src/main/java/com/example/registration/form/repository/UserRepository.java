package com.example.registration.form.repository;

import com.example.registration.form.model.DB.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    User findByUsername(String username);

    User findById(Long user);
}
