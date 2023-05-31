package com.miku.openapi.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.miku.apicommon.model.entity.UserInterfaceInfo;

/**
 * @author gmj23
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
 * @createDate 2023-04-01 21:37:51
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    /**
     * 检查参数有效性
     * @param userInterfaceInfo 用户接口信息
     * @param add 是否为添加
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口次数统计
     * @param interfaceInfoId interfaceInfoId
     * @param userId 用户id
     * @return 是否查询成功
     */
    boolean invokeCount(long interfaceInfoId,long userId);
}
