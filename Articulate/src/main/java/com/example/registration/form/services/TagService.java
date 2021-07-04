package com.example.registration.form.services;

import com.example.registration.form.model.Params.TagArticleParams;
import com.example.registration.form.model.Params.TagParams;
import com.example.registration.form.model.DB.Article;
import com.example.registration.form.model.DB.Tag;
import com.example.registration.form.model.DB.TaggedArticle;
import com.example.registration.form.model.Response.RestResponse;
import com.example.registration.form.repository.ArticleRepository;
import com.example.registration.form.repository.TagRepository;
import com.example.registration.form.repository.TaggedArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private TaggedArticleRepository taggedArticleRepository;
    public RestResponse<String> createTag(TagParams tagParams) {
        RestResponse<String> restResponse = new RestResponse<>();
        if(tagRepository.findByName(tagParams.getName())==null){
            Tag tag = new Tag();
            tag.setName(tagParams.getName());
            tagRepository.save(tag);
            restResponse.setData(tagParams.getName());
            restResponse.setSuccess(true);
            restResponse.setMessage("Tag created!");
        }
        else{
            restResponse.setData(null);
            restResponse.setSuccess(false);
            restResponse.setMessage("Tag already exist");
        }
        return restResponse;
    }
    public RestResponse<Object> tagArticle(TagArticleParams tagArticleParams) {
        boolean isValid=true;
        Article article = articleRepository.findById(tagArticleParams.getArticleId()).orElse(null);
        isValid= article==null;
        RestResponse<Object> restResponse= new RestResponse<>();
        if(isValid){
            for (int i = 0; i < tagArticleParams.getTags().size(); i++) {
                Tag tag = tagRepository.findByName(tagArticleParams.getTags().get(i));
                TaggedArticle taggedArticle = new TaggedArticle(article, tag);
                taggedArticleRepository.save(taggedArticle);
            }
            restResponse.setData(null);
            restResponse.setMessage("Articles are tagged!");
        }
        else{
            restResponse.setData(null);
            restResponse.setMessage("Article not found!");
        }
        restResponse.setSuccess(isValid);
        return restResponse;
    }

    public RestResponse<List<String>> fetchAllTags() {//fetch and display all the tags present in db
        List<Tag> tags = new ArrayList<>();
        tagRepository.findAll().forEach(tags::add);
        List<String> tagsTitle = new ArrayList<>();
        for(int i=0;i<tags.size();i++){
            tagsTitle.add(tags.get(i).getName());
        }
        RestResponse<List<String>> restResponse = new RestResponse<>();
        restResponse.setData(tagsTitle);
        restResponse.setSuccess(true);
        restResponse.setMessage("All possible tags");
        return restResponse;
    }
}
