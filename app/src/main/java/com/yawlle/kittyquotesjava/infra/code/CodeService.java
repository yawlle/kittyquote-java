package com.yawlle.kittyquotesjava.infra.code;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CodeService {
    @GET("quote")
    Call<PhraseCode> getPhrase();

}
