package com.hut.myblog.service;

import com.hut.myblog.bean.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
