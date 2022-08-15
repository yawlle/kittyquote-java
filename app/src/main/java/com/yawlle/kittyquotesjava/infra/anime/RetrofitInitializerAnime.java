
package com.yawlle.kittyquotesjava.infra.anime;

import com.yawlle.kittyquotesjava.infra.anime.AnimeService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInitializerAnime {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://animechan.vercel.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    public AnimeService getAnimeService() {
        return this.retrofit.create(AnimeService.class);
    }

}