package com.pyrenty.samples.udp.config;

import com.pyrenty.samples.udp.service.UdpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;

@Configuration
public class IntegrationConfig {

    @Bean
    public UdpService udpService() {
        return new UdpService();
    }

    @Bean
    public IntegrationFlow processUdpMessage() {
        return IntegrationFlows
                .from(new UnicastReceivingChannelAdapter(8000))
                .handle("udpService", "receive")
                .get();
    }
}
