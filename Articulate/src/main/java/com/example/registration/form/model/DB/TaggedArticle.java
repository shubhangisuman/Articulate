package com.example.registration.form.model.DB;

import javax.persistence.*;

@Entity
public class TaggedArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article;
    @OneToOne
    @JoinColumn(name = "tag_id",nullable = false)
    private Tag tag;

    public TaggedArticle() {

    }
    public TaggedArticle(Article article,Tag tag){
        this.article=article;
        this.tag=tag;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
