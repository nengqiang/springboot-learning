package com.hnq.study.service.impl;

import com.hnq.study.model.Area;
import com.hnq.study.service.ICityService;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author henengqiang
 * @date 2018/8/14
 */
@Service
public class CityServiceImpl implements ICityService {

    private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);

    @Override
    public String findCityInfo(Area area) {
        String url = "https://baike.baidu.com/item/" + area.getCityName();

        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = HttpClients.createDefault().execute(httpGet);
            String result = EntityUtils.toString(httpResponse.getEntity());
            String respBody = new String(result.getBytes("ISO-8859-1"), "UTF-8");
            logger.info("得到的原始数据为：{}", respBody);

            return respBody;
        } catch (Exception e) {
            logger.error("接口执行出错：", e);
        }
        return "Get nothing";
    }

}
