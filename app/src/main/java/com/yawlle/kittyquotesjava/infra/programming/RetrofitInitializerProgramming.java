package com.yawlle.kittyquotesjava.infra.programming;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInitializerProgramming {

        private Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://programming-quotes-api.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        public ProgrammingService getProgService() {
            return this.retrofit.create(ProgrammingService.class);
        }

}