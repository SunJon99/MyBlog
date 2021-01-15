package com.hut.myblog.service;

import com.hut.myblog.bean.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author yiyuexiaofusheng
 * @date 2020/12/10
 */
public interface BlogService {

    int getCountBlog();
    List<Blog> showNew();
    List<Blog> getRecommend();
    List<Blog> showBlog();
    List<Blog> getBlogByType(Long id);
    List<Blog> getBlogByTag(Long id);
    int getCountBlogByType(Long id);
    int getBlogCount();
    int getCountBlogByTag(Long id);
    //通过id获取博客
    Blog getBlogById(Long id);
    List<Blog> getBlogBySearch(String query);
    //一个业务搞定归档
    Map<String , List<Blog>> archiveBlog();
    void updateview(Long id);
}
