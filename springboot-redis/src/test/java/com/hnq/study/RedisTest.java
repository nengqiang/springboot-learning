package com.hnq.study;

import com.alibaba.fastjson.JSON;
import com.hnq.study.model.Apple;
import com.hnq.study.redis.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hnq.study.model.Apple.Type.Red_Fuji;
import static com.hnq.study.model.Apple.Type.Huang_Yuanshuai;
import static com.hnq.study.model.Apple.Type.Red_Star;
import static com.hnq.study.model.Apple.Type.Kokomo;
import static com.hnq.study.model.Apple.Type.Gala;
import static com.hnq.study.model.Apple.OriginArea.BoHai;
import static com.hnq.study.model.Apple.OriginArea.Northwest;
import static com.hnq.study.model.Apple.OriginArea.YelloRiver;
import static com.hnq.study.model.Apple.OriginArea.Southwest;

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