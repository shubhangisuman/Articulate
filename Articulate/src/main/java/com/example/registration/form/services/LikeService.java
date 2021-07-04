package com.example.registration.form.services;

import com.example.registration.form.model.Params.LikeParams;
import com.example.registration.form.model.DB.Article;
import com.example.registration.form.model.DB.Like;
import com.example.registration.form.model.DB.User;
import com.example.registration.form.model.Response.LikeResponse;
import com.example.registration.form.model.Response.RestResponse;
import com.example.registration.form.repository.ArticleRepository;
import com.example.registration.form.repository.LikeRepository;
import com.example.registration.form.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likerepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ArticleRepository articleRepository;
    public RestResponse<LikeResponse> createLike(LikeParams likeParams, String username) {
        User user = userRepository.findByUsername(username);
        Optional<Article> article = articleRepository.findById(likeParams.getArticleId());
        RestResponse<LikeResponse> restResponse= new RestResponse<>();
        if(article.isPresent()){
            Like like = likerepo.findByArticleIdAndUserId(article.get().getId(),user.getId());
            if(like==null) {
                like = new Like();
                like.setUser(user);
                like.setArticle(article.get());
                likerepo.save(like);
                LikeResponse likeResponse = new LikeResponse();
                likeResponse.setUsername(user.getUsername());
                likeResponse.setArticleTitle(article.get().getTitle());
                restResponse.setData(likeResponse);
                restResponse.setMessage("Liked successfully!");
            }
            else{
                likerepo.delete(like);
                restResponse.setData(null);
                restResponse.setMessage("Un-Liked successfully");
            }
            restResponse.setSuccess(true);
        } 
        else{
            restResponse.setData(null);
            restResponse.setSuccess(false);
            restResponse.setMessage("Article not found!");
        }
        return restResponse;
    }
}
