package com.hut.myblog.dao;

import com.hut.myblog.bean.BBlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BBlogMapper {
    BBlog getByID(Integer id);
    BBlog getByType(Integer tID);
    List<BBlog> getByTitle(String title);
    List<BBlog> getAll();
    List<BBlog> getSomeByConditions(@Param("type") Integer type,
                                   @Param("title") String title,
                                   @Param("recommend") Integer recommend);

    void delByID(Integer id);

    void addOne(BBlog blog);
    void setOne(BBlog blog);


}
