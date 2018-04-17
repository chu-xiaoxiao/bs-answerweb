package com.zyc.controller;

import com.alibaba.fastjson.JSONObject;
import com.zyc.exception.StatusException;
import com.zyc.model.Uanswerhistory;
import com.zyc.model.Uanswertemp;
import com.zyc.service.UAnswerHistoryService;
import com.zyc.service.UAnswerTempService;
import com.zyc.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YuChen Zhang on 18/03/14.
 */
@RestController
public class UAnswerController {
    @Autowired
    UAnswerTempService uAnswerTempService;

    @Autowired
    UAnswerHistoryService uAnswerHistoryServicel;

    @RequestMapping(value = "insert/tempUAnswer",method = RequestMethod.POST)
    public String insert(Uanswertemp uanswertemp) throws StatusException {
        return new JSONResult(uAnswerTempService.insert(uanswertemp)).getResult();
    }

    @RequestMapping(value = "insert/historyUAnswer",method = RequestMethod.POST)
    public String tohistory(Uanswertemp uanswertemp) throws CloneNotSupportedException, StatusException {
        uAnswerTempService.toHistory(uanswertemp);
        Uanswerhistory uanswerhistory1 = new Uanswerhistory();
        uanswerhistory1.setUserid(uanswertemp.getUserid());
        uanswerhistory1.setPaperid(uanswertemp.getPaperid());
        return new JSONResult(uAnswerHistoryServicel.score(uanswerhistory1)).getResult();
    }
}
