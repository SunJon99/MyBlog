package com.hut.myblog.controller;

import com.hut.myblog.bean.Comment;
import com.hut.myblog.service.BlogService;
import com.hut.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private BlogService blogService;
    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, ModelMap modelMap){
        modelMap.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment){
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlogById(blogId));
        comment.setAvatar(avatar);
        commentService.saveComment(comment);
        return "redirect:/comments/"+ blogId ;
    }
}
