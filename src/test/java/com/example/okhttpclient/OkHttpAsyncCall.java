package com.example.okhttpclient;


import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OkHttpAsyncCall {
    @Autowired
    OkHttpClient okHttpClient;

    @Test
    public void basicAsyncGet(){
        Request request = new Request.Builder()
                .url("https://google.com")
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                assertEquals(response.code(),200);
            }
        });


    }

}
