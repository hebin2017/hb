package com.maiyuan.test.exception;

/**
 * Created by Administrator on 2017/8/31.
 */
public class RequestEception extends RuntimeException{

    public RequestEception(String str) {
        super(str);
    }
}
