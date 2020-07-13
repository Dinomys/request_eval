package com.alight.request_eval.controller;

import com.alight.request_eval.config.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @RequestMapping (value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUser(){
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }
}
