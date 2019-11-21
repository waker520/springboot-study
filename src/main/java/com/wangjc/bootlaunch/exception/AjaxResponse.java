package com.wangjc.bootlaunch.exception;

import lombok.Data;


@Data

public class AjaxResponse {

    private boolean isok;   //判断是否处理成功
    private int code;       //请求响应状态码（200：成功、400：客户端错误、500：服务端错误）
    private String message; //请求结果描述信息
    private Object data;    //请求结果数据

    private AjaxResponse(){

    }

    public static AjaxResponse success(){
        AjaxResponse resultBean =new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static AjaxResponse success(Object data){
        AjaxResponse resultBean =new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }
}
