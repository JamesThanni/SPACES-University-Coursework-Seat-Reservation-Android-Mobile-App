package com.example.spaces;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SpacesAccount extends AppCompatActivity {

    ImageButton homeBtn;
    ImageButton infoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spaces_account);

        ImageButton homeBtn = findViewById(R.id.homeBtn);
        ImageButton infoBtn = findViewById(R.id.infoBtn);

        infoBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent userGuide = new Intent(SpacesAccount.this, SpacesGuide.class);
                startActivity(userGuide);
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent userAccount = new Intent(SpacesAccount.this, MainActivity.class);
                startActivity(userAccount);
            }
        });
    }
}