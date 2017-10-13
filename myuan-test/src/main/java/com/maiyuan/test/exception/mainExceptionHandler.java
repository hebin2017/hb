package com.maiyuan.test.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Administrator on 2017/8/31.
 */

public class mainExceptionHandler {
    @ExceptionHandler(value = {RequestEception.class})
    public final void handleException(RequestEception ex) {
        System.out.println("1111111111111111111111111"+ ex.getMessage());
    }

    public static void main(String[] args) {
        if (1==1){
            throw new RequestEception("测试错误");
        }
    }
}
