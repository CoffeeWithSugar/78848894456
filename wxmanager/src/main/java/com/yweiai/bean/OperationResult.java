package com.yweiai.bean;

import org.apache.tomcat.util.modeler.BaseModelMBean;

/**
 * 接口统一返回结果
 * @author wj
 */
public class OperationResult {
    /**
     * 接口相应状态码
     */
    private int code;

    /**
     * 接口响应数据
     */
    private BaseBean data;

    /**
     * 接口响应信息描述
     */
    private String msg;

    public OperationResult(int code, BaseBean data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BaseBean getData() {
        return data;
    }

    public void setData(BaseBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public OperationResult() {

    }

    @Override
    public String toString() {
        return "OperationResult{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
