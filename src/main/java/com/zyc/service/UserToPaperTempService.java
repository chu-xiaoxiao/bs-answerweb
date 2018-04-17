package com.zyc.service;

import com.zyc.model.Example.UsertopapertempExample;
import com.zyc.model.Usertopapertemp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by YuChen Zhang on 18/03/13.
 */
@FeignClient("QUESTION-SERVICE")
@RequestMapping("userToPaperTemp")
public interface UserToPaperTempService {
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    String query(@RequestBody UsertopapertempExample usertopaperhistoryExample);

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    String insert(@RequestBody Usertopapertemp usertopapertemp);

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    String delete(UsertopapertempExample usertopapertempExample);
    @RequestMapping(value = "update",method = RequestMethod.POST)
    String update(@RequestBody Map<String, Object> map) throws Exception ;
}