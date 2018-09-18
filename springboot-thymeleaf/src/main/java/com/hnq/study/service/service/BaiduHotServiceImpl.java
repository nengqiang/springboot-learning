package com.hnq.study.service.service;

import com.hnq.study.bean.BaiduHotDataChart;
import com.hnq.study.dao.domain.BaiduHot;
import com.hnq.study.dao.domain.BaiduHotCriteria;
import com.hnq.study.dao.mapper.BaiduHotMapper;
import com.hnq.study.dao.mapper.ext.BaiduHotExtMapper;
import com.hnq.study.service.IBaiduhotService;
import com.hnq.study.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author henengqiang
 * @date 2018/9/14
 */
@Service
public class BaiduHotServiceImpl implements IBaiduhotService {

    private static final Logger logger = LoggerFactory.getLogger(BaiduHotServiceImpl.class);

    @Autowired
    private BaiduHotMapper baiduHotMapper;

    @Autowired
    private BaiduHotExtMapper baiduHotExtMapper;

    @Override
    public List<Map<String, BaiduHotDataChart>> getBaiduHotDataChartList(Integer idStart, Integer idEnd) {
        logger.info("==========>> 开始获取BaiduHot数据...");
        BaiduHotCriteria example = new BaiduHotCriteria();
        example.createCriteria().andIdBetween(idStart, idEnd);

        List<BaiduHot> baiduHotList;
        List<String> hotKinds;

        try {
            baiduHotList = baiduHotMapper.selectByExample(example);
            hotKinds = baiduHotExtMapper.getFieldDataList("title_line1", idStart, idEnd);
        } catch (Exception e) {
            throw new RuntimeException("数据库查询异常，请稍后重试", e);
        }

        logger.info("==========>> 获取BaiduHot数据成功，开始处理数据...");
        List<Map<String, BaiduHotDataChart>> result;
        try {
            result = new ArrayList<>();
            Map<String, BaiduHotDataChart> baiduHotMap = new HashMap<>(16);
            for (String hotKind : hotKinds) {
                BaiduHotDataChart baiduHotDataChart = new BaiduHotDataChart();
                List<String> timeAxis = new ArrayList<>();
                List<Double> increment1 = new ArrayList<>();
                List<Double> increment2 = new ArrayList<>();
                List<Double> increment3 = new ArrayList<>();
                for (BaiduHot baiduHot : baiduHotList) {
                    if (baiduHot.getTitleLine1().equals(hotKind)) {
                        timeAxis.add(DateUtil.dateToString(baiduHot.getCreateDate(), "HH:mm:ss"));
                        increment1.add(Double.parseDouble(baiduHot.getHotStockIncrement1().replace("%", "")));
                        increment2.add(Double.parseDouble(baiduHot.getHotStockIncrement2().replace("%", "")));
                        increment3.add(Double.parseDouble(baiduHot.getHotStockIncrement3().replace("%", "")));
                    }
                }
                baiduHotDataChart.setTimeAxis(timeAxis);
                baiduHotDataChart.setIncrement1(increment1);
                baiduHotDataChart.setIncrement2(increment2);
                baiduHotDataChart.setIncrement3(increment3);
                baiduHotMap.put(hotKind, baiduHotDataChart);
            }
            result.add(baiduHotMap);
        } catch (Exception e) {
            throw new RuntimeException("数据处理异常", e);
        }
        logger.info("==========>> 数据处理完成");
        return result;
    }

}























