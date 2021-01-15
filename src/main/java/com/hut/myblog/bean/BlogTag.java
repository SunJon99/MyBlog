package com.hut.myblog.bean;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @Description: TODO(中间表 blog - tag)
 * @Author Atlas Sun
 * @Date 2020/12/10 16:03
 */
@Alias("BlogTag")
public class BlogTag implements Serializable {
    private Long id;
    private Long bID;
    private Long tID;

    public BlogTag(){}

    public BlogTag(Long id, Long bID, Long tID) {
        this.id = id;
        this.bID = bID;
        this.tID = tID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getbID() {
        return bID;
    }

    public void setbID(Long bID) {
        this.bID = bID;
    }

    public Long gettID() {
        return tID;
    }

    public void settID(Long tID) {
        this.tID = tID;
    }

    @Override
    public String toString() {
        return "BlogTag{" +
                "id=" + id +
                ", bID=" + bID +
                ", tID=" + tID +
                '}';
    }
}
