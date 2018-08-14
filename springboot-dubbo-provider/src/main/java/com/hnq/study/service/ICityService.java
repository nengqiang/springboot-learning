package com.hnq.study.service;

import com.hnq.study.model.Area;

/**
 * @author henengqiang
 * @date 2018/8/14
 */
public interface ICityService {

    /**
     * 查找地区百度百科
     * @param area  输入这个地区是哪个省哪个城市
     * @return      这个地区百度百科 html 页面
     */
    String findCityInfo(Area area);

}
