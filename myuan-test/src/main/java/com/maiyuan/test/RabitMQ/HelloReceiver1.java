/*
package com.maiyuan.test.RabitMQ;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maiyuan.test.entity.SendReport;
import com.maiyuan.test.service.SendService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




@Component
@RabbitListener(queues = "h1")
public class HelloReceiver1 {
    @RabbitHandler
    public void process(String msg) {
        System.err.println("Receiver1  : " + msg);
        ObjectMapper objectMapper=new ObjectMapper();
        List<SendReport> li=new ArrayList<>();
        try {
            List<Map> list=objectMapper.readValue(msg,List.class);
            for (int i = 0; i < list.size(); i++) {
                SendReport sendReport=objectMapper.readValue(objectMapper.writeValueAsString(list.get(0)),SendReport.class);
                li.add(sendReport);
            }
            SendService sendservice=new SendService(li);
            sendservice.doRun();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

  public static void main(String[] args) {
        String json="[{\"taskID\":\"xi15p0j7\",\"mobile\":\"13720169804\",\"status\":\"4\",\"reportTime\":\"Fri Jul 28 13:39:28 CST 2017\",\"reportCode\":\"充值成功\",\"outTradeNo\":null}]";
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            List<Map> list=objectMapper.readValue(json,List.class);
            SendReport sendReport=objectMapper.readValue(objectMapper.writeValueAsString(list.get(0)),SendReport.class);
            System.out.println(sendReport.getMobile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
*/
