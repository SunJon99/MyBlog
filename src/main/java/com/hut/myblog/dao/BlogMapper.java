package com.hut.myblog.dao;

import com.hut.myblog.bean.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yiyuexiaofusheng
 * @date 2020/12/10
 */
@Mapper
@Repository
public interface BlogMapper {
    List<Blog> getAll();   //查询全部博客

    Blog getBlogById(Long id);   //通过id查询博客

    Integer getBlogCount();   //获得博客条数

    List<Blog> getBlogByYear(String year);   //按年份查询

    List<String> getGroupYear();    //获得时间年份
    void updateview(Long id);
    int getCountBlog();
    List<Blog> showNew();
    List<Blog> showBlog();
    List<Blog> getRecommend();
    int getCountBlogByTag(Long id);
    int getCountBlogByType(Long id);
    List<Blog> getBlogByType(Long id);
    List<Blog> getBlogByTag(Long id);
    List<Blog> getBlogBySearch(String query);
}
