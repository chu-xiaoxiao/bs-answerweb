package com.zyc.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("COMPILE-SERVICE")
@RequestMapping("compiler")
public interface CompilerService {
    @RequestMapping(value = "java",method = RequestMethod.POST)
    String compileJava(@RequestBody Iterable codes);
}
