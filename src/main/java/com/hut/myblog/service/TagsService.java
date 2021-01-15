package com.hut.myblog.service;

import com.hut.myblog.dao.BlogTagMapper;
import com.hut.myblog.dao.TagMapper;
import com.hut.myblog.bean.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO(这里用一句话来描述这个类)
 * @Author Atlas Sun
 * @Date 2020/12/13 19:31
 */
@Service
public class TagsService {
    private TagMapper  tagMapper;
    private BlogTagMapper blogTagMapper;

    @Autowired
    public void setTagMapper(TagMapper tagMapper) {
        this.tagMapper = tagMapper;
    }

    @Autowired
    public void setBlogTagMapper(BlogTagMapper blogTagMapper) {
        this.blogTagMapper = blogTagMapper;
    }

    public List<Tag> getAllTags(){
        return tagMapper.getAll();
    }

    public List<Tag> getBlogTags(Integer blogId){
        return blogTagMapper.getSomeByBlog(blogId);
    }

}
