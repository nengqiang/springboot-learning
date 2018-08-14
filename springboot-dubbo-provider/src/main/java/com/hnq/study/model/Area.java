package com.hnq.study.model;

import java.io.Serializable;

/**
 * @author henengqiang
 * @date 2018/8/14
 */
public class Area implements Serializable {

    private static final long serialVersionUID = -5019914776436247434L;

    private String province;

    private String cityName;

    @Override
    public String toString() {
        return "Area{" +
                "province='" + province + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
