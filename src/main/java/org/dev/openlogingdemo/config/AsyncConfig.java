package org.dev.openlogingdemo.config;

import org.dev.openlogging.decorator.MDCTaskDecorator;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    public ThreadPoolTaskExecutor threadPoolTaskExecutor(@NonNull MDCTaskDecorator mdcTaskDecorator) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(10);
        executor.setTaskDecorator(mdcTaskDecorator);
        executor.initialize();
        return executor;
    }
}
