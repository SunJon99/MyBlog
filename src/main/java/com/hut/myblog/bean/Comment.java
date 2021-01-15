package com.hut.myblog.bean;


import java.util.Date;
import java.util.List;

/**
 * @author yiyuexiaofusheng
 * @date 2020/12/10
 */

public class Comment implements java.io.Serializable{

    private Long id;
    private String nickname;      //昵称
    private String email;      //邮箱
    private String content;      //评论内容
    private String avatar;      //头像

    private Date createTime;


    private Blog blog;


    private List<Comment> replycomments;


    private Comment parentComment;

    public List<Comment> getReplycomments() {
        return replycomments;
    }

    public void setReplycomments(List<Comment> replycomments) {
        this.replycomments = replycomments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Comment() {
    }
}
