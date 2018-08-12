package com.hnq.study.bean;

import java.io.Serializable;

/**
 * @author henengqiang
 * @date 2018/8/11
 */
public class Apple implements Serializable {

    private static final long serialVersionUID = -3522189213493863597L;

    /**
     * 颜色
     */
    private String color;

    /**
     * 重量（kg）
     */
    private Double weight;

    /**
     * 品种名称
     */
    private String typeName;

    /**
     * 出产地
     */
    private String origin;

    /**
     * 价格（¥/kg）
     */
    private Double price;

    public Apple() {}

    public Apple(String color, Double weight, String typeName, String origin, Double price) {
        this.color = color;
        this.weight = weight;
        this.typeName = typeName;
        this.origin = origin;
        this.price = price;
    }

    public enum Type {
        /**
         * 红富士：具有晚熟、质优、味美、耐贮等优点
         */
        Red_Fuji("红富士"),
        /**
         * 黄元帅：果实圆形，味甜或略酸
         */
        Huang_Yuanshuai("黄元帅"),
        /**
         * 红星：红星苹果个头大，色泽鲜艳。皮较薄，果肉香甜可口，回味无穷
         */
        Red_Star("红星"),
        /**
         * 国光：果肉黄白色、质细而脆、果汁多、甜酸适口
         */
        Kokomo("国光"),
        /**
         * 嘎拉：果皮薄，有光泽。果肉浅黄色，肉质致密、细脆、汁多，味甜微酸
         */
        Gala("嘎拉");

        private String text;

        Type(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    public enum OriginArea {
        /**
         * 渤海湾产区包括胶东半岛、山东产区、辽宁产区、河北产区和北京、天津两市，是中国苹果栽培最早、产量和面积最大、生产水平最高的产区。
         */
        BoHai("渤海湾苹果产区"),
        /**
         * 西北黄土高原产区包括陕西渭北地区、山西晋南和晋中、河南三门峡地区和甘肃的陇东地区。
         */
        Northwest("西北黄土高原产区"),
        /**
         * 黄河故道产区包括豫东、鲁西南、苏北和皖北，地势低平。
         */
        YelloRiver("黄河故道和秦岭北麓产区"),
        /**
         *  西南冷凉高地产区维度低包括四川阿坝、甘孜两个藏族自治州的川西地区，云南东北部的昭通、宜威地区，贵州西北部的威宁、毕节地区，
         * 西藏昌都以南和雅鲁藏布江中下游地带。
         */
        Southwest("西南冷凉高地产区");

        private String text;

        OriginArea(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", typeName='" + typeName + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                '}';
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
