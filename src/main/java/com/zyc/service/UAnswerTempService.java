package com.zyc.service;

import com.zyc.model.Example.UanswertempExample;
import com.zyc.model.Uanswertemp;
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
@RequestMapping("uAnserTempController")
public interface UAnswerTempService {
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    String query(@RequestBody UanswertempExample uanswertempExample);

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    String insert(@RequestBody Uanswertemp uanswertemp);

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    String delete(UanswertempExample uanswertempExample);
    @RequestMapping(value = "update",method = RequestMethod.POST)
    String update(@RequestBody Map<String, Object> map) throws Exception ;
    @RequestMapping("toHistory")
    String toHistory(@RequestBody Uanswertemp uanswertemp);
}
