package com.peerfintech.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/4 16:16
 **/
@Configuration
@EnableAspectJAutoProxy
@Component
public class ConcertConfig {
    @Bean
    public AroundAudience aroundAudience() {
        return new AroundAudience();
    }

    @Bean
    public DancePerformance dancePerformance() {
        return new DancePerformance();
    }
}
