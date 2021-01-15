package com.hut.myblog.service;


import com.hut.myblog.bean.Tag;
import com.hut.myblog.bean.Type;

import java.util.List;
import java.util.Map;

public interface TagService {
    List<Tag> getAllTag();
     Map getCountBlogByTag();
    void saveTag(Tag tag);
    List<Tag> getTagById(Long id);
    void updateTag(Long id,String name);
    void deleteTag(Long id);
}
