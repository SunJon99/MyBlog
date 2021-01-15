package com.hut.myblog.service.Impl;

import com.hut.myblog.bean.Comment;
import com.hut.myblog.dao.CommentMapper;
import com.hut.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {



    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {

        return commentMapper.findByBlogId(blogId);
    }

    @Override
    public Comment saveComment(Comment comment) {
        Long parentCommentId = comment.getParentComment().getId();
        if(parentCommentId != -1){//如果父id不为-1，表示有父节点。
            comment.setParentComment(commentMapper.findOne((parentCommentId)));
        }else {
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        commentMapper.save(comment);
        return null;
    }
}
