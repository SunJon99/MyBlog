package com.hut.myblog.controller;

import com.hut.myblog.bean.Type;
import com.hut.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TypesController {
    @Autowired
    TypeService typeService;
    @GetMapping("/types")
    public String hh2(ModelMap modelMap){
        List<Type> types=typeService.getAllType();
        modelMap.put("type",types);
        return "admin/types";
    }
    @RequestMapping("/todeleteType")
    public String hh5(ModelMap modelMap,Long id){
        typeService.deleteType(id);
        List<Type> types=typeService.getAllType();
        modelMap.put("type",types);
        return "admin/types";
    }
    @RequestMapping("/toupdateType")
    public String hh78(ModelMap modelMap,Long id){
        modelMap.put("id",id);
        return "admin/types-update";
    }
    @RequestMapping("/tototypes")
    public String zz(String name,Long id,ModelMap modelMap){
        typeService.updateType(id,name);
        List<Type> types=typeService.getAllType();
        modelMap.put("type",types);
        return "admin/types";
    }
    @RequestMapping("/typeinput")
    public String hh6(ModelMap modelMap){
        return "admin/types-input";
    }
    @PostMapping("/types")
    public String hh8(Type type,ModelMap modelMap){
        typeService.saveType(type);
        List<Type> types=typeService.getAllType();
        modelMap.put("type",types);
        return "admin/types";
    }
}
