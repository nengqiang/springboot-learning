package com.hnq.study.mq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author henengqiang
 * @date 2018/8/13
 */
@Service
public class MqConsumer {

    @Autowired
    private MqConfig mqConfig;

    @Autowired
    private MessageListener messageListener;

    /**
     * 一般在应用中都会采用push的方法来自动的消费信息
     */
    private DefaultMQPushConsumer dataConsumer;

    @PostConstruct
    public void start() throws MQClientException {
        dataConsumer = new DefaultMQPushConsumer(mqConfig.getGroupName());
        dataConsumer.setNamesrvAddr(mqConfig.getNamesrvAddr());
        dataConsumer.subscribe(mqConfig.getTopic(), mqConfig.getTag());
        dataConsumer.setConsumeThreadMin(mqConfig.getConsumeThreadMin());
        dataConsumer.setConsumeThreadMax(mqConfig.getConsumeThreadMax());
        dataConsumer.registerMessageListener(messageListener);
        dataConsumer.start();
        System.out.printf("==》消费者启动:[nameServer=%s, topic=%s, tag=%s]\n",
                mqConfig.getNamesrvAddr(), mqConfig.getTopic(), mqConfig.getTag());
    }

    @PreDestroy
    public void shutDown() {
        dataConsumer.shutdown();
        System.out.println("|==消费者关闭==|");
    }

}
