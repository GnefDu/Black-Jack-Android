package com.example.blackjack;

import java.util.*;

public class Game {
    //variables
    public ArrayList<Integer> deck;
    public ArrayList<Integer> player;
    public ArrayList<Integer> dealer;
    //constructor
    public Game(){
        this.deck = new ArrayList<Integer>();
        this.player = new ArrayList<Integer>();
        this.dealer = new ArrayList<Integer>();
    }
    //create deck 0-51
    public void createDeck(){
        int[] arr = new int[52];
        for(int i = 0; i < 52; i++){
            this.deck.add(i);
        }
    }
    //shuffle deck
    public void shuffle(){
        Random rand = new Random();
        for (int i = 0; i < this.deck.size(); i++) {
            int randPos = rand.nextInt(this.deck.size());
            int temp = this.deck.get(i);
            this.deck.set(i,this.deck.get(randPos));
            this.deck.set(randPos, temp);
        }
    }
    //deals a card to the player from the deck
    public void dealPlayer(){
        Random rand = new Random();
        int randPos = rand.nextInt(this.deck.size());
        this.player.add(this.deck.get(randPos));
        this.deck.remove(randPos);
    }
    //deals a card to the dealer from the deck
    public void dealDealer(){
        Random rand = new Random();
        int randPos = rand.nextInt(this.deck.size());
        this.dealer.add(this.deck.get(randPos));
        this.deck.remove(randPos);
    }


    //Getters
    public ArrayList<Integer> getDeck(){
        return deck;
    }

    public ArrayList<Integer> getDealer(){
        return dealer;
    }

    public ArrayList<Integer> getPlayer(){
        return player;
    }


}
