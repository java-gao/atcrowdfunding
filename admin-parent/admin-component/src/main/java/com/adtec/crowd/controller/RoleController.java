package com.adtec.crowd.controller;

import com.adtec.crowd.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("role/get/page/info.json")
    public String queryRole(
            @RequestParam(value = "keyword",defaultValue = "") String keyword,
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){

        roleService.queryRole(keyword,pageNum,pageSize);
        return null;
    }
}
