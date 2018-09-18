package com.hnq.study.controller;

import com.hnq.study.bean.Answer;

/**
 * @author henengqiang
 * @date 2018/9/17
 */
public class AbstractController {

    public Answer<?> renderError(String msg) {
        Answer<Object> answer = new Answer<>();
        answer.setCode(1);
        answer.setMsg(msg);
        return answer;
    }

    public Answer<?> renderAnswer(Object result) {
        Answer<Object> answer = new Answer<>();
        answer.setCode(0);
        answer.setMsg("操作完成");
        answer.setResult(result);
        return answer;
    }

}
