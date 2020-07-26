package com.example.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.TextView;

import android.widget.ImageView;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    //Declare buttons
    Button button_hit, button_stand, button_reset;

    //Declare TextViews
    TextView text_display, text_player, text_dealer, dealer_count, player_count;

    //Declare ImageViews
    ImageView player0, player1, player2, player3, player4, player5, player6, player7, player8, player9;

    ImageView dealer0, dealer1, dealer2, dealer3, dealer4, dealer5, dealer6, dealer7, dealer8, dealer9;

    int[] deck = new int[52];
    int[] player = new int[10];
    int[] dealer = new int[10];

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

        player_count = (TextView) findViewById(R.id.player_count);

        dealer_count = (TextView) findViewById(R.id.dealer_count);

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
                player0.setImageResource(R.drawable.c1);
            }
        });

        button_stand.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                player0.setImageResource(R.drawable.c0);
            }
        });

        // Reset the 52 card deck
        // Resets all images to blank
        // Deals 2 cards to the dealer
        // Deals 2 cards to the player
        button_reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                player0.setImageResource(R.drawable.blank);

                player1.setImageResource(R.drawable.blank);

                player2.setImageResource(R.drawable.blank);

                player3.setImageResource(R.drawable.blank);

                player4.setImageResource(R.drawable.blank);

                player5.setImageResource(R.drawable.blank);

                player6.setImageResource(R.drawable.blank);

                player7.setImageResource(R.drawable.blank);

                player8.setImageResource(R.drawable.blank);

                player9.setImageResource(R.drawable.blank);

                dealer0.setImageResource(R.drawable.blank);

                dealer1.setImageResource(R.drawable.blank);

                dealer2.setImageResource(R.drawable.blank);

                dealer3.setImageResource(R.drawable.blank);

                dealer4.setImageResource(R.drawable.blank);

                dealer5.setImageResource(R.drawable.blank);

                dealer6.setImageResource(R.drawable.blank);

                dealer7.setImageResource(R.drawable.blank);

                dealer8.setImageResource(R.drawable.blank);

                dealer9.setImageResource(R.drawable.blank);

                deck = shuffle(deck);

            }
        });

        //create and shuffle 52 card deck
        deck = createDeck();
        deck = shuffle(deck);

        }
        //Creates a new deck
        public static int[] createDeck(){
            int[] arr = new int[52];
            for(int i = 0; i < 52; i++){
                arr[i] = i;
            }
            return arr;
        }
        //Shuffles the deck
        public static int[] shuffle(int[] arr){
            Random rand = new Random();
            for (int i = 0; i < arr.length; i++) {
                int randPos = rand.nextInt(arr.length);
                int temp = arr[i];
                arr[i] = arr[randPos];
                arr[randPos] = temp;
            }
            return arr;
        }




    }
