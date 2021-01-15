package com.hut.myblog.dao;


import com.hut.myblog.bean.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {
    List<Type> getAllType();
    void saveType(Type type);
    List<Type> getTypeById(Long id);
    void updateType(Long id,String name);
    void deleteType(Long id);
    List<Type> getAll();
}
