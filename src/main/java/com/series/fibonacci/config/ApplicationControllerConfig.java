package com.series.fibonacci.config;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@NoArgsConstructor
@Configuration
@EnableConfigurationProperties
@RefreshScope
@ConfigurationProperties(prefix = "controller")
public class ApplicationControllerConfig {
    private String basePath;

    private String apiCalculateFibonacci;

    private String apiCalculateFibonacciLimit;

    private String apiGetAllSeriesFibonacci;

    private String apiDeleteSerieFibonacci;



}
