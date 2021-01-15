package com.hut.myblog.controller;

import com.hut.myblog.bean.Tag;
import com.hut.myblog.bean.Type;
import com.hut.myblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagsController {
    @Autowired
    TagService tagService;
    @GetMapping("/tags")
    public String hh3(ModelMap modelMap){
        List<Tag> tags=tagService.getAllTag();
        modelMap.put("tag",tags);
        return "admin/tags";
    }
    @RequestMapping("/todeleteTag")
    public String hh4(ModelMap modelMap,Long id){
        tagService.deleteTag(id);
        List<Tag> tags=tagService.getAllTag();
        modelMap.put("tag",tags);
        return "admin/tags";
    }
    @RequestMapping("/toupdateTag")
    public String hh78(ModelMap modelMap,Long id){
        modelMap.put("id",id);
        return "admin/tags-update";
    }
    @RequestMapping("/tototags")
    public String zz(String name,Long id,ModelMap modelMap){
        tagService.updateTag(id,name);
        List<Tag> tags=tagService.getAllTag();
        modelMap.put("tag",tags);
        return "admin/tags";
    }
    @RequestMapping("/taginput")
    public String hh6(ModelMap modelMap){
        return "admin/tags-input";
    }
    @PostMapping("/tags")
    public String kk(Tag tag,ModelMap modelMap){
        tagService.saveTag(tag);
        List<Tag> tags=tagService.getAllTag();
        modelMap.put("tag",tags);
        return "/admin/tags";
    }
}
