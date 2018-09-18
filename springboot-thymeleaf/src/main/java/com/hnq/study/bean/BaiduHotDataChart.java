package com.hnq.study.bean;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/14
 */
public class BaiduHotDataChart {

    /**
     * chart 横轴 时间轴
     */
    private List<String> timeAxis;

    /**
     * chart 纵轴 数据 increment 包含正负
     */
    private List<Double> increment1;

    private List<Double> increment2;

    private List<Double> increment3;

    @Override
    public String toString() {
        return "BaiduHotDataChart{" +
                "timeAxis=" + timeAxis +
                ", increment1=" + increment1 +
                ", increment2=" + increment2 +
                ", increment3=" + increment3 +
                '}';
    }

    public List<String> getTimeAxis() {
        return timeAxis;
    }

    public void setTimeAxis(List<String> timeAxis) {
        this.timeAxis = timeAxis;
    }

    public List<Double> getIncrement1() {
        return increment1;
    }

    public void setIncrement1(List<Double> increment1) {
        this.increment1 = increment1;
    }

    public List<Double> getIncrement2() {
        return increment2;
    }

    public void setIncrement2(List<Double> increment2) {
        this.increment2 = increment2;
    }

    public List<Double> getIncrement3() {
        return increment3;
    }

    public void setIncrement3(List<Double> increment3) {
        this.increment3 = increment3;
    }

}
