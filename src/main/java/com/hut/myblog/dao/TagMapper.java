package com.hut.myblog.dao;


import com.hut.myblog.bean.Tag;
import com.hut.myblog.bean.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface TagMapper {
    List<Tag> getAllTag();
    void saveTag(Tag tag);
    List<Tag> getTagById(Long id);
    void updateTag(Long id,String name);
    void deleteTag(Long id);
    List<Tag> getAll();
}
