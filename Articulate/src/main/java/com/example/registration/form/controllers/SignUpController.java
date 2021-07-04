package com.example.registration.form.controllers;

import com.example.registration.form.model.Params.SignUpParams;
import com.example.registration.form.model.Response.SignUpResponse;
import com.example.registration.form.services.SignUpServices;
import com.example.registration.form.model.Response.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/signup")
public class SignUpController {
    @Autowired
    private SignUpServices signUpServices;
    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public RestResponse<SignUpResponse> createUser(@RequestBody SignUpParams signUpParams){
        return(signUpServices.createUser(signUpParams.getUser()));
    }
}
