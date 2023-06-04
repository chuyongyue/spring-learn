package com.peerfintech.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description
 * @Author cy
 * @Date 2023/1/5 15:34
 **/
@Configuration
@EnableAspectJAutoProxy
public class PlayerConfig {
    @Bean
    public SgtPeppers sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
