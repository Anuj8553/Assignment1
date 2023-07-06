package com.example.growgh;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClient {
    private static RetroFitClient instance=null;
    private APIs apis;

    private RetroFitClient(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(APIs.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        apis = retrofit.create(APIs.class);
    }
    public static synchronized RetroFitClient getInstance(){
        if(instance==null){
            instance = new RetroFitClient();
        }
        return instance;
    }
    public APIs getApis(){
        return apis;
    }
}
