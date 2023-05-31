package com.miku.openapi.provider;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.miku.apicommon.model.entity.UserInterfaceInfo;
import com.miku.apicommon.provider.InnerService;
import com.miku.openapi.common.ErrorCode;
import com.miku.openapi.exception.BusinessException;
import com.miku.openapi.service.UserInterfaceInfoService;
import com.miku.openapi.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerServiceImpl implements InnerService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;


    @Resource
    private UserService userService;



    /**
     * 调用接口次数统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        //todo 该部分需要加锁，实现一个分布式锁，保证数据的一致性

        // 判断
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return userInterfaceInfoService.update(updateWrapper);
    }

    /**
     * 判断用户在该接口上是否还有调用次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    @Override
    public boolean hasCount(long interfaceInfoId, long userId) {
        //判空
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserInterfaceInfo one = userInterfaceInfoService.getOne(new QueryWrapper<UserInterfaceInfo>()
                .eq("interfaceInfoId", interfaceInfoId)
                .eq("userId", userId)
                .gt("leftNum", 0));
        return one == null ? false :true;
    }
}
