package com.adtec.crowd.service.impl;

import com.adtec.crowd.entity.po.RolePO;
import com.adtec.crowd.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public List<RolePO> queryRole(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        return null;
    }
}
