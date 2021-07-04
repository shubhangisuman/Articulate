package com.example.registration.form.controllers;

import com.example.registration.form.model.Params.LikeParams;
import com.example.registration.form.model.Response.LikeResponse;
import com.example.registration.form.model.Response.RestResponse;
import com.example.registration.form.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LikeController {
    @Autowired
    private LikeService likeService;
    @RequestMapping(method = RequestMethod.POST,value = "likes")
    public RestResponse<LikeResponse> createLike(@RequestBody LikeParams likeParams,@RequestHeader String username){
        return likeService.createLike(likeParams,username);
    }
}