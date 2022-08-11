package com.yawlle.kittyquotesjava;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yawlle.kittyquotesjava.infra.QuoteConstants;
import com.yawlle.kittyquotesjava.infra.SecurityPreferences;

public class UserActivity extends AppCompatActivity {

    private EditText _nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }

        _nameInput = (EditText) findViewById(R.id.edit_user);

        Button button_save = findViewById(R.id.button_save);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveName();
            }
        });
    }

    private void saveName() {
        String nameInput = _nameInput.getText().toString();
        if (!nameInput.equals("")) {
            SecurityPreferences sharedPreferences = new SecurityPreferences(getSharedPreferences("NerdQuotes", Context.MODE_PRIVATE));
            sharedPreferences.saveNameString(QuoteConstants.KEY.USER_NAME, nameInput);
            Intent it = new Intent(this, MainActivity.class);
            startActivity(it);
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show();
        }


    }

}