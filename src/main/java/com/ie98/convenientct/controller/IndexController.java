package com.exmaple.Demo.controller;

import com.exmaple.Demo.mapper.UserMapper;
import com.exmaple.Demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
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

        return "index";

    }
}
