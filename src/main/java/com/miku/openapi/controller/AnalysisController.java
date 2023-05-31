package com.miku.openapi.controller;

import com.miku.openapi.mapper.UserInterfaceInfoMapper;
import com.miku.openapi.service.InterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 分析控制器
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

//    @GetMapping("/top/interface/invoke")
//    @AuthCheck(mustRole = "admin")
//    public BaseResponse<List<InterfaceInfoVo>> listTopInvokeInterfaceInfo() {
//        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(3);
//        Map<Long, List<UserInterfaceInfo>> interfaceInfoIdObjMap = userInterfaceInfoList.stream()
//                .collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
//        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
//        queryWrapper.in("id",interfaceInfoIdObjMap.keySet());
//        List<InterfaceInfo> interfaceInfoList = interfaceInfoService.list(queryWrapper);
//        if (CollectionUtils.isEmpty(interfaceInfoList)){
//            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
//        }
//        List<InterfaceInfoVo> interfaceInfoVOList = interfaceInfoList.stream().map(interfaceInfo -> {
//            InterfaceInfoVo interfaceInfoVO = new InterfaceInfoVo();
//            BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
//            Integer totalNum = interfaceInfoIdObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
////            interfaceInfoVO.setTotalNum(totalNum);
//            return interfaceInfoVO;
//        }).toList();
//        return ResultUtils.success(interfaceInfoVOList);
//    }
}
