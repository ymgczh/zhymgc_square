package com.zhymgc.controller.exception;

import com.zhymgc.entity.Result;
import com.zhymgc.entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Administrator on 2020-3-16.
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exception(Exception e){
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
