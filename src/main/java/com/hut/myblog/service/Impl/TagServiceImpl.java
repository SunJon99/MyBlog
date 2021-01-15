package com.hut.myblog.service.Impl;


import com.hut.myblog.bean.Tag;
import com.hut.myblog.bean.Type;
import com.hut.myblog.dao.BlogMapper;
import com.hut.myblog.service.TagService;
import com.hut.myblog.dao.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl  implements TagService {
    @Autowired
    TagMapper tagMapper;
    @Autowired
    BlogMapper blogMapper;
    @Override
    public List<Tag> getAllTag() {
        return tagMapper.getAllTag();
    }

    @Override
    public Map getCountBlogByTag() {
        List<Tag> alltag = tagMapper.getAllTag();
        Map<Tag,Integer> map = new LinkedHashMap<>();
        for(Tag tag: alltag){
            map.put(tag,blogMapper.getCountBlogByTag(tag.getId()));
        }
        return map;

    }

    @Override
    public void saveTag(Tag tag) {
         tagMapper.saveTag(tag);
    }

    @Override
    public List<Tag> getTagById(Long id) {
        return tagMapper.getTagById(id);
    }

    @Override
    public void updateTag(Long id, String name) {
         tagMapper.updateTag(id,name);
    }

    @Override
    public void deleteTag(Long id) {
        tagMapper.deleteTag(id);
    }
}
