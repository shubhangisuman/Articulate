package com.example.registration.form.controllers;

import com.example.registration.form.model.Params.LogInParams;
import com.example.registration.form.model.Response.LogInResponse;
import com.example.registration.form.model.Response.RestResponse;
import com.example.registration.form.services.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class LogInController {
    @Autowired
    private LogInService logInService;
    @RequestMapping(method = RequestMethod.POST,value ="/login")
    public RestResponse<LogInResponse> logInUser(@RequestBody LogInParams logInParams){
            return logInService.logInUser(logInParams);
    }
}
