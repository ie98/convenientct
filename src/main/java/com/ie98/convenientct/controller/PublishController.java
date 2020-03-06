package com.exmaple.Demo.controller;

import com.exmaple.Demo.mapper.QuestionMapper;
import com.exmaple.Demo.model.Question;
import com.exmaple.Demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    QuestionMapper questionMapper;
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }
    @PostMapping ("/publish")
    public String doPublish(
            @RequestParam(value = "title" , required = false) String title,
            @RequestParam(value = "description" ,required = false) String description,
            @RequestParam(value = "tag" , required = false) String tag ,
            HttpServletRequest request ,
            Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        if (title ==null || "".equals(title)){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if (description ==null || "".equals(description)){
            model.addAttribute("error","描述不能为空");
            return "publish";
        }if (tag ==null || "".equals(tag)){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }

        Question question = new Question();
        question.setDescription(description);
        question.setTitle(title);
        question.setTag(tag);
        question.setGmtcreate(System.currentTimeMillis());
        question.setGmtmodified(question.getGmtcreate());
        if (request.getSession().getAttribute("user")!=null&&title!=null&&description!=null&&tag!=null){
         User user  =   (User)request.getSession().getAttribute("user");
         System.out.println(user.getName());
            System.out.println(description);
            System.out.println(tag);
            questionMapper.Insert(question);
        }else{
            model.addAttribute("error","信息不全");
            return "publish";
        }
        return "publish";
    }

}
