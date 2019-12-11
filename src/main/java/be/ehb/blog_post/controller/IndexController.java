package be.ehb.blog_post.controller;

import be.ehb.blog_post.model.BlogPost;
import be.ehb.blog_post.model.BlogPostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    BlogPostDAO dao;

    @ModelAttribute(value = "all")
    public Iterable<BlogPost> findAll(){
        return dao.findAll();
    }

    @RequestMapping(value = {"" , "/" , "/index"} , method = RequestMethod.GET)
    public String showIndex(ModelMap map){
        return "index";
    }
}
