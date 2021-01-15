package com.hut.myblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hut.myblog.bean.Blog;
import com.hut.myblog.bean.Tag;
import com.hut.myblog.bean.Type;
import com.hut.myblog.service.BlogService;
import com.hut.myblog.service.TagService;
import com.hut.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class TagController {
    @Autowired
    public BlogService blogService;
    @Autowired
    public TagService tagService;
    @Autowired
    private TypeService typeService;
    @GetMapping("/tags")
    public String tags(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum, ModelMap modelMap){
        int countBlog = blogService.getCountBlog();
        PageHelper.startPage(pagenum, 5);
        List<Blog> blogs = blogService.showBlog();
        PageInfo pageInfo = new PageInfo(blogs);
        modelMap.addAttribute("pageInfo", pageInfo);
        List<Tag> allTag = tagService.getAllTag();
        List<Type> allType = typeService.getAllType();
        Map map = typeService.getCountBlogByType();
        modelMap.put("maps",map);
        modelMap.put("alltag",allTag);
        modelMap.put("alltype",allType);
        modelMap.put("blogs",blogs);
        modelMap.put("count",countBlog);
        List<Tag> tags=tagService.getAllTag();
        modelMap.put("tags",tags);
        Map mapbytype = typeService.getCountBlogByType();
        Map mapbytag = tagService.getCountBlogByTag();
        modelMap.put("maptypes",mapbytype);
        modelMap.put("maptags",mapbytag);
        return "tags";
    }
    @GetMapping("/toTag")
    public String toTag(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum,long id,ModelMap modelMap){
        List<Tag> tags=tagService.getAllTag();
        PageHelper.startPage(pagenum, 5);
        List<Blog> blogs=blogService.getBlogByTag(id);
        PageInfo pageInfo = new PageInfo(blogs);
        modelMap.addAttribute("pageInfo", pageInfo);
        Map map = tagService.getCountBlogByTag();
        Map mapbytype = typeService.getCountBlogByType();
        Map mapbytag = tagService.getCountBlogByTag();
        modelMap.put("maptags",mapbytag);
        modelMap.put("maptypes",mapbytype);
        modelMap.put("maps",map);
        modelMap.put("blogs",blogs);
        modelMap.put("maptypes",mapbytype);
        modelMap.put("tags",tags);
        return "tags";
    }
}
