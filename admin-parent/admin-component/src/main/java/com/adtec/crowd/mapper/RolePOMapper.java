package com.adtec.crowd.mapper;

import com.adtec.crowd.entity.po.RolePO;
import com.adtec.crowd.entity.po.RolePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePOMapper {
    long countByExample(RolePOExample example);

    int deleteByExample(RolePOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePO record);

    int insertSelective(RolePO record);

    List<RolePO> selectByExample(RolePOExample example);
    List<RolePO> selectByKeyword(String keyword);

    RolePO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePO record, @Param("example") RolePOExample example);

    int updateByExample(@Param("record") RolePO record, @Param("example") RolePOExample example);

    int updateByPrimaryKeySelective(RolePO record);

    int updateByPrimaryKey(RolePO record);
}