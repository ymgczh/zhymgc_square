package com.zhymgc.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2020-3-29.
 */
@Component
@RabbitListener(queues = "zhymgc")
public class ConsumeTwo {

    @RabbitHandler
    public void getMsg(String msg) {
        System.out.println("分裂模式消费：：" + msg);
    }
}
