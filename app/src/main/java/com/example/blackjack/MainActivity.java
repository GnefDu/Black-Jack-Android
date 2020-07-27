/*
Author: Feng Du
*/

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
    // Create new instance of Game
    Game game = new Game();

    // Global variables

    int playerCard = 2;

    boolean start = false;

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

        text_display.setText("Dealer hits until 17 or greater");

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



        //OnClickListeners for each button

        // Hit results in player drawing a card
        // If player busts the player is notified
        button_hit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if(!start){
                    text_display.setText("Press the deal button before hitting");
                    return;
                }

                game.dealPlayer();
                getImagePlayer(playerCard).setImageResource(getId(game.getPlayer().get(playerCard)));
                player_count.setText(Integer.toString(game.countPlayer()));
                playerCard++;
                if(game.countPlayer() > 21){
                    text_display.setText("Player bust, Dealer wins");
                    dealer0.setImageResource(getId(game.getDealer().get(0)));

                }
            }
        });

        // Stand allows dealer to draw until greater than 17 or bust
        // Hands are then compared and winner is announced
        button_stand.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if(!start){
                    text_display.setText("Press the deal button before standing");
                    return;
                }
                int card = 2;
                while (game.countDealer() < 17) {
                    game.dealDealer();
                    getImageDealer(card).setImageResource(getId(game.getDealer().get(card)));
                    card++;
                }
                dealer_count.setText(Integer.toString(game.countDealer()));
                dealer0.setImageResource(getId(game.getDealer().get(0)));

                if(game.countDealer() > 21){
                    text_display.setText("Dealer bust, Player wins");
                }
                else if(game.countPlayer() > game.countDealer()){
                    text_display.setText("Player wins");
                }
                else if(game.countPlayer() == game.countDealer()){
                    text_display.setText("Tie");
                }
                else{
                    text_display.setText("Dealer wins");
                }
            }
        });

        // Reset the 52 card deck
        // Resets all images to blank
        // Deals 2 cards to the dealer
        // Deals 2 cards to the player
        button_reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                start = true;

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

                text_display.setText("");

                playerCard = 2;

                game.createDeck();

                game.shuffle();

                game.dealDealer();

                dealer0.setImageResource(R.drawable.blue_back);

                game.dealPlayer();

                int card = game.getPlayer().get(0);

                player0.setImageResource(getId(card));

                game.dealDealer();

                card = game.getDealer().get(1);

                dealer1.setImageResource(getId(card));

                game.dealPlayer();

                card = game.getPlayer().get(1);

                player1.setImageResource(getId(card));

                dealer_count.setText(Integer.toString(game.countDealerHidden()));

                player_count.setText(Integer.toString(game.countPlayer()));

            }
        });

        //create and shuffle 52 card deck
        game.createDeck();
        game.shuffle();

        }
        //Get the Id of drawable cards
        public int getId(int i){
            switch(i){
                case 0:
                    return R.drawable.c0;
                case 1:
                    return R.drawable.c1;
                case 2:
                    return R.drawable.c2;
                case 3:
                    return R.drawable.c3;
                case 4:
                    return R.drawable.c4;
                case 5:
                    return R.drawable.c5;
                case 6:
                    return R.drawable.c6;
                case 7:
                    return R.drawable.c7;
                case 8:
                    return R.drawable.c8;
                case 9:
                    return R.drawable.c9;
                case 10:
                    return R.drawable.c10;
                case 11:
                    return R.drawable.c11;
                case 12:
                    return R.drawable.c12;
                case 13:
                    return R.drawable.c13;
                case 14:
                    return R.drawable.c14;
                case 15:
                    return R.drawable.c15;
                case 16:
                    return R.drawable.c16;
                case 17:
                    return R.drawable.c17;
                case 18:
                    return R.drawable.c18;
                case 19:
                    return R.drawable.c19;
                case 20:
                    return R.drawable.c20;
                case 21:
                    return R.drawable.c21;
                case 22:
                    return R.drawable.c22;
                case 23:
                    return R.drawable.c23;
                case 24:
                    return R.drawable.c24;
                case 25:
                    return R.drawable.c25;
                case 26:
                    return R.drawable.c26;
                case 27:
                    return R.drawable.c27;
                case 28:
                    return R.drawable.c28;
                case 29:
                    return R.drawable.c29;
                case 30:
                    return R.drawable.c30;
                case 31:
                    return R.drawable.c31;
                case 32:
                    return R.drawable.c32;
                case 33:
                    return R.drawable.c33;
                case 34:
                    return R.drawable.c34;
                case 35:
                    return R.drawable.c35;
                case 36:
                    return R.drawable.c36;
                case 37:
                    return R.drawable.c37;
                case 38:
                    return R.drawable.c38;
                case 39:
                    return R.drawable.c39;
                case 40:
                    return R.drawable.c40;
                case 41:
                    return R.drawable.c41;
                case 42:
                    return R.drawable.c42;
                case 43:
                    return R.drawable.c43;
                case 44:
                    return R.drawable.c44;
                case 45:
                    return R.drawable.c45;
                case 46:
                    return R.drawable.c46;
                case 47:
                    return R.drawable.c47;
                case 48:
                    return R.drawable.c48;
                case 49:
                    return R.drawable.c49;
                case 50:
                    return R.drawable.c50;
                case 51:
                    return R.drawable.c51;


            }
            return -1;
        }
        //Gets the ImageViews for dealer
        public ImageView getImageDealer(int i){
            switch(i){
                case 2:
                    return dealer2;
                case 3:
                    return dealer3;
                case 4:
                    return dealer4;
                case 5:
                    return dealer5;
                case 6:
                    return dealer6;
                case 7:
                    return dealer7;
                case 8:
                    return dealer8;
                case 9:
                    return dealer9;
            }
            return dealer1;
        }
        //Gets the image views for player
        public ImageView getImagePlayer(int i){
            switch(i){
                case 2:
                    return player2;
                case 3:
                    return player3;
                case 4:
                    return player4;
                case 5:
                    return player5;
                case 6:
                    return player6;
                case 7:
                    return player7;
                case 8:
                    return player8;
                case 9:
                    return player9;
            }
            return player1;
    }






    }
