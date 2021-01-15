package com.hut.myblog.controller;

import com.hut.myblog.service.BlogService;
import com.hut.myblog.service.CommentService;
import com.hut.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    //归档
    @GetMapping("/archives")
    public String archiveBlog(ModelMap modelMap){
        modelMap.addAttribute("count",blogService.getBlogCount());
        modelMap.addAttribute("archiveMap",blogService.archiveBlog());
        return "archives";
    }

    //博客详情,需要传入参数 博客id，现在默认为1
    @GetMapping("blog/{blogId}")
    public String blogContent(@PathVariable Long blogId, ModelMap modelMap){
        blogService.updateview(blogId);
        modelMap.addAttribute("user","lijun");
        modelMap.addAttribute("blog",blogService.getBlogById(blogId));
        modelMap.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        return "blog";
    }
}
