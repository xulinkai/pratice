package com.xulk.controller;

import com.xulk.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xulinkai on 2019/7/21.
 */
@RestController
@RequestMapping("/thread")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public String async(){
        asyncService.asyncMethod();
        return "success";
    }

}
