package com.hnq.study.mq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/**
 * @author henengqiang
 * @date 2018/8/13
 */
@Service
public class MqProducer {

    @Autowired
    private MqConfig mqConfig;

    private DefaultMQProducer producer;

    @PostConstruct
    public void init() throws MQClientException {
        producer = new DefaultMQProducer(mqConfig.getGroupName());
        producer.setNamesrvAddr(mqConfig.getNamesrvAddr());
        producer.setMaxMessageSize(mqConfig.getMaxMessageSize());
        producer.start();
    }

    @PreDestroy
    public void destroy() {
        producer.shutdown();
    }

    public String send(Message message) {
        String key = UUID.randomUUID().toString();
        try {
            message.setKeys(key);
            SendResult sendResult = producer.send(message);
            System.out.printf("===》已发送消息:[topic=%s, tag=%s, key=%s, message=%s]\n",
                    message.getTopic(), message.getTags(), key, sendResult.toString());
            return "已发送消息";
        } catch (InterruptedException | RemotingException | MQClientException | MQBrokerException e) {
            System.out.printf("==》发送消息失败:[length=%d, key=%s, body=%s]\n",
                    message.getBody().length, key, new String(message.getBody(), StandardCharsets.UTF_8));
            e.printStackTrace();
            return "发送消息失败";
        }

    }

}
