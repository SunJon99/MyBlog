package com.hut.myblog.service;

import com.hut.myblog.dao.TypeMapper;
import com.hut.myblog.bean.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: TODO(这里用一句话来描述这个类)
 * @Author Atlas Sun
 * @Date 2020/12/11 10:30
 */
@Service
public class TTypeService {

    private TypeMapper typeMapper;

    @Autowired
    public void setTypeMapper(TypeMapper typeMapper) {
        this.typeMapper = typeMapper;
    }

    public List<Type> getTypes(){
        return typeMapper.getAll();
    }
}
