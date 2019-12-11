package be.ehb.blog_post.controller;

import be.ehb.blog_post.model.BlogPost;
import be.ehb.blog_post.model.BlogPostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class IndexController {

    @Autowired
    BlogPostDAO dao;

    @ModelAttribute(value = "all")
    public Iterable<BlogPost> findAll(){
        return dao.findAllByDate();
    }

    @ModelAttribute(value = "nBlog")
    public BlogPost blogToSave(){
        return new BlogPost();
    }

    @RequestMapping(value = {"" , "/" , "/index"} , method = RequestMethod.GET)
    public String showIndex(ModelMap map){
        return "index";
    }

    @RequestMapping(value = {"" , "/" , "/index"} , method = RequestMethod.POST)
    public String maakBlog(@ModelAttribute("nBlog") @Valid BlogPost nBlog, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/index";
        }

        dao.save(nBlog);
        return "redirect:/index";
    }

    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET)
    public String deleteBlog(@PathVariable(value = "id") int id){
        dao.deleteById(id);
        return "redirect:/index";
    }
}
