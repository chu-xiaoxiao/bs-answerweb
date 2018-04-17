package com.zyc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyc.exception.StatusException;
import com.zyc.service.CompilerService;
import com.zyc.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CompilerController {
    @Autowired
    public CompilerService compilerService;

    @RequestMapping(value = "java",method = RequestMethod.POST)
    public String java(@RequestBody String code) throws StatusException, UnsupportedEncodingException {
        code = URLDecoder.decode(code,"UTF-8");
        code = code.replace("$^^compilercode^^$=","");
        List<String> codes = new ArrayList<>();
        codes.add(code);
        return new JSONResult(compilerService.compileJava(codes)).getResult();
    }

}
