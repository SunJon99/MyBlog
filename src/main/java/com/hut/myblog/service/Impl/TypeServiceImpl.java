package com.hut.myblog.service.Impl;


import com.hut.myblog.service.TypeService;
import com.hut.myblog.bean.Type;
import com.hut.myblog.dao.BlogMapper;
import com.hut.myblog.dao.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    BlogMapper blogMapper;

    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }

    @Override
    public void saveType(Type type) {
        typeMapper.saveType(type);
    }


    @Override
    public List<Type> getTypeById(Long id) {
        return typeMapper.getTypeById(id);
    }

    @Override
    public void updateType(Long id,String name) {
         typeMapper.updateType(id,name);
    }

    @Override
    public void deleteType(Long id) {
            typeMapper.deleteType(id);
    }


    public Map getCountBlogByType(){
        List<Type> allType = typeMapper.getAllType();
        Map<Type,Integer> map = new LinkedHashMap<>();
        for(Type type: allType){
            map.put(type,blogMapper.getCountBlogByType(type.getId()));
        }
        return map;
    }
}
