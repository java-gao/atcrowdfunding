package com.adtec.crowd.mapper;

import com.adtec.crowd.entity.po.AdminPO;
import com.adtec.crowd.entity.po.AdminPOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminPOMapper {
    long countByExample(AdminPOExample example);

    int deleteByExample(AdminPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminPO record);

    int insertSelective(AdminPO record);

    List<AdminPO> selectByExample(AdminPOExample example);

    List<AdminPO> selectByKeyword(String keyword);

    AdminPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminPO record, @Param("example") AdminPOExample example);

    int updateByExample(@Param("record") AdminPO record, @Param("example") AdminPOExample example);

    int updateByPrimaryKeySelective(AdminPO record);

    int updateByPrimaryKey(AdminPO record);
}