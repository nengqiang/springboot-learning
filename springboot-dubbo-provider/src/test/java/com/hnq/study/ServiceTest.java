package com.hnq.study;

import com.hnq.study.model.Area;
import com.hnq.study.service.ICityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author henengqiang
 * @date 2018/8/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DubboProvider.class)
public class ServiceTest {

    @Autowired
    private ICityService cityService;

    @Test
    public void cityServiceTest() {
        Area area = new Area();
        area.setCityName("石家庄");
        String result = cityService.findCityInfo(area);
        System.out.println(result);
    }

}
