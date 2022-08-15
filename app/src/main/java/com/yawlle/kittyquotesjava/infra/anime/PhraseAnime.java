package com.yawlle.kittyquotesjava.infra.anime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhraseAnime {
    @Expose
    @SerializedName("anime")
    private String anime;
    @Expose
    @SerializedName("quote")
    private String quote;
    @Expose
    @SerializedName("character")
    private String character;

    @Override
    public String toString(){
        return quote + " - \n " + "From: " + character + ", \n" + anime;
    }
}
