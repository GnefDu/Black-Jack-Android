package com.example.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.TextView;

import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //Declare buttons
    Button button_hit, button_stand, button_reset;

    //Declare TextViews
    TextView text_display, text_player, text_dealer;

    //Declare ImageViews
    ImageView player0, player1, player2, player3, player4, player5, player6, player7, player8, player9;

    ImageView dealer0, dealer1, dealer2, dealer3, dealer4, dealer5, dealer6, dealer7, dealer8, dealer9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons

        button_hit = (Button) findViewById(R.id.button_hit);

        button_stand = (Button) findViewById(R.id.button_stand);

        button_reset = (Button) findViewById(R.id.button_reset);

        //Text Views




    }
}