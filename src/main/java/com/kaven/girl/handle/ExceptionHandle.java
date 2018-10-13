package com.kaven.girl.handle;

import com.kaven.girl.domain.Result;
import com.kaven.girl.exception.GirlException;
import com.kaven.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @program: girl
 * @description: 捕获异常
 * @author: Kaven
 * @create: 2018-10-13 16:00
 **/
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
