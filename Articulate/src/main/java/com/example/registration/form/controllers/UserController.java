package com.example.registration.form.controllers;

import com.example.registration.form.model.Response.RestResponse;
import com.example.registration.form.model.Response.ViewUserResponse;
import com.example.registration.form.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(method= RequestMethod.GET,value="/user/{id}")
    public RestResponse<ViewUserResponse> viewUser(@RequestHeader String username, @PathVariable Long id){
        return userService.viewUser(username,id);
    }
}
