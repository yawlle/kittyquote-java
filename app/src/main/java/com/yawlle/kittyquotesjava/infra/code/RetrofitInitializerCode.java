package com.yawlle.kittyquotesjava.infra.code;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInitializerCode {
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://nodejs-quoteapp.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public CodeService getCodeService() {
        return this.retrofit.create(CodeService.class);
    }

}
