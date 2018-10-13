package com.kaven.girl.exception;

/**
 * @program: girl
 * @description: 自定义异常
 * @author: Kaven
 * @create: 2018-10-13 20:02
 **/

import com.kaven.girl.enums.ResultEnum;

/**
 * RuntimeExceptioon   事务回滚
 * */
public class GirlException extends RuntimeException{

    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
