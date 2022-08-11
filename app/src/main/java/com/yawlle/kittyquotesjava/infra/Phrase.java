package com.yawlle.kittyquotesjava.infra;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Phrase {
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("en")
    @Expose
    private String en;

    public String getAuthor(){
        return author;
    }

    public String getEn(){
        return en;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setEn(String en) {
        this.en = en;
    }

    @Override
    public String toString(){
        return en + "\n" + author;
    }
}
