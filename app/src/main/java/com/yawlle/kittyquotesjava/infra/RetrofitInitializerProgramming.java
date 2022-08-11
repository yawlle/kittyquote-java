package com.yawlle.kittyquotesjava.infra;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public interface RetrofitInitializerProgramming {
    public static final Companion Companion = com.yawlle.kittyquotesjava.infra.RetrofitInitializerProgramming$Companion.$$INSTANCE;

    @GET(value="Quotes/random")
    public Call<Phrase> getPhrase();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        private static String url;

        private Companion() {
        }

        public final String getUrl() {
            return url;
        }

        public final void setUrl(String string) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
            url = string;
        }

        public final RetrofitInitializerProgramming create() {
            Retrofit retrofit = new Retrofit.Builder().addConverterFactory((Converter.Factory) GsonConverterFactory.create()).baseUrl(url).build();
            Object object = retrofit.create(RetrofitInitializerProgramming.class);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"retrofit.create(Retrofit\u2026rProgramming::class.java)");
            return (RetrofitInitializerProgramming)object;
        }

        static {
            $$INSTANCE = new Companion();
            url = "https://programming-quotes-api.herokuapp.com/";
        }
    }
}