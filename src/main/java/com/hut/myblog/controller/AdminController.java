package com.hut.myblog.controller;

import com.hut.myblog.bean.BBlog;
import com.hut.myblog.service.BlogShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO(这里用一句话来描述这个类)
 * @Author Atlas Sun
 * @Date 2020/12/10 18:34
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private BlogShowService blogShowService;

    @Autowired
    public void setBlogShowService(BlogShowService blogShowService) {
        this.blogShowService = blogShowService;
    }

    @RequestMapping("/index")
    public String admin_blogs(){
        return "admin/bolgs";
    }

    @RequestMapping("/input")
    public String admin_input(ModelMap map){
        BBlog blog = new BBlog();
        blog.setFlag("原创");
        blog.setTitle("");
        blog.setContent("");
        blog.setCommentable(0);
        blog.setAppreciation(Long.valueOf(0));
        blog.setDescription("");
        blog.setFirstPicture("");
        blog.setPublished(0);
        blog.setRecommend(0);
        blog.setId(Long.valueOf(0));
        blog.setShare(0);
        map.addAttribute("blog",blog);
        return "admin/bolgs-input";
    }

    /**
     * 用来处理文章的编辑和添加的请求
     * 如果前端没有传回 文章id 信息，那么就判断这里的操作是添加操作；
     * 如果前端传回 文章id 信息，那么就判断本次操作是修改操作。
     *
     * @return
     */
    @RequestMapping("/edit")
    public String editBLog(String id,ModelMap map){
        map.addAttribute("id",1);
        /**
         * 前端回传的id为空，那么就没有任何操作；
         * 不为空，就传回相关博客的信息，显示在页面上
         */
        BBlog blog = null;
        Integer n_id = null;
        try{
            n_id = Integer.valueOf(id);
        }catch (Exception e){
            System.out.println("id转换出错，id的值不合理！！");
        }
        if(n_id != null){
            blog = blogShowService.getBlogByID(n_id);
        }
        if( blog !=null ){
            map.addAttribute("id",n_id);
            map.addAttribute("blog",blog);
        }
        return "admin/bolgs-input";
    }


    //跳转到前台页面
    @PostMapping("/toBlogPage")
    public String toBlog(Long blogId){
        System.out.println("----------------------试图跳转");
        String  url = "redirect:/blog/" + blogId;
        return url;
    }



}
