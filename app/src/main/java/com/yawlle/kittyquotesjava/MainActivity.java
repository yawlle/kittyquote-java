package com.yawlle.kittyquotesjava;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yawlle.kittyquotesjava.infra.QuoteConstants;
import com.yawlle.kittyquotesjava.infra.SecurityPreferences;

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
            handleNextPhrase(view.getId());
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
    }

    private void requirePhraseProgramming() {
    }


}