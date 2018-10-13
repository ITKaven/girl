package com.kaven.girl.utils;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.kaven.girl.domain.Result;

/**
 * @program: girl
 * @description: 返回 json 数据
 * @author: Kaven
 * @create: 2018-10-13 19:04
 **/
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code , String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
