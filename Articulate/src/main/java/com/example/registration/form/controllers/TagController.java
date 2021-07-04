package com.example.registration.form.controllers;

import com.example.registration.form.model.Response.RestResponse;
import com.example.registration.form.model.Params.TagArticleParams;
import com.example.registration.form.model.Params.TagParams;
import com.example.registration.form.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TagController {
    @Autowired
    private TagService tagService;
    @RequestMapping(method = RequestMethod.POST,value="/tag")
    public RestResponse<String> createTag(@RequestBody TagParams tagParams){
        return tagService.createTag(tagParams);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/tag_article")//api name should not be in past tense
    public RestResponse<Object> tagArticle(@RequestBody TagArticleParams tagArticleParams){
        return tagService.tagArticle(tagArticleParams);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/all_tags")
    public RestResponse<List<String>> fetchAllTags(){
        return tagService.fetchAllTags();
    }
}
