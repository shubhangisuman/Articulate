package com.example.registration.form.services;

import com.example.registration.form.model.Params.EditArticleParams;
import com.example.registration.form.model.Params.NewArticleParams;
import com.example.registration.form.model.Response.CreateArticleResponse;
import com.example.registration.form.model.DB.Article;
import com.example.registration.form.model.DB.Like;
import com.example.registration.form.model.DB.TaggedArticle;
import com.example.registration.form.model.DB.User;
import com.example.registration.form.model.Response.RestResponse;
import com.example.registration.form.model.Response.ViewArticleResponse;
import com.example.registration.form.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaggedArticleRepository taggedArticleRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private LikeRepository likeRepository;
    public RestResponse<CreateArticleResponse> createArticle(NewArticleParams newArticleParams, String username) {
        CreateArticleResponse createArticleResponse = new CreateArticleResponse();
        RestResponse<CreateArticleResponse> restResponse = new RestResponse<>();
        Article article = newArticleParams.getArticle();
        User user = userRepository.findByUsername(username);
        article.setUser(user);
        String result = isValid(article);
        if(result==null){
            articleRepository.save(article);
            String res = article.getTitle();
            createArticleResponse.setTitle(res);
            createArticleResponse.setUsername(article.getUser().getUsername());
            restResponse.setData(createArticleResponse);
            restResponse.setSuccess(true);
            restResponse.setMessage("done");
        }
        else{
            restResponse.setData(null);
            restResponse.setSuccess(false);
            restResponse.setMessage(result);
        }
        return restResponse;
    }

    private String isValid(Article article) {
        if(article.getTitle()==null || article.getTitle().isEmpty())
            return "Title is required!";
        if(article.getBody()==null || article.getBody().isEmpty())
            return "Article cannot be empty!";
        return null;
    }
    public RestResponse<ViewArticleResponse> viewSingleArticle(Integer id) {
        Article article = articleRepository.findById(id).orElse(null);//reffered article
        RestResponse<ViewArticleResponse> restResponse = new RestResponse<>();
        if(article!=null){
            ViewArticleResponse viewArticleResponse = new ViewArticleResponse();
            User user = article.getUser();
            if(article.getPublic() || article.getUser().getId().equals(user.getId())) {
                String username = user.getUsername();//author of article
                List<TaggedArticle> taggedArticles = taggedArticleRepository.findByArticleId(id);
                List<String> tags = new ArrayList<>();//tags of article
                for (int i = 0; i < taggedArticles.size(); i++) {
                    TaggedArticle taggedArticle = taggedArticles.get(i);
                    tags.add(taggedArticle.getTag().getName());
                }
                List<Like> userLikes = likeRepository.findByArticleId(id);
                Set<Long> userIds = new TreeSet<>();
                for (int i = 0; i < userLikes.size(); i++) {
                    User user1 = userLikes.get(i).getUser();
                    userIds.add(user1.getId());
                }
                int likes = userIds.size();//number of likes
                viewArticleResponse.setArticle(article);
                viewArticleResponse.setUsername(username);
                viewArticleResponse.setTags(tags);
                viewArticleResponse.setLikesCount(likes);
                restResponse.setData(viewArticleResponse);
                restResponse.setSuccess(true);
                restResponse.setMessage("Article fetched successfully");
            }
            else{
                restResponse.setData(null);
                restResponse.setSuccess(false);
                restResponse.setMessage("Your are not authorised or article is in private mode");
            }
        }
        else{
            restResponse.setData(null);
            restResponse.setSuccess(false);
            restResponse.setMessage("Article cannot be fetched!");
        }
        return restResponse;
    }

    public RestResponse<Article> editArticle(Integer id, EditArticleParams editArticleParams) {
        String message = "";
        Article article = articleRepository.findById(id).orElse(null);
        if(article==null)
            message="Article not found";
        String body = article.getBody();
        if((editArticleParams.getBody()).equals(body)){
            message="No change in article";
        }
        else{
            article.setBody(editArticleParams.getBody());
        }
        if(article.getPublic()==editArticleParams.getPublic()){
            message="No change in the public visibility";
        }
        else{
            article.setPublic(editArticleParams.getPublic());
        }
        if(message.isEmpty())
            articleRepository.save(article);
        RestResponse<Article> restResponse = new RestResponse<>();
        restResponse.setData(article);
        restResponse.setSuccess(true);
        restResponse.setMessage(message);
        return restResponse;
    }
    private Sort.Direction getSortDirection(String direction){
        if(direction.equals("desc"))
            return Sort.Direction.DESC;
        else
            return Sort.Direction.ASC;
    }
    private List<Article> sortArticles(String[] query){
        List<Sort.Order> sortingParams  = new ArrayList<>();
        for (String s : query) {
            String[] list = s.split("_");
            sortingParams.add(new Sort.Order(getSortDirection(list[1]), list[0]));
        }
        return articleRepository.findAll(Sort.by(sortingParams));
    }
    private List<Article> searchArticles(String query){
        return articleRepository.search(query);
    }
    public RestResponse<List<ViewArticleResponse>> getArticles(String[] sortQuery, String searchQuery, Integer size) {
        RestResponse<List<ViewArticleResponse>> restResponse = new RestResponse<>();
        List<Article> articleList;
        if(Objects.equals(searchQuery, ""))
            articleList = sortArticles(sortQuery);
        else
            articleList = searchArticles(searchQuery);
        List<ViewArticleResponse> viewArticleResponses = new ArrayList<>();
        for (Article article : articleList) {
            if(size-->0)
                viewArticleResponses.add(viewSingleArticle(article.getId()).getData());
        }
        if(viewArticleResponses.isEmpty()){
            restResponse.setData(null);
            restResponse.setSuccess(false);
            restResponse.setMessage("No articles found!");
        }
        else{
            restResponse.setData(viewArticleResponses);
            restResponse.setSuccess(true);
            restResponse.setMessage("Success");
        }
        return restResponse;
    }
}
