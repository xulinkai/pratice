package com.xulk.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by xulinkai on 2019/7/21.
 */
@Service
@Slf4j
public class AsyncService {

    @Async
    public void asyncMethod(){
        log.info("异步线程执行。。。。。。。。。。");
    }


}
