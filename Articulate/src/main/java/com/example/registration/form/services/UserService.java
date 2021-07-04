package com.example.registration.form.services;

import com.example.registration.form.model.DB.Article;
import com.example.registration.form.model.DB.Like;
import com.example.registration.form.model.DB.User;
import com.example.registration.form.model.Params.ViewUserParams;
import com.example.registration.form.model.Response.RestResponse;
import com.example.registration.form.model.Response.ViewUserResponse;
import com.example.registration.form.repository.ArticleRepository;
import com.example.registration.form.repository.LikeRepository;
import com.example.registration.form.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private LikeRepository likeRepository;
    public RestResponse<ViewUserResponse> viewUser(String username, Long userId) {
        User user = userRepository.findByUsername(username);
        ViewUserResponse viewUserResponse = new ViewUserResponse();
        RestResponse<ViewUserResponse> restResponse = new RestResponse<>();
        if(user.getId().equals(userId)){
            viewUserResponse.setUsername(user.getUsername());
            viewUserResponse.setName(user.getName());
            viewUserResponse.setEmail(user.getEmail());//user details
            List<Article> articleList = articleRepository.findByUserId(user.getId());
            HashMap<Integer,String> postedArticles = new HashMap<>();//posted articles
            for (Article article : articleList) {
                postedArticles.put(article.getId(),article.getTitle());
            }
            List<Like> likeList = likeRepository.findByUserId(user.getId());
            HashMap<Integer,String> likedArticles  = new HashMap<>();//liked articles
            for (Like like : likeList) likedArticles.put(like.getArticle().getId(),like.getArticle().getTitle());
            viewUserResponse.setLikedArticle(likedArticles);
            viewUserResponse.setPostedArticle(postedArticles);
            restResponse.setData(viewUserResponse);
            restResponse.setMessage("User details found!");
            restResponse.setSuccess(true);
        }
        else{
            restResponse.setData(null);
            restResponse.setMessage("Incorrect user details!");
            restResponse.setSuccess(false);
        }
        return restResponse;
    }
}
