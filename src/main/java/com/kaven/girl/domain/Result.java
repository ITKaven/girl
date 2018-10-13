package com.kaven.girl.domain;

/**
 * @program: girl
 * @description: http请求返回对象
 * @author: Kaven
 * @create: 2018-10-13 16:11
 **/
public class Result<T> {

    //状态码
    private Integer code;

    //提示信息
    private String msg;

    //具体的内容
    private T data;

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
