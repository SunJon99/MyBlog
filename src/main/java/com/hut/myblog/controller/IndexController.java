package com.hut.myblog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hut.myblog.bean.Blog;
import com.hut.myblog.bean.Tag;
import com.hut.myblog.bean.Type;
import com.hut.myblog.service.TagService;
import com.hut.myblog.service.TypeService;
import com.hut.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author yiyuexiaofusheng
 * @date 2020/12/9
 */
@Controller
public class IndexController {

    @Autowired
    public BlogService blogService;
    @Autowired
    public TagService tagService;
    @Autowired
    public TypeService typeService;
    @GetMapping("/index")
    public String toIndex(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum,ModelMap modelMap){
        int countBlog = blogService.getCountBlog();
        PageHelper.startPage(pagenum, 5);
        List<Blog> blogs = blogService.showBlog();
        PageInfo pageInfo = new PageInfo(blogs);
        modelMap.addAttribute("pageInfo", pageInfo);
        List<Tag> allTag = tagService.getAllTag();
        List<Blog> blogs1=blogService.getRecommend();
        List<Type> allType = typeService.getAllType();
        Map map = typeService.getCountBlogByType();
        modelMap.put("recommend",blogs1);
        modelMap.put("maps",map);
        modelMap.put("alltag",allTag);
        modelMap.put("alltype",allType);
        modelMap.put("blogs",blogs);
        modelMap.put("count",countBlog);
        Map mapbytype = typeService.getCountBlogByType();
        Map mapbytag = tagService.getCountBlogByTag();
        modelMap.put("maptypes",mapbytype);
        modelMap.put("maptags",mapbytag);
        return "index";
    }
    @PostMapping("/search")
    public String search(ModelMap modelMap,String query){
        List<Blog> blogs = blogService.getBlogBySearch(query);
        modelMap.put("blogs",blogs);
        modelMap.put("query",query);
        return "search";
    }
    @GetMapping("/footer/newblog")
    public String newblogs(ModelMap modelMap){
        List<Blog> blogs=blogService.showNew();
        modelMap.addAttribute("news",blogs);
        return "_fragments :: newBlogList";
    }
    @GetMapping("/footer/newblog2")
    public String newblogs2(ModelMap modelMap){
        List<Blog> blogs=blogService.showNew();
        modelMap.addAttribute("news",blogs);
        return "admin/_fragments :: newBlogList";
    }


}
