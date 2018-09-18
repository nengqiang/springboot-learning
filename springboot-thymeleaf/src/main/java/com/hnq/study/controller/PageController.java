package com.hnq.study.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author henengqiang
 * @date 2018/9/17
 */
@RestController
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/hots")
    public ModelAndView index(Model model) {
        model.addAttribute("title", "BaiduHotDataTendency");
        return new ModelAndView("hots/view", "hotsModel", model);
    }

}