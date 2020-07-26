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

        text_display = (TextView) findViewById(R.id.display);

        text_player = (TextView) findViewById(R.id.player);

        text_dealer = (TextView) findViewById(R.id.dealer);


        // ImageViews

        player0 = (ImageView) findViewById(R.id.player0);

        player1 = (ImageView) findViewById(R.id.player1);

        player2 = (ImageView) findViewById(R.id.player2);

        player3 = (ImageView) findViewById(R.id.player3);

        player4 = (ImageView) findViewById(R.id.player4);

        player5 = (ImageView) findViewById(R.id.player5);

        player6 = (ImageView) findViewById(R.id.player6);

        player7 = (ImageView) findViewById(R.id.player7);

        player8 = (ImageView) findViewById(R.id.player8);

        player9 = (ImageView) findViewById(R.id.player9);

        dealer0 = (ImageView) findViewById(R.id.dealer0);

        dealer1 = (ImageView) findViewById(R.id.dealer1);

        dealer2 = (ImageView) findViewById(R.id.dealer2);

        dealer3 = (ImageView) findViewById(R.id.dealer3);

        dealer4 = (ImageView) findViewById(R.id.dealer4);

        dealer5 = (ImageView) findViewById(R.id.dealer5);

        dealer6 = (ImageView) findViewById(R.id.dealer6);

        dealer7 = (ImageView) findViewById(R.id.dealer7);

        dealer8 = (ImageView) findViewById(R.id.dealer8);

        dealer9 = (ImageView) findViewById(R.id.dealer9);

        //OnClickListener
        button_hit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                player0.setImageResource(R.drawable.ad);
            }
        });

        button_stand.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                player0.setImageResource(R.drawable.ah);
            }
        });

        button_reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                player0.setImageResource(R.drawable.as);
            }
        });

        }


    }
