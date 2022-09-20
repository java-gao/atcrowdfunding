package com.adtec.crowd.service;

import com.adtec.crowd.entity.po.AdminPO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {
    AdminPO getAdminByAcct(AdminPO adminPO);

    PageInfo<AdminPO> getAdminBykeyword(String keyword, Integer pageNum, Integer pageSize);

    void removeAdminById(Integer adminId);

    void addAdmin(AdminPO admin);

    AdminPO getAdminById(Integer adminId);

    void updateAdminById(AdminPO adminPO);
}
