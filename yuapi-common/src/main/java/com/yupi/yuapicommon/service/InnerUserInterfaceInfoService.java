package com.yupi.yuapicommon.service;

import com.yupi.yuapicommon.model.entity.UserInterfaceInfo;

/**
 * 内部用户接口信息服务
 */
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    UserInterfaceInfo remainingCount(long interfaceInfoId, long userId);
}
