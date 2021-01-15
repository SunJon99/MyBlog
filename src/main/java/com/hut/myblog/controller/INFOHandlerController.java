package com.hut.myblog.controller;

import com.hut.myblog.bean.Tag;
import com.hut.myblog.bean.Type;
import com.hut.myblog.service.BlogShowService;
import com.hut.myblog.service.DeleteBlogService;
import com.hut.myblog.service.TagsService;
import com.hut.myblog.service.TTypeService;
import com.hut.myblog.vo.BlogINFO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO(这里用一句话来描述这个类)
 * @Author Atlas Sun
 * @Date 2020/12/11 10:35
 */
@Controller
@RequestMapping("/info")
public class INFOHandlerController {
    private BlogShowService blogShowService;
    private TTypeService typeService;
    private DeleteBlogService deleteBlogService;
    private TagsService tagsService;

    @Autowired
    public void setTagsService(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @Autowired
    public void setBlogShowService(BlogShowService blogShowService) {
        this.blogShowService = blogShowService;
    }

    @Autowired
    public void setTypeService(TTypeService typeService) {
        this.typeService = typeService;
    }

    @Autowired
    public void setDeleteBlogService(DeleteBlogService deleteBlogService) {
        this.deleteBlogService = deleteBlogService;
    }

    @ResponseBody
    @RequestMapping("/blogs")
    public Map getBlogs(String order){
        Map<String,Object> map = new HashMap<>();
        List<BlogINFO> list = blogShowService.getBlogsINFO();
        System.out.println(list);
        map.put("value",0);
        map.put("info",list);
        return map;
    }

    @RequestMapping("/types")
    @ResponseBody
    public List<Type> getTypes(){
        List<Type> list = typeService.getTypes();
        return list;
    }

    @RequestMapping("/tags")
    @ResponseBody
    public List<Tag> getTags(){
        List<Tag> list = tagsService.getAllTags();
        return list;
    }

    @RequestMapping("/del_blog")
    @ResponseBody
    public void delBlog(String id){
        deleteBlogService.deleteBlog(Integer.valueOf(id));
    }


    @ResponseBody
    @RequestMapping("/search")
    public List<BlogINFO> getSearchResult(@RequestBody Map<String,String> map){
        String title = map.get("title");
        String type = map.get("type");
        String recommend = map.get("recommend");

        Integer type_id = null;
        Integer recommend_i = null;
        if(!"".equals(type)){
            type_id = Integer.valueOf(type);
        }
        if("".equals(title)){
            title = null;
        }
        if("true".equals(recommend)){
            recommend_i = 1;
        }else{
            recommend_i = 0;
        }
        List<BlogINFO> list = blogShowService.getBlogINFOByConditions(type_id,title,recommend_i);
        return list;
    }

}
