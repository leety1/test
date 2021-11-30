package com.example.demo.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.MetricsEndpoint.Sample;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="env")
public class TestConfig {
	
	private String servers;
    private Sample obj;

    public String getServers() {
        return servers;
    }
    public void setServers(String servers) {
        this.servers = servers;
    }
    public Sample getObj() {
        return obj;
    }
    public void setObj(Sample obj) {
        this.obj = obj;
    }
}
