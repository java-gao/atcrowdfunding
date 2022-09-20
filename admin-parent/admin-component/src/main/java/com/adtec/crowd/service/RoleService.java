package com.adtec.crowd.service;

import com.adtec.crowd.entity.po.RolePO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleService {
    PageInfo<RolePO> queryRole(String keyword, Integer pageNum, Integer pageSize);
}
