package com.adtec.crowd.service.impl;

import com.adtec.crowd.entity.po.AdminPO;
import com.adtec.crowd.entity.po.RolePO;
import com.adtec.crowd.mapper.RolePOMapper;
import com.adtec.crowd.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RolePOMapper rolePOMapper;

    @Override
    public PageInfo<RolePO> queryRole(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<RolePO> rolePOList = rolePOMapper.selectByKeyword(keyword);
        return new PageInfo<RolePO>(rolePOList);
    }
}
