package com.hnq.study.service;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

/**
 * @author henengqiang
 * @date 2019/07/17
 */
@Component("myJob")
public class MyJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        int item = shardingContext.getShardingItem();
        switch (item) {
            case 0:
                // do something by sharding item 0
                System.out.println(String.format("-----ThreadId:%s,当前分片项：%s", Thread.currentThread().getId(), item));
                break;
            case 1:
                // do something by sharding item 1
                System.out.println(String.format("-----ThreadId:%s,当前分片项：%s", Thread.currentThread().getId(), item));
                break;
            case 2:
                // do something by sharding item 2
                System.out.println(String.format("-----ThreadId:%s,当前分片项：%s", Thread.currentThread().getId(), item));
                break;
            default:
                System.out.println("Default!");
                break;
        }
    }

}
