package com.maiyuan.test.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/28.
 */
public class MqSendReport {
    private List<SendReport> list=new ArrayList<>();

    public List<SendReport> getList() {
        return list;
    }

    public void setList(List<SendReport> list) {
        this.list = list;
    }
}
