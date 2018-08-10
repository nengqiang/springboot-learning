package com.hnq.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author henengqiang
 * @date 2018/8/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringbootTest {

    @Test
    public void printTest() {
        System.out.println("Springboot test success!");
    }

}
