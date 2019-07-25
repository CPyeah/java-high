package com.profeta.cp.springbootquick.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * create by CP on 2019/4/15 0015.
 */
@Controller
@ResponseBody
public class Hello {

    Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping("/hello")
    public String hello() {
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
//        ExcelUtils.addValue("list", "");
        return "Hello Spring Boot Quick!";
    }



}
