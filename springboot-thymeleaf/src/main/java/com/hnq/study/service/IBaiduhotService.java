package com.hnq.study.service;

import com.hnq.study.bean.BaiduHotDataChart;

import java.util.List;
import java.util.Map;

/**
 * @author henengqiang
 * @date 2018/9/14
 */
public interface IBaiduhotService {

    /**
     * 获取 指定id间 baiduHot 以商品种类归类Map 以时间为横轴，增长率为纵轴的数据
     * @param idStart   起始id
     * @param idEnd     截止id
     * @return          坐标数据
     */
    List<Map<String, BaiduHotDataChart>> getBaiduHotDataChartList(Integer idStart, Integer idEnd);

}
