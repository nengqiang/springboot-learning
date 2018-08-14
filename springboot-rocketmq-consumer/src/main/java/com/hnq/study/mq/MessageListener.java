package com.hnq.study.mq;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
import static com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus.RECONSUME_LATER;

/**
 * @author henengqiang
 * @date 2018/8/13
 */
@Service
public class MessageListener implements MessageListenerConcurrently {

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        try {
            for (MessageExt msg : msgs) {
                System.out.println("Received:" + new String(msg.getBody(), StandardCharsets.UTF_8) + "\n" + msg.toString());
            }
            return CONSUME_SUCCESS;
        } catch (Exception e) {
            // 重试一次，如果仍然失败则抛弃该消息并处理失败信息
            if (msgs.get(0).getReconsumeTimes() <= 1) {
                return RECONSUME_LATER;
            } else {
                e.printStackTrace();
            }
        }
        return CONSUME_SUCCESS;
    }

}
