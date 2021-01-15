package com.hut.myblog.dao;

import com.hut.myblog.bean.BlogTag;
import com.hut.myblog.bean.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogTagMapper {
    void delDueBlog(Integer id);
    List<Tag> getSomeByBlog(Integer id);
    void setOne(BlogTag blogTag);
    void addOne(BlogTag blogTag);
}
