package com.hnq.study;

import com.hnq.study.bean.BaiduHotDataChart;
import com.hnq.study.service.IBaiduhotService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author henengqiang
 * @date 2018/9/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaiduServiceImplTests {

    @Autowired
    private IBaiduhotService baiduhotService;

    @Test
    public void dataDealTest() {
        List<Map<String, BaiduHotDataChart>> result = baiduhotService.getBaiduHotDataChartList(1, 100);
        if (result != null && result.size() > 0) {
            System.out.println("查询到数据：");
            for (Map<String, BaiduHotDataChart> chartMap : result) {
                for (Map.Entry<String, BaiduHotDataChart> chartEntry : chartMap.entrySet()) {
                    System.out.println(chartEntry.getKey());
                    System.out.println(chartEntry.getValue());
                }
            }
        } else {
            System.out.println("没有查询到数据");
        }
    }

}
