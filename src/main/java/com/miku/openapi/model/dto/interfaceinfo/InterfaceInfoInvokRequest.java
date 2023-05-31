package com.miku.openapi.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口调用请求
 *
 * @author miku
 * @TableName product
 */
@Data
public class InterfaceInfoInvokRequest implements Serializable {


    /**
     * 接口id
     */
    private Long  id;

    /**
     * 请求参数
     */
    private String userRequestParams;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 请求参数
     */
    private String method;

}