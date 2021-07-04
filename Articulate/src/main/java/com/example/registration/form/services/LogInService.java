package com.example.registration.form.services;

import com.example.registration.form.model.Params.LogInParams;
import com.example.registration.form.model.DB.User;
import com.example.registration.form.model.Response.LogInResponse;
import com.example.registration.form.model.Response.RestResponse;
import com.example.registration.form.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    @Autowired
    private UserRepository userRepository;
    public RestResponse<LogInResponse> logInUser(LogInParams logInParams){
        RestResponse<LogInResponse> restResponse = new RestResponse<>();
        LogInResponse logInResponse = new LogInResponse();
        String username = logInParams.getUsername();
        String result = isValid(logInParams);
        User user = userRepository.findByUsername(username);
        if(result==null && user !=null){
            if(!user.getPassword().equals(logInParams.getPassword())){
                restResponse.setData(null);
                restResponse.setSuccess(false);
                restResponse.setMessage("Incorrect password!");
            }
            else{
                logInResponse.setEmail(user.getEmail());
                logInResponse.setName(user.getName());
                logInResponse.setUsername(username);
                restResponse.setData(logInResponse);
                restResponse.setSuccess(true);
                restResponse.setMessage("hello "+username);
            }
        }
        else if(result==null){
            restResponse.setData(null);
            restResponse.setSuccess(false);
            restResponse.setMessage("user not found!");
        }
        else{
            restResponse.setData(null);
            restResponse.setSuccess(false);
            restResponse.setMessage(result);
        }
        return restResponse;
    }

    private String isValid(LogInParams logInParams) {
        String response=null;
        if(logInParams.getUsername().length()<3){
            response = "UserName should be greater than three alphabets";
        }
        else if(logInParams.getPassword().length()<8 && logInParams.getPassword().length()>20){
            response = "Password should be greater than eight and less than twenty alphabets";
        }
        return response;
    }

}
