package com.xulk.threadPool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by xulinkai on 2019/7/21.
 * 线程池的配置
 */
@Slf4j
@Configuration
@EnableAsync
public class ExecutorConfig {

    //核心线程数
    @Value("${async.executor.thread.core_pool_size}")
    private int corePoolSize;

    //最大线程数
    @Value("${async.executor.thread.max_pool_size}")
    private int maxPoolSize;

    //队列大小
    @Value("${async.executor.thread.queue_capacity}")
    private int queueCapacity;

    //线程名字前缀
    @Value("${async.executor.thread.name.prefix}")
    private String namePrefix;

    @Bean
    public Executor asyncServiceExecutor(){
        log.info("根据配置新建一个自定义线城池");
        //ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //使用自定义的线程池，当每次有线程提交到当前线程池中的时候，可以打印当前线程池的详细信息
        //任务总数、已完成数、活跃线程数，队列大小
        ThreadPoolTaskExecutorImpl executor = new ThreadPoolTaskExecutorImpl();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(namePrefix);
        //reject_policy 当pool达到max_size的时候，如何处理新任务
        //Caller_Runs 不再新线程中执行任务 而是由调用者所在的线程执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //线程池初始化
        executor.initialize();
        return executor;
    }


}
