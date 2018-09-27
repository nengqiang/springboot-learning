package com.hnq.study.controller;

import com.hnq.study.bean.Answer;

/**
 * @author henengqiang
 * @date 2018/9/17
 */
public class AbstractController {

    public Answer<?> renderError(String msg) {
        Answer<Object> answer = new Answer<>();
        return answer.setCode(1).setMsg(msg);
    }

    public Answer<?> renderAnswer(Object result) {
        Answer<Object> answer = new Answer<>();
        return answer.setCode(0).setMsg("操作完成").setResult(result);
    }

}
