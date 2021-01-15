package com.hut.myblog.service;

import com.hut.myblog.dao.BBlogMapper;
import com.hut.myblog.dao.BlogTagMapper;
import com.hut.myblog.dao.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO(这里用一句话来描述这个类)
 * @Author Atlas Sun
 * @Date 2020/12/11 14:09
 */
@Service
public class DeleteBlogService {

    private BBlogMapper blogMapper;
    private CommentMapper commentMapper;
    private BlogTagMapper blogTagMapper;

    @Autowired
    public void setBlogMapper(BBlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Autowired
    public void setBlogTagMapper(BlogTagMapper blogTagMapper) {
        this.blogTagMapper = blogTagMapper;
    }

    @Autowired
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public void deleteBlog(Integer id){
        blogMapper.delByID(id);
        commentMapper.delCommentDueBlog(id);
        blogTagMapper.delDueBlog(id);
    }
}
