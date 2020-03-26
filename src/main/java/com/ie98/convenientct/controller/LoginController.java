package com.ie98.convenientct.controller;


import com.ie98.convenientct.mapper.UserMapper;
import com.ie98.convenientct.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
@CrossOrigin
@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request) {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())){
                 User user = userMapper.findByToken(cookie.getValue());
                 if (user != null){
                     System.out.println(user.getName());
                     request.getSession().setAttribute("user" , user);
                     break;
                 }


            }
        }

        return "login";

    }
}
