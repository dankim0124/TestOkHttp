package com.example.okhttpclient;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.RequestBuilder;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class OkHttpSyncCall {

    @Autowired
    OkHttpClient okHttpClient;

    @Test
    public void getReq() throws IOException{
        Request request = new Request.Builder().url("https://www.google.com").build();
        Call call = okHttpClient.newCall(request);
        Response response = call.execute();
        assertEquals(200, response.code());
    }
}
