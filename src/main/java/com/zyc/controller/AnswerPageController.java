package com.zyc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by YuChen Zhang on 18/03/14.
 */
@Controller
public class AnswerPageController {
    @RequestMapping("queryPaper/{id}")
    public ModelAndView queryPaper(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id",id);
        modelAndView.setViewName("paper/page/answer");
        return modelAndView;
    }
}
