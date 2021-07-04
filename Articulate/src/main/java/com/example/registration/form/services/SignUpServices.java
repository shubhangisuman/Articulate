package com.example.registration.form.services;

import com.example.registration.form.model.Response.RestResponse;
import com.example.registration.form.model.DB.User;
import com.example.registration.form.model.Response.SignUpResponse;
import com.example.registration.form.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SignUpServices {
    @Autowired
    private UserRepository userRepository;
    public RestResponse<SignUpResponse> createUser(User user) {
        RestResponse<SignUpResponse> restResponse = new RestResponse<>();
        String result = isValid(user);
        SignUpResponse signUpResponse = new SignUpResponse();
        if(result==null){
            userRepository.save(user); //in try and catch for exceptions
            restResponse.setSuccess(true);
            restResponse.setMessage("User created successfully!");
            signUpResponse.setEmail(user.getEmail());
            signUpResponse.setUsername(user.getUsername());
            restResponse.setData(signUpResponse);
        }
        else{
            restResponse.setMessage(result);
            restResponse.setSuccess(false);
            restResponse.setData(null);
        }
        return restResponse;
    }
    private String isValid(User user){
        String response =null;
        String emailRegex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(user.getEmail());
        if(user.getName().length()<2){
            response = "Name should be greater than two alphabets";
        }
        else if(user.getUsername().length()<3){
            response = "UserName should be greater than three alphabets";
        }
        else if(!matcher.matches()){
            response = "email doesnot match pattern";
        }
        else if(user.getPassword().length()<8 && user.getPassword().length()>20){
            response = "Password should be greater than eight and less than twenty alphabets";
        }
        else if(user.getType()==null){
            response = "select a user type";
        }
        return response;
    }
}
