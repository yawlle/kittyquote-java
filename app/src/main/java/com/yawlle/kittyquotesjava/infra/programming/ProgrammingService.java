package com.yawlle.kittyquotesjava.infra.programming;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProgrammingService {
    @GET("Quotes/random")
    Call<Phrase> getPhrase();


}
