package com.yawlle.kittyquotesjava.infra.anime;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeService {
    @GET("random")
    Call<PhraseAnime> getPhrase();

}
