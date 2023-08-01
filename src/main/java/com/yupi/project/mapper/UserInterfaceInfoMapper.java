package com.yupi.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yupi.yuapicommon.model.entity.UserInterfaceInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户接口信息 Mapper
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);

    @Select("select * from user_interface_info where userId = #{userId} and interfaceInfoId = #{interfaceInfoId}")
    UserInterfaceInfo getUserInterfaceInfoByInterfaceInfoIdAndUserId(long interfaceInfoId,long userId);
}




