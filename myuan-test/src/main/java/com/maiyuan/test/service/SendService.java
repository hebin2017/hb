package com.maiyuan.test.service;

import com.maiyuan.test.entity.SendReport;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/19.
 */

public class SendService {
    private static Logger logger = LoggerFactory.getLogger(SendService.class);
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType FORM = MediaType.parse("application/x-www-form-urlencoded");
    public static final String url = "http://172.16.13.136:8083/callback/yzx_maiyi";
    private List<SendReport> list;
    private Request request;
    private OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();

    public SendService(List<SendReport> list) {
        this.list = list;
    }
    public SendService() {
        this.list = list;
    }
    public void doRun() {
        if (1==list.size()) {
            SendReport sendReport = list.get(0);
            list=null;
            StringBuffer sb = new StringBuffer(url);
            sb.append("?TaskID=").append(sendReport.getTaskID());
            sb.append("&Mobile=").append(sendReport.getMobile());
            sb.append("&Status=").append(sendReport.getStatus());
            sb.append("&ReportTime=").append(sendReport.getReportTime());
            sb.append("&ReportCode=").append(sendReport.getReportCode());
            sb.append("&OutTradeNo=").append(sendReport.getOutTradeNo());
            String data = sb.toString();
            System.out.println("推送请求参数{}" + data);
            System.out.println(System.currentTimeMillis());
            request = new Request.Builder().url(data)
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .get().build();
        }

        if (request != null) {
            okHttpClient.newCall(request).enqueue(new Callback() {
                public void onFailure(Call call, IOException e) {
                    System.out.println("推送失败");
                }

                public void onResponse(Call call, Response response) throws IOException {
                    System.out.println("推送成功");
                    String json = response.body().string();
                    System.out.println("推送返回数据" + json);
                }
            });
        }
    }

    public void reMye(String json) {
        RequestBody requestBody = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url("http://192.168.99.100:8080/zflow/callback/my")
                .post(requestBody)
                .addHeader("Content-Type", "application/json;charset=utf-8")
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                System.out.println("推送失败");
            }
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("推送成功");
                String json = response.body().string();
                System.out.println("推送返回数据" + json);
            }
        });
    }
}
