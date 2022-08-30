package com.oppenheimer.scopes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreadScopeConfig {
    @Bean
    public static ThreadScopePostProcess beanFactoryPostProcess() {
        return new ThreadScopePostProcess();
    }
}
