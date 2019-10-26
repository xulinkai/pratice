package com.xulk.mashibing.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author:
 * @create: 2019-09-22 15:10
 **/
public class Slf4jTest {

    static Logger logger = LoggerFactory.getLogger(Slf4jTest.class);

    public static void main(String[] args) {
        //日志门面会自动扫描日志的实现，采用当前的日志实现的配置进行日志的输出
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.debug("debug");
    }
}
