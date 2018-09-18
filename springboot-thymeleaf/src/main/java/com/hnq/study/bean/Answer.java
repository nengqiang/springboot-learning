package com.hnq.study.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

/**
 * @author henengqiang
 * @date 2018/9/17
 */
@JsonSerialize(include = Inclusion.NON_NULL)
public class Answer<T> {

    /**
     * 状态码
     */
    private Integer code = 0;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 消息内容
     */
    private T result;

    public Answer() {
    }

    public static Answer<?> newBuilder() {
        return new Answer();
    }

    @Override
    public String toString() {
        return "Answer{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public Answer<T> setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Answer<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getResult() {
        return result;
    }

    public Answer<T> setResult(T result) {
        this.result = result;
        return this;
    }

}
