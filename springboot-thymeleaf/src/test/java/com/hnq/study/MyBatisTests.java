package com.hnq.study;

import com.hnq.study.dao.domain.BaiduHot;
import com.hnq.study.dao.domain.BaiduHotCriteria;
import com.hnq.study.dao.mapper.BaiduHotMapper;
import com.hnq.study.dao.mapper.ext.BaiduHotExtMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ViewApplication.class)
public class MyBatisTests {

    @Autowired
    private BaiduHotMapper baiduHotMapper;

    @Autowired
    private BaiduHotExtMapper baiduHotExtMapper;

    @Test
    public void connectionTest() {
        BaiduHotCriteria example = new BaiduHotCriteria();
        example.createCriteria().andIdBetween(28, 30);
        try {
            List<BaiduHot> baiduHots = baiduHotMapper.selectByExampleWithBLOBs(example);
            if (baiduHots != null && baiduHots.size() > 0) {
                System.out.println("查询到数据：");
                for (BaiduHot baiduHot : baiduHots) {
                    System.out.println(baiduHot);
                }
            } else {
                System.out.println("没有查询到数据");
            }
        } catch (Exception e) {
            throw new RuntimeException("发生异常，请检查后重试！", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Test
    public void inquireTest() {
        try {
            List<String> titles = baiduHotExtMapper.getFieldDataList("title_line1", 1, 100);
            if (titles != null && titles.size() > 0) {
                System.out.println("查询到数据：");
                for (String title : titles) {
                    System.out.println(title);
                }
            } else {
                System.out.println("没有查询到数据");
            }
        } catch (Exception e) {
            throw new RuntimeException("发生异常，请检查后重试！", e);
        }
    }

}
