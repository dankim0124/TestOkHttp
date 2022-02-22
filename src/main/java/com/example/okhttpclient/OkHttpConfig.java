package com.example.okhttpclient;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class OkHttpConfig {

    @Bean
    public OkHttpClient okHttpClient(){

        ConnectionPool connectionPool = new ConnectionPool(100,1, TimeUnit.MINUTES);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .connectionPool(connectionPool)
                        .callTimeout(1,TimeUnit.MINUTES)
                        .writeTimeout(1,TimeUnit.MINUTES)
                        .build();
        return okHttpClient;

    }
}
