package com.hut.myblog.controller;

import com.hut.myblog.dao.BBlogMapper;
import com.hut.myblog.dao.BlogTagMapper;
import com.hut.myblog.bean.BBlog;
import com.hut.myblog.bean.BlogTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description: TODO(这里用一句话来描述这个类)
 * @Author Atlas Sun
 * @Date 2020/12/14 15:51
 */
@Controller
public class AdminEditController {
    private BBlogMapper blogMapper;
    private BlogTagMapper blogTagMapper;

    @Autowired
    public void setBlogMapper(BBlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Autowired
    public void setBlogTagMapper(BlogTagMapper blogTagMapper) {
        this.blogTagMapper = blogTagMapper;
    }

    @RequestMapping("/blog/edit")
    @ResponseBody
    public Info editBlog(@RequestBody Map<String,String> map){
        Long id = strNumToLong(map.get("id"));
        Long appreciation = stringToLong(map.get("appreciation"));
        Integer share = stringToInteger(map.get("shareInfo"));
        Integer commentable = stringToInteger(map.get("comment"));
        Integer recommend = stringToInteger(map.get("recommend"));
        Integer published = Integer.valueOf(map.get("published"));
        Long type = strNumToLong(map.get("type"));
        String flag = map.get("flag");
        String title = map.get("title");
        String description = map.get("description");
        String content = map.get("content");
        String tags =  map.get("tags");
        String first_p = map.get("first_p");


        BBlog item = new BBlog();
        item.setShare(share);
        item.setId(id);
        item.setAppreciation(appreciation);
        item.setCommentable(commentable);
        item.setRecommend(recommend);
        item.setPublished(published);
        item.setType(type);
        item.setFlag(flag);
        item.setTitle(title);
        item.setDescription(description);
        item.setContent(content);
        item.setTags(tags);
        item.setFirstPicture(first_p);
        //设置作者
        item.setAuthor(1);
        BlogTag one = new BlogTag();
        one.setbID(item.getId());
        one.settID(strNumToLong(item.getTags()));
        //添加操作
        try{
            if(item.getId() == 0){
                blogMapper.addOne(item);
                if(one.gettID() != 0){
                    blogTagMapper.addOne(one);
                }
            }else{
                blogMapper.setOne(item);
                if(one.gettID() != 0){
                    blogTagMapper.setOne(one);
                }
            }
            return new Info("操作成功！！！");
        }catch (Exception e){
            return new Info("操作失败！！");
        }

    }

    private class Info{
        private String message;

        public Info(){}
        public Info(String info){
            this.message = info;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "message='" + message + '\'' +
                    '}';
        }
    }

    private Long strNumToLong(String num){
        try{
            return Long.valueOf(num);
        }catch (NumberFormatException e){
            return Long.valueOf(0);
        }
    }

    private Long stringToLong(String value){
        if("true".equals(value)){
            return Long.valueOf(1);
        }else{
            return Long.valueOf(0);
        }
    }

    private Integer stringToInteger(String value){
        if("true".equals(value)){
            return Integer.valueOf(1);
        }else{
            return Integer.valueOf(0);
        }
    }

}
