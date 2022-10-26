package com.hui.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.*;


@Data
@Configuration
@ConfigurationProperties(prefix = "thread.pool")
public class ThreadPoolConfig {
    private Integer corePoolSize;
    private Integer maxPoolSize;
    private Integer keepAliveSeconds;
    private Integer queueCapacity;
    private String threadName;

    @Bean(name = "SystemTaskThead")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        // 设置最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        // 设置工作队列大小
        threadPoolTaskExecutor.setQueueCapacity(keepAliveSeconds);
        // 设置线程名称前缀
        threadPoolTaskExecutor.setThreadNamePrefix(threadName + "-");
        // 设置拒绝策略.当工作队列已满,线程数为最大线程数的时候,接收新任务抛出RejectedExecutionException异常
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        // 初始化线程池
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;
    }

    @Bean("SystemCachedThead")
    public ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }

    @Bean(("SystemScheduledThead"))
    public ScheduledExecutorService scheduledExecutorService(){
        return Executors.newScheduledThreadPool(1);
    }

}
