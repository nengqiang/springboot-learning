package com.hnq.study.controller;

import com.alibaba.fastjson.JSON;
import com.hnq.study.bean.Answer;
import com.hnq.study.bean.BaiduHotDataChart;
import com.hnq.study.service.IBaiduhotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author henengqiang
 * @date 2018/9/14
 */
@RestController
@RequestMapping(value = "/getData")
public class BaiduHotController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(BaiduHotController.class);

    @Autowired
    private IBaiduhotService baiduhotService;

    @RequestMapping(value = "/hello")
    public String showHello() {
        return "It Works!";
    }

    @RequestMapping(value = "/getBaiduHotChartData")
    public Answer<?> getBaiduHotChartData(@RequestParam("idStart") String idStart, @RequestParam("idEnd") String idEnd) {
        try {
            // 遇到非法输入能捕获到错误
            List<Map<String, BaiduHotDataChart>> result = baiduhotService
                    .getBaiduHotDataChartList(Integer.valueOf(idStart), Integer.valueOf(idEnd));
            logger.info("返回数据：{}", JSON.toJSON(result));
            return renderAnswer(JSON.toJSON(result));
        } catch (Exception e) {
            logger.info("接口执行错误：{}", e.getMessage(), e);
            return renderError("接口执行错误,请检查输入或日志");
        }
    }


}
