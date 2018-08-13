package com.hnq.study;

import com.alibaba.rocketmq.common.message.Message;
import com.hnq.study.mq.MqConfig;
import com.hnq.study.mq.MqProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;

/**
 * @author henengqiang
 * @date 2018/8/13
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MqProducerTest {

    @Autowired
    private MqConfig mqConfig;

    @Autowired
    private MqProducer mqProducer;

    @Test
    public void sendTest() {
        try {
            Message message = new Message();
            message.setTopic(mqConfig.getTopic());
            message.setTags(mqConfig.getTag());
            String bodyStr = "I'm producer, I send a message to you, do you receive it?";
            message.setBody(bodyStr.getBytes(StandardCharsets.UTF_8));
            String result = mqProducer.send(message);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("发送测试失败");
            e.printStackTrace();
        }
    }

}
