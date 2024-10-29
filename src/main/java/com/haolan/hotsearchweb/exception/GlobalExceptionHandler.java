package com.haolan.hotsearchweb.exception;


import com.haolan.hotsearchweb.model.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常处理器，捕获所有异常，返回自定义异常信息
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        // 打印异常信息
        e.printStackTrace();
        // 获取异常信息，如果为空，则返回操作失败
        return Result.error(StringUtils.hasLength(e.getMessage())? e.getMessage() : "操作失败");
    }
}
