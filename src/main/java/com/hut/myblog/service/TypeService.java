package com.hut.myblog.service;



import com.hut.myblog.bean.Type;

import java.util.List;
import java.util.Map;

public interface TypeService {
    List<Type> getAllType();
    void saveType(Type type);
    List<Type> getTypeById(Long id);
    void updateType(Long id,String name);
    void deleteType(Long id);
    public Map getCountBlogByType();
}
