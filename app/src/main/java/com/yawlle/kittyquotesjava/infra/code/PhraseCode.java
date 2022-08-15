package com.yawlle.kittyquotesjava.infra.code;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhraseCode {
    @Expose
    @SerializedName("quote")
    private String quote;

    @Override
    public String toString(){
        return quote + " ";
    }
}
