package com.alight.request_eval.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public long getLoggedUserId (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        long id = 0;
        try {
            id = Long.parseLong(currentUser);
        } catch (Exception e){
            authentication.setAuthenticated(false);
        }
        return id;
    }


}
