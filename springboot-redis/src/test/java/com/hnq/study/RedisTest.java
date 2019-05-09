package com.hnq.study;

import com.alibaba.fastjson.JSON;
import com.hnq.study.bean.Apple;
import com.hnq.study.redis.RedisUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.hnq.study.bean.Apple.Type.Red_Fuji;
import static com.hnq.study.bean.Apple.Type.Huang_Yuanshuai;
import static com.hnq.study.bean.Apple.Type.Red_Star;
import static com.hnq.study.bean.Apple.Type.Kokomo;
import static com.hnq.study.bean.Apple.Type.Gala;
import static com.hnq.study.bean.Apple.OriginArea.BoHai;
import static com.hnq.study.bean.Apple.OriginArea.Northwest;
import static com.hnq.study.bean.Apple.OriginArea.YelloRiver;
import static com.hnq.study.bean.Apple.OriginArea.Southwest;

/**
 * @author henengqiang
 * @date 2018/8/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void allMethodTest() throws InterruptedException {
        String key = "test";
        String value = "test_value";
        // 写入缓存
        redisUtils.set(key, value);
        Assert.assertEquals(redisUtils.get(key), value);

        String key1 = "test1";
        String value1 = "test_value1";
        // 写入缓存设置时效时间
        redisUtils.set(key1, value1, 10L, TimeUnit.SECONDS);
        Thread.sleep(5000);
        Assert.assertEquals(redisUtils.get(key1), value1);
        Thread.sleep(6000);
        Assert.assertNull(redisUtils.get(key1));

        // 批量删除对应的value
        redisUtils.set(key1, value1);
        redisUtils.remove(key, key1);
        Assert.assertNull(redisUtils.get(key));
        Assert.assertNull(redisUtils.get(key1));

        // 批量删除key
        redisUtils.removePattern(key);
        redisUtils.removePattern(key1);
        Assert.assertFalse(redisUtils.exists(key));
        Assert.assertFalse(redisUtils.exists(key1));

        // 集合添加
        redisUtils.add(key, value);
        redisUtils.add(key, value1);
        Set<Object> sets = redisUtils.setMembers(key);
        Assert.assertNotNull(sets);

        // 有序集合添加
        String key2 = "zSet";
        redisUtils.zAdd(key2, 1, 1D);
        redisUtils.zAdd(key2, 2, 2D);
        redisUtils.zAdd(key2, 3, 3D);
        redisUtils.zAdd(key2, 4, 4D);
        Set<Object> sets1 = redisUtils.rangeByScore(key2, 2, 4);
        Assert.assertNotNull(sets1);
        redisUtils.remove(key, key2);
    }

    @Test
    public void saveOneAppleTest() {
        String key = "Apple";
        Apple apple = new Apple();
        apple.setColor("red");
        apple.setWeight(0.2);
        apple.setTypeName(Red_Fuji.getText());
        apple.setOrigin(BoHai.getText());
        apple.setPrice(20.0);
        String value = JSON.toJSONString(apple);
        try {
            redisUtils.set(key, value);
            System.out.println("数据存入redis成功，key=" + key + "，value=" + value);
        } catch (Exception e) {
            System.err.println("数据存入redis失败！");
            e.printStackTrace();
        }
    }

    @Test
    public void findTheAppleWePutTest() {
        String key = "Apple";
        try {
            String value = (String)redisUtils.get(key);
            System.out.println("从redis读取数据成功，value=" + value);
            Apple apple = JSON.parseObject(value, Apple.class);
            System.out.println(apple);
        } catch (Exception e) {
            System.err.println("从redis读取数据失败");
            e.printStackTrace();
        }
    }


    @Test
    public void saveAppleToListTest() {
        String key = "AppleList";
        Apple apple1 = new Apple("red", 0.2, Red_Fuji.getText(), BoHai.getText(), 20.0);
        Apple apple2 = new Apple("yellow", 0.3, Huang_Yuanshuai.getText(), Northwest.getText(), 25.0);
        Apple apple3 = new Apple("darkRed", 0.17, Red_Star.getText(), YelloRiver.getText(), 19.0);
        Apple apple4 = new Apple("lightRed", 0.2, Kokomo.getText(), Southwest.getText(), 22.0);
        Apple apple5 = new Apple("lightRed", 0.25, Gala.getText(), BoHai.getText(), 21.0);
        try {
            redisUtils.lPush(key, apple1);
            redisUtils.lPush(key, apple2);
            redisUtils.lPush(key, apple3);
            redisUtils.lPush(key, apple4);
            redisUtils.lPush(key, apple5);
            System.out.println("数据存入redis成功，key=" + key + "，value=" +
                    new ArrayList<Apple>(Arrays.asList(apple1, apple2, apple3, apple4, apple5)));
        } catch (Exception e) {
            System.err.println("数据存入redis失败！");
            e.printStackTrace();
        }
    }

    @Test
    public void findTheAppleListWePutTest() {

        String key = "AppleList";
        try {
            List valueList = redisUtils.lRange(key, 0, -1);
            System.out.println("从redis读取数据成功，value=" + valueList);

            List<Apple> appleList = new ArrayList<Apple>();
            for (Object value : valueList) {
                Apple apple = (Apple)value;
                appleList.add(apple);
            }
            System.out.println(appleList);
        } catch (Exception e) {
            System.err.println("从redis读取数据失败");
            e.printStackTrace();
        }

    }

}