package com.hut.myblog.vo;

import java.io.Serializable;

/**
 * @Description: TODO(这里用一句话来描述这个类)
 * @Author Atlas Sun
 * @Date 2020/12/10 18:37
 */
public class BlogINFO implements Serializable {
    private Long id;
    private String title;
    private String type;
    private String recommend;
    private String updateTime;

    public BlogINFO(){}

    public BlogINFO(Long id, String title, String type, String recommend,
                    String updateTime) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.recommend = recommend;
        this.updateTime = updateTime;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "BlogINFO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", recommend='" + recommend + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
