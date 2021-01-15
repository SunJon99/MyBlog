package com.hut.myblog.service;

import com.hut.myblog.dao.BBlogMapper;
import com.hut.myblog.dao.TypeMapper;
import com.hut.myblog.bean.BBlog;
import com.hut.myblog.bean.Type;
import com.hut.myblog.vo.BlogINFO;
import jdk.nashorn.internal.codegen.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: TODO(这里用一句话来描述这个类)
 * @Author Atlas Sun
 * @Date 2020/12/10 18:36
 */

@Service
public class BlogShowService {

    private BBlogMapper blogMapper;
    private TypeMapper typeMapper;

    @Autowired
    public void setBlogMapper(BBlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    @Autowired
    public void setTypeMapper(TypeMapper typeMapper) {
        this.typeMapper = typeMapper;
    }

    /**
     * 获取用来显示在管理界面的博客信息列表
     * @return
     */
    public List<BlogINFO> getBlogsINFO(){
        List<BBlog> list  = blogMapper.getAll();
        List<Type> typeList = typeMapper.getAll();

        //初始化type映射表
        HashMap<Long,String> typeMap = new HashMap<>();
        for (Type type: typeList
             ) {
            typeMap.put(type.getId(),type.getName());
        }

        List<BlogINFO> infoList = new ArrayList<>();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //info转换
        for (BBlog blog: list
             ) {
            BlogINFO blogINFO = new BlogINFO();
            blogINFO.setId(blog.getId());
            blogINFO.setTitle(blog.getTitle());
            if(blog.getRecommend()>0){
                blogINFO.setRecommend("是");
            }else{
                blogINFO.setRecommend("否");
            }
            blogINFO.setType(typeMap.get(blog.getType()));
            blogINFO.setUpdateTime(dateFormater.format(blog.getUpdateTime()));
            //向列表中添加元素
            infoList.add(blogINFO);
        }
        return infoList;
    }

    /**
     * 通过条件获取BLogINFO list
     * @param type
     * @param title
     * @param recommend
     * @return
     */
    public List<BlogINFO> getBlogINFOByConditions(Integer type,String title,
                                                  Integer recommend)
    {
        List<BBlog> list  = blogMapper.getSomeByConditions(type,title,recommend);
        List<Type> typeList = typeMapper.getAll();
        //初始化type映射表
        HashMap<Long,String> typeMap = new HashMap<>();
        for (Type item: typeList
        ) {
            typeMap.put(item.getId(),item.getName());
        }

        List<BlogINFO> infoList = new ArrayList<>();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //info转换
        for (BBlog blog: list
        ) {
            BlogINFO blogINFO = new BlogINFO();
            blogINFO.setId(blog.getId());
            blogINFO.setTitle(blog.getTitle());
            if(blog.getRecommend()>0){
                blogINFO.setRecommend("是");
            }else{
                blogINFO.setRecommend("否");
            }
            blogINFO.setType(typeMap.get(blog.getType()));
            if(blog.getUpdateTime()!=null){
                blogINFO.setUpdateTime(dateFormater.format(blog.getUpdateTime()));
            }
            //向列表中添加元素
            infoList.add(blogINFO);
        }
        return infoList;
    }

    public BBlog getBlogByID(Integer id){
        return blogMapper.getByID(id);
    }
}
