package com.miku.openapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.miku.apicommon.model.entity.InterfaceInfo;
import com.miku.apicommon.service.InnerInterfaceInfoService;
import com.miku.openapi.common.ErrorCode;
import com.miku.openapi.exception.BusinessException;
import com.miku.openapi.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    /**
     * 查询接口接否存在
     * @param url
     * @param method
     * @return
     */
    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if (StringUtils.isAnyBlank(url,method)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        LambdaQueryWrapper<InterfaceInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(InterfaceInfo::getUrl,url);
        queryWrapper.eq(InterfaceInfo::getMethod,method);
        return interfaceInfoMapper.selectOne(queryWrapper);
    }
}
