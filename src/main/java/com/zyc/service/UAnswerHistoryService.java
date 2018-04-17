package com.zyc.service;

import com.zyc.model.Example.UanswerhistoryExample;
import com.zyc.model.Uanswerhistory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by YuChen Zhang on 18/03/14.
 */
@FeignClient("QUESTION-SERVICE")
@RequestMapping("uAnserHistoryController")
public interface UAnswerHistoryService {
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    String query(@RequestBody UanswerhistoryExample uanswerhistoryExample);

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    String insert(@RequestBody Uanswerhistory uanswerhistory);

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    String delete(UanswerhistoryExample uanswerhistoryExample);
    @RequestMapping(value = "update",method = RequestMethod.POST)
    String update(@RequestBody Map<String, Object> map) throws Exception ;
    @RequestMapping(value = "answer",method = RequestMethod.POST)
    String score(@RequestBody Uanswerhistory uanswerhistory) throws CloneNotSupportedException;
}
