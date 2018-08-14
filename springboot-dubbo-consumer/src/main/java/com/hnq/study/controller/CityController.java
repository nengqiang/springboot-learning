package com.hnq.study.controller;

import com.hnq.study.model.Area;
import com.hnq.study.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author henengqiang
 * @date 2018/8/14
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private ICityService cityService;

    @RequestMapping("/query")
    public String queryCityInfo(@RequestParam("cityName") String cityName) {
        Area area = new Area();
        area.setCityName(cityName);
        return cityService.findCityInfo(area);
    }

}
