package com.miku.openapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miku.apicommon.model.entity.UserInterfaceInfo;
import com.miku.openapi.common.ErrorCode;
import com.miku.openapi.exception.BusinessException;
import com.miku.openapi.mapper.UserInterfaceInfoMapper;
import com.miku.openapi.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author gmj23
 * @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
 * @createDate 2023-04-01 21:37:51
 */
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {

        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Long id = userInterfaceInfo.getId();
        Long userId = userInterfaceInfo.getUserId();
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        Integer totalNum = userInterfaceInfo.getTotalNum();
        Integer leftNum = userInterfaceInfo.getLeftNum();
        Integer status = userInterfaceInfo.getStatus();
        Date createTime = userInterfaceInfo.getCreateTime();
        Date updateTime = userInterfaceInfo.getUpdateTime();
        Integer isDelete = userInterfaceInfo.getIsDelete();

        // 创建时，参数不能为空
        if (add) {
            if (leftNum < 0 || totalNum < 0) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "次数禁止小于0！");
            }
        }
        // 有参数则校验
        if (id <= 0 || userId <= 0 || interfaceInfoId <= 0) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "用户或接口不存在！");
        }
    }

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        if (interfaceInfoId<=0||userId<=0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户或者接口不存在！");
        }
        LambdaUpdateWrapper<UserInterfaceInfo> updateWrapper= new LambdaUpdateWrapper<>();
        updateWrapper.eq(UserInterfaceInfo::getInterfaceInfoId,interfaceInfoId);
        updateWrapper.eq(UserInterfaceInfo::getUserId,userId);
        updateWrapper.gt(UserInterfaceInfo::getLeftNum,0);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }

}




