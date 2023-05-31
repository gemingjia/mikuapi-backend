package com.miku.openapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miku.apicommon.model.entity.InterfaceInfo;

/**
* @author gmj23
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-03-29 16:08:39
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    // 参数校验
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
