package com.zyj.bean.controller;

import com.zyj.bean.configration.MasterConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class Controller {
    @Autowired
    MasterConfig masterConfig;

    @GetMapping
    public String propertiesValue() {
        return masterConfig.rateControlTaskType;
    }
} 
