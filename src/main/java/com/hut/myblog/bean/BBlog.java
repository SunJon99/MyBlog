package com.hut.myblog.bean;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *  Blog 实体类中有一个 标签列表，其中需要用到联合查询，这里需要特别设计 resultMap
 * @Description: TODO(这个是一个 Blog 实体类)
 * @Author Atlas Sun
 * @Date 2020/12/10 10:15
 */
@Alias("BBlog")
public class BBlog implements Serializable {

    private Long id;
    //文章标题
    private String title;
    //文章内容
    private String content;
    //文章首图
    private String firstPicture;
    //转载/原创/翻译
    private String flag;
    //查看人数(默认为零)
    private Long views;
    //开启赞赏
    private Long appreciation;
    //转载声明 0/1
    private Integer share;
    //是否开启评论
    private Integer commentable;
    //是否发表
    private Integer published;
    //是否推荐
    private Integer recommend;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //文章类型
    private Long type;
    //文章作者
    private Integer author;
    //文章描述
    private String description;

    private String tags;

    public BBlog(){}

    public BBlog(Long id, String title, String content, String firstPicture, String flag,
                Long views, Long appreciation, Integer share, Integer commentable,
                Integer published, Integer recommend, Date createTime, Date updateTime,
                Long type, Integer author, String description,String tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.firstPicture = firstPicture;
        this.flag = flag;
        this.views = views;
        this.appreciation = appreciation;
        this.share = share;
        this.commentable = commentable;
        this.published = published;
        this.recommend = recommend;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.type = type;
        this.author = author;
        this.description = description;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Long appreciation) {
        this.appreciation = appreciation;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getCommentable() {
        return commentable;
    }

    public void setCommentable(Integer commentable) {
        this.commentable = commentable;
    }

    public Integer getPublished() {
        return published;
    }

    public void setPublished(Integer published) {
        this.published = published;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", share=" + share +
                ", commentable=" + commentable +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", type=" + type +
                ", author=" + author +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
