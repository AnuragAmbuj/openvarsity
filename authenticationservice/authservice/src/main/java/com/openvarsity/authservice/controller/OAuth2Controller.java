package com.openvarsity.authservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OAuth2Controller {

    @GetMapping(path = "/oauth2/login")
    public ModelAndView loginPage(){
        return new ModelAndView("error");
    }

}
