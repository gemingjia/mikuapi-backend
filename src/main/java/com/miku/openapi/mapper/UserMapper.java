package com.miku.openapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miku.apicommon.common.vo.EchartsVo;
import com.miku.openapi.model.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author gmj23
 * @Entity com.miku.api.model.domain.User
 */
public interface UserMapper extends BaseMapper<User> {

    String getMobile(@Param("username") String username);

    String selectPhone(@Param("mobile") String mobile);

    List<EchartsVo> getUserList(@Param("dateList") List<String> dateList);
}




