package com.hut.myblog.dao;

import com.hut.myblog.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    List<Comment> findByBlogId(@Param("blogId") Long blogId);

    Comment findOne (Long commentId);

    int save(@Param("comment")Comment comment);
    void delCommentDueBlog(Integer id);
}
