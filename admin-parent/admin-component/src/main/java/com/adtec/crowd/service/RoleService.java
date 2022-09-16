package com.adtec.crowd.service;

import com.adtec.crowd.entity.po.RolePO;

import java.util.List;

public interface RoleService {
    List<RolePO>  queryRole(String keyword, Integer pageNum, Integer pageSize);
}
