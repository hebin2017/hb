package com.maiyuan.test.RabitMQ;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maiyuan.test.service.SendService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/7.
 */
@Component
@RabbitListener(queues = "hb")
public class MyeReceiver {
    @RabbitHandler
    public void process(String json) {
        System.err.println("MyeReceiver  : " + json);
        ObjectMapper objectMapper = new ObjectMapper();

        SendService sendService = new SendService();
        sendService.reMye(json);

    }
}
