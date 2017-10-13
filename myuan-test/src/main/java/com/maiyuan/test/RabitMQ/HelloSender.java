package com.maiyuan.test.RabitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/21.
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;
    
    public void send(String msg) {
      /*  String context = "hello " + new Date();
        System.err.println("Sender : " + context);*/

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.rabbitTemplate.convertAndSend("hb",msg );
    }
}
