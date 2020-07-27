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
    // Resets the hands
    public void shuffle(){
        Random rand = new Random();
        for (int i = 0; i < this.deck.size(); i++) {
            int randPos = rand.nextInt(this.deck.size());
            int temp = this.deck.get(i);
            this.deck.set(i, this.deck.get(randPos));
            this.deck.set(randPos, temp);
        }
        this.player = new ArrayList<Integer>();
        this.dealer = new ArrayList<Integer>();
        this.playerBust = false;
        this.dealerBust = false;
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
    // count the value of player hand
    public int countPlayer(){

        int ace = 0;
        int count = 0;
        //check for aces in hand
        for (int i = 0; i < this.getPlayer().size(); i++){
            if(this.getPlayer().get(i) < 4){
                ace += 1;
            }
        }
        // no ace
        if(ace == 0){
            for (int i = 0; i < this.getPlayer().size(); i++){
                if(this.getPlayer().get(i) > 38){
                    count += 10;
                }
                else{
                    count += (this.getPlayer().get(i) / 4) + 1;
                }
            }
        }
        // ace in hand
        else{
            //counts ace as 11
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
        // if greater than 21 check loops down over number of aces until less than 21 or no aces left
        while(ace > 0){
            ace--;
            if(count > 21){
                int countAce = 0;
                count = 0;
                for (int i = 0; i < this.getPlayer().size(); i++){
                    if(this.getPlayer().get(i) < 4 & countAce < ace){
                        count += 11;
                        countAce++;
                    }
                    else if(this.getPlayer().get(i) > 38){
                        count += 10;
                    }
                    else{
                        count += (this.getPlayer().get(i) / 4) + 1;
                    }
                }
            }
        }
        return count;
    }

    public int countDealer(){

        int ace = 0;
        int count = 0;
        // counts aces
        for (int i = 0; i < this.getDealer().size(); i++){
            if(this.getDealer().get(i) < 4){
                ace += 1;
            }
        }
        // no ace in hand
        if(ace == 0){
            for (int i = 0; i < this.getDealer().size(); i++){
                if(this.getDealer().get(i) > 38){
                    count += 10;
                }
                else{
                    count += (this.getDealer().get(i) / 4) + 1;
                }
            }
        }
        // ace in hand
        else{
            //counts ace as 11
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
        // if greater than 21 check loops down over number of aces until less than 21 or no aces left
        while(ace > 0){
            ace--;
            if(count > 21){
                int countAce = 0;
                count = 0;
                for (int i = 0; i < this.getDealer().size(); i++){
                    if(this.getDealer().get(i) < 4 & countAce < ace){
                        count += 11;
                        countAce++;
                    }
                    else if(this.getDealer().get(i) > 38){
                        count += 10;
                    }
                    else{
                        count += (this.getDealer().get(i) / 4) + 1;
                    }
                }
            }
        }
        return count;
    }

    // returns true if player has busted
    public boolean playerBust(){
        int count = countPlayer();
        if(count > 21){
            playerBust = true;
        }
        return playerBust;
    }

    //return true is player has busted
    public boolean dealerBust(){
        int count = countDealer();
        if(count > 21){
            dealerBust = true;
        }
        return dealerBust;
    }
    //Same method as count dealer except is iterates from 1 so that the first card is hidden
    public int countDealerHidden(){

        int ace = 0;
        int count = 0;
        // no ace in hand
        for (int i = 1; i < this.getDealer().size(); i++){
            if(this.getDealer().get(i) < 4){
                ace += 1;
            }
        }
        if(ace == 0){
            for (int i = 1; i < this.getDealer().size(); i++){
                if(this.getDealer().get(i) > 38){
                    count += 10;
                }
                else{
                    count += (this.getDealer().get(i) / 4) + 1;
                }
            }
        }
        // ace in hand
        else{
            //counts ace as 11
            for (int i = 1; i < this.getDealer().size(); i++){
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
        // if greater than 21 check i
        while(ace > 0){
            ace--;
            if(count > 21){
                int countAce = 0;
                count = 0;
                for (int i = 1; i < this.getDealer().size(); i++){
                    if(this.getDealer().get(i) < 4 & countAce < ace){
                        count += 11;
                        countAce++;
                    }
                    else if(this.getDealer().get(i) > 38){
                        count += 10;
                    }
                    else{
                        count += (this.getDealer().get(i) / 4) + 1;
                    }
                }
            }
        }
        return count;
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
