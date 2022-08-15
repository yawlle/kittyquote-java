package com.yawlle.kittyquotesjava;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.yawlle.kittyquotesjava.infra.code.PhraseCode;
import com.yawlle.kittyquotesjava.infra.code.RetrofitInitializerCode;
import com.yawlle.kittyquotesjava.infra.programming.Phrase;
import com.yawlle.kittyquotesjava.infra.anime.PhraseAnime;
import com.yawlle.kittyquotesjava.infra.QuoteConstants;
import com.yawlle.kittyquotesjava.infra.anime.RetrofitInitializerAnime;
import com.yawlle.kittyquotesjava.infra.programming.RetrofitInitializerProgramming;
import com.yawlle.kittyquotesjava.infra.SecurityPreferences;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int category_Id = QuoteConstants.FILTER.COMPUTER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }

        Button new_phrase = findViewById(R.id.button_new_phrase);
        new_phrase.setOnClickListener(this);
        ImageView button_quote = findViewById(R.id.image_quotes);
        button_quote.setOnClickListener(this);
        ImageView button_anime = findViewById(R.id.image_happy);
        button_anime.setOnClickListener(this);
        ImageView button_code = findViewById(R.id.image_code);
        button_code.setOnClickListener(this);

        TextView text_phrase = findViewById(R.id.textView_phrase);

        handleUserName();
        handleFilter(R.id.image_quotes);




    }

    private void handleUserName() {
        TextView name = findViewById(R.id.hello_name);
        SecurityPreferences sharedPreferences = new SecurityPreferences(getSharedPreferences("NerdQuotes", Context.MODE_PRIVATE));
        String finalUserName = sharedPreferences.getNomeString(QuoteConstants.KEY.USER_NAME);

        name.setText("Hi, " + finalUserName + "!");



    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_new_phrase) {
            handleNextPhrase(category_Id);
        } else {
            handleFilter(view.getId());
        }
    }

    private void handleFilter(int id) {

        RelativeLayout linear_main = findViewById(R.id.linear_main);

        ImageView button_quote = findViewById(R.id.image_quotes);
        button_quote.setColorFilter(ContextCompat.getColor(this, R.color.white));
        ImageView button_happy = findViewById(R.id.image_happy);
        button_happy.setColorFilter(ContextCompat.getColor(this,R.color.white));
        ImageView button_code = findViewById(R.id.image_code);
        button_code.setColorFilter(ContextCompat.getColor(this,R.color.white));

        if (id == R.id.image_quotes) {
            button_quote.setColorFilter(ContextCompat.getColor(this, R.color.black));
            linear_main.setBackgroundColor(ContextCompat.getColor(this, R.color.background_one));

            category_Id = QuoteConstants.FILTER.COMPUTER;
            handleNextPhrase(category_Id);
        } else if (id == R.id.image_happy) {
            button_happy.setColorFilter(ContextCompat.getColor(this,R.color.black));
            linear_main.setBackgroundColor(ContextCompat.getColor(this, R.color.background_two));

            category_Id = QuoteConstants.FILTER.ANIME;
            handleNextPhrase(category_Id);
        } else if (id == R.id.image_code)  {
            button_code.setColorFilter(ContextCompat.getColor(this,R.color.black));
            linear_main.setBackgroundColor(ContextCompat.getColor(this, R.color.background_three));

            category_Id = QuoteConstants.FILTER.CODE;
            handleNextPhrase(category_Id);

        }
    }

    private void handleNextPhrase(int id) {
        if (id==QuoteConstants.FILTER.COMPUTER) {
            requirePhraseProgramming();
        }
        if (id==QuoteConstants.FILTER.ANIME) {
            requirePhraseAnime();
        }
        if (id==QuoteConstants.FILTER.CODE) {
            requirePhraseCode();
        }
    }

    private void requirePhraseCode() {
        Call<PhraseCode> call = new RetrofitInitializerCode().getCodeService().getPhrase();
        call.enqueue(new Callback<PhraseCode>() {
            @Override
            public void onResponse(@NotNull Call<PhraseCode> call, @NotNull Response<PhraseCode> response) {
                TextView phrase = findViewById(R.id.textView_phrase);
                if(response.body() != null) {
                    phrase.setText(response.body().toString());
                    phrase.setMovementMethod(new ScrollingMovementMethod());
                }
            }

            @Override
            public void onFailure(Call<PhraseCode> call, Throwable t) {
                Toast.makeText(MainActivity.this, "t.message", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void requirePhraseAnime() {
        Call<PhraseAnime> call = new RetrofitInitializerAnime().getAnimeService().getPhrase();
        call.enqueue(new Callback<PhraseAnime>() {
            @Override
            public void onResponse(@NotNull Call<PhraseAnime> call, @NotNull Response<PhraseAnime> response) {
                TextView phrase = findViewById(R.id.textView_phrase);
                if(response.body() != null) {
                    phrase.setText(response.body().toString());
                    phrase.setMovementMethod(new ScrollingMovementMethod());
                }
            }

            @Override
            public void onFailure(Call<PhraseAnime> call, Throwable t) {
                Toast.makeText(MainActivity.this, "t.message", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void requirePhraseProgramming() {
        Call<Phrase> call = new RetrofitInitializerProgramming().getProgService().getPhrase();
        call.enqueue(new Callback<Phrase>() {
            @Override
            public void onResponse(@NotNull Call<Phrase> call, @NotNull Response<Phrase> response) {
                TextView phrase = findViewById(R.id.textView_phrase);
                if(response.body() != null) {
                    phrase.setText(response.body().toString());
                    phrase.setMovementMethod(new ScrollingMovementMethod());
                }
            }

            @Override
            public void onFailure(Call<Phrase> call, Throwable t) {
                Toast.makeText(MainActivity.this, "t.message", Toast.LENGTH_SHORT).show();

            }
        });
    }


}