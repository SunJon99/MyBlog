package com.hut.myblog.service.Impl;

import com.hut.myblog.bean.Blog;
import com.hut.myblog.dao.BlogMapper;
import com.hut.myblog.service.BlogService;
import com.hut.myblog.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yiyuexiaofusheng
 * @date 2020/12/10
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;
    @Override
    public int getCountBlog() {
        int count = blogMapper.getCountBlog();
        return count;
    }

    @Override
    public List<Blog> showNew() {
        return blogMapper.showNew();
    }

    @Override
    public List<Blog> getRecommend() {
        List<Blog> recommend = blogMapper.getRecommend();
        return recommend;
    }

    @Override
    public List<Blog> showBlog() {
        List<Blog> blogs = blogMapper.showBlog();
        return blogs;
    }

    @Override
    public List<Blog> getBlogByType(Long id) {
        return blogMapper.getBlogByType(id);
    }

    @Override
    public List<Blog> getBlogByTag(Long id) {
        return blogMapper.getBlogByTag(id);
    }

    @Override
    public int getCountBlogByType(Long id) {
        int countByType = blogMapper.getCountBlogByType(id);
        return countByType;
    }
    @Override
    public int getBlogCount() {
        return blogMapper.getBlogCount();
    }

    @Override
    public int getCountBlogByTag(Long id) {
        return blogMapper.getCountBlogByTag(id);
    }

    @Override
    public Blog getBlogById(Long id) {
        Blog blog =  blogMapper.getBlogById(id);
        blog.setContent(MarkdownUtils.markdownTOHtml(blog.getContent()));
        return blog;
//        return blogMapper.getBlogById(id);
    }

    @Override
    public List<Blog> getBlogBySearch(String query) {
        return blogMapper.getBlogBySearch(query);
    }


    @Override
    public Map<String, List<Blog>> archiveBlog() {//归档一个业务搞定

        List<String> years = blogMapper.getGroupYear();

        Map<String, List<Blog>> map = new LinkedHashMap<>();
        for (String year : years) {
            map.put(year,blogMapper.getBlogByYear(year));
        }
        return map;
    }

    @Override
    public void updateview(Long id) {
        blogMapper.updateview(id);
    }
}
