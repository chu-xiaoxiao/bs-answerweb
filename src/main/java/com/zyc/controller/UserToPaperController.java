package com.zyc.controller;

import com.zyc.exception.StatusException;
import com.zyc.model.Example.UsertopapertempExample;
import com.zyc.model.Usertopaperhistory;
import com.zyc.model.Usertopapertemp;
import com.zyc.service.UserToPaperHistoryService;
import com.zyc.service.UserToPaperTempService;
import com.zyc.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YuChen Zhang on 18/03/13.
 */
@RestController
public class UserToPaperController {
    @Autowired
    UserToPaperHistoryService userToPaperHistoryService;

    @Autowired
    UserToPaperTempService userToPaperTempService;

    @RequestMapping(value = "insert/tempuserToPaper",method = RequestMethod.POST)
    public String insertTemp(Usertopapertemp usertopapertemp) throws StatusException {
        ;
        return new JSONResult(userToPaperTempService.insert(usertopapertemp)).getResult();
    }

    @RequestMapping(value = "insert/historyuserToPaper",method = RequestMethod.POST)
    public String insertHistory(Usertopaperhistory usertopaperhistory) throws StatusException {
        //组织删除临时表数据
        UsertopapertempExample usertopapertempExample = new UsertopapertempExample();
        usertopapertempExample.createCriteria().andUseridEqualTo(usertopaperhistory.getUserid()).andPaperidEqualTo(usertopaperhistory.getPaperid());
        //插入历史表
        userToPaperHistoryService.insert(usertopaperhistory);
        //删除临时表
        return new JSONResult(userToPaperTempService.delete(usertopapertempExample)).getResult();
    }
}
