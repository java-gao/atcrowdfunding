package com.adtec.crowd.service.impl;

import com.adtec.crowd.constant.CrowdConstant;
import com.adtec.crowd.entity.po.AddressPOExample;
import com.adtec.crowd.entity.po.AdminPO;
import com.adtec.crowd.entity.po.AdminPOExample;
import com.adtec.crowd.exception.LoginAcctExistException;
import com.adtec.crowd.exception.LoginFailedException;
import com.adtec.crowd.mapper.AdminPOMapper;
import com.adtec.crowd.service.AdminService;
import com.adtec.crowd.util.CrowdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminPOMapper adminPOMapper;
    public AdminPO getAdminByAcct(AdminPO adminPO) {
        AdminPOExample adminPOExample = new AdminPOExample();
        AdminPOExample.Criteria criteria = adminPOExample.createCriteria();
        criteria.andLoginAcctEqualTo(adminPO.getLoginAcct());
        List<AdminPO> adminPOS = adminPOMapper.selectByExample(adminPOExample);
        if(adminPOS.size() == 0 || adminPO == null){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        if(adminPOS.size() > 1){
            throw new RuntimeException();
        }
        String passWord = adminPOS.get(0).getUserPswd();
        String passWordForm = adminPO.getUserPswd();
        if(Objects.equals(passWord,passWordForm)){
            return adminPOS.get(0);
        }else {
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }

    }

    public PageInfo<AdminPO> getAdminBykeyword(String keyword, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<AdminPO> adminPOList = adminPOMapper.selectByKeyword(keyword);

        return new PageInfo<AdminPO>(adminPOList);
    }

    @Override
    public void removeAdminById(Integer adminId) {
        adminPOMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public void addAdmin(AdminPO admin) {
        admin.setUserPswd(CrowdUtil.md5(admin.getUserPswd()));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        admin.setCreateTime(time);

        try {
            adminPOMapper.insert(admin);
        } catch (Exception e) {
            if(e instanceof DuplicateKeyException){
                throw new LoginAcctExistException(CrowdConstant.MESSAGE_LOGINACCT_DUPLICATE);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public AdminPO getAdminById(Integer adminId) {

        return adminPOMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public void updateAdminById(AdminPO adminPO) {
        adminPOMapper.updateByPrimaryKeySelective(adminPO);
    }

}
