package com.peerfintech.knights.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.peerfintech.knights.BraveKnight;
import com.peerfintech.knights.Knight;
import com.peerfintech.knights.Quest;
import com.peerfintech.knights.SlayDragonQuest;

@Configuration
public class KnightConfig {

  @Bean
  public Knight knight() {
    return new BraveKnight(quest());
  }
  
  @Bean
  public Quest quest() {
    return new SlayDragonQuest(System.out);
  }

}
