package com.example.blackjack;

import java.util.*;

public class Game {
    //variables
    public ArrayList<Integer> deck;
    public ArrayList<Integer> player;
    public ArrayList<Integer> dealer;
    public boolean playerBust;
    public boolean dealerBust;

    //constructor
    public Game(){
        this.deck = new ArrayList<Integer>();
        this.player = new ArrayList<Integer>();
        this.dealer = new ArrayList<Integer>();
        this.playerBust = false;
        this.dealerBust = false;
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
            this.deck.set(i, this.deck.get(randPos));
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

    public int countPlayer(){

        boolean ace = false;
        int count = 0;

        for (int i = 0; i < this.getPlayer().size(); i++){
            if(this.getPlayer().get(i) < 4){
                ace = true;
            }
        }
        if(!ace){
            for (int i = 0; i < this.getPlayer().size(); i++){
                if(this.getPlayer().get(i) > 38){
                    count += 10;
                }
                else{
                    count += (this.getPlayer().get(i) / 4) + 1;
                }
            }
        }
        else{
            for (int i = 0; i < this.getPlayer().size(); i++){
                if(this.getPlayer().get(i) < 4){
                    count += 11;
                }
                else if(this.getPlayer().get(i) > 38){
                    count += 10;
                }
                else{
                    count += (this.getPlayer().get(i) / 4) + 1;
                }
            }
        }
        if(count > 21){
            count = 0;
            for (int i = 0; i < this.getPlayer().size(); i++){
                if(this.getPlayer().get(i) > 38){
                    count += 10;
                }
                else{
                    count += (this.getPlayer().get(i) / 4) + 1;
                }
            }
        }
        return count;
    }

    public int countDealer(){

        boolean ace = false;
        int count = 0;

        for (int i = 0; i < this.getDealer().size(); i++){
            if(this.getDealer().get(i) < 4){
                ace = true;
            }
        }
        if(!ace){
            for (int i = 0; i < this.getDealer().size(); i++){
                if(this.getDealer().get(i) > 38){
                    count += 10;
                }
                else{
                    count += (this.getDealer().get(i) / 4) + 1;
                }
            }
        }
        else{
            for (int i = 0; i < this.getDealer().size(); i++){
                if(this.getDealer().get(i) < 4){
                    count += 11;
                }
                else if(this.getDealer().get(i) > 38){
                    count += 10;
                }
                else{
                    count += (this.getDealer().get(i) / 4) + 1;
                }
            }
        }
        if(count > 21){
            count = 0;
            for (int i = 0; i < this.getDealer().size(); i++){
                if(this.getDealer().get(i) > 38){
                    count += 10;
                }
                else{
                    count += (this.getDealer().get(i) / 4) + 1;
                }
            }
        }
        return count;
    }

    public boolean playerBust(){
        int count = countPlayer();
        if(count > 21){
            playerBust = true;
        }
        return playerBust;
    }

    public boolean dealerBust(){
        int count = countDealer();
        if(count > 21){
            dealerBust = true;
        }
        return dealerBust;
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

    public boolean getPlayerBust(){
        return playerBust;
    }
    public boolean getDealerBust(){
        return dealerBust;
    }


}
