package com.example.registration.form.controllers;
import com.example.registration.form.model.DB.Article;
import com.example.registration.form.model.Response.CreateArticleResponse;
import com.example.registration.form.model.Params.EditArticleParams;
import com.example.registration.form.model.Params.NewArticleParams;
import com.example.registration.form.model.Response.RestResponse;
import com.example.registration.form.model.Response.ViewArticleResponse;
import com.example.registration.form.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.POST, value = "/create_article")
    public RestResponse<CreateArticleResponse> createArticle(@RequestBody NewArticleParams newArticleParams, @RequestHeader String username) {
        return articleService.createArticle(newArticleParams, username);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/article/{id}")
    public RestResponse<ViewArticleResponse> viewSingleArticle(@PathVariable Integer id) {
        return articleService.viewSingleArticle(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/article/{id}")//edit the body and isPublic
    public RestResponse<Article> editArticle(@PathVariable Integer id, @RequestBody EditArticleParams editArticleParams) {
        return articleService.editArticle(id, editArticleParams);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/articles")
    public RestResponse<List<ViewArticleResponse>> getArticles(@RequestParam(value = "sort", defaultValue = "createdAt_desc", required = false) String[] sortParams,
                                                               @RequestParam(value = "limit", defaultValue = "10", required = false) Integer size,
                                                               @RequestParam(value = "query", defaultValue = "", required = false) String query) {
        return articleService.getArticles(sortParams, query, size);
    }
}


