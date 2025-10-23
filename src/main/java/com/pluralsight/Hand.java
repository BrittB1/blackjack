package com.pluralsight;

import java.util.ArrayList;


    public class Hand {

        private final String playerName;
        private ArrayList<Card> cards;

        public Hand(String playerName){
            this.playerName = playerName;
            cards = new ArrayList<>();
        }

        public String getPlayerName() {
            return playerName;
        }

        // A Card is dealt to the Hand and the Hand is responsible
// to store the card
        public void deal(Card card){
            cards.add(card);
        }
        public int getSize(){
            return cards.size();
        }
        // The Hand uses the methods of each card to determine
// the value of each card - and adds up all values
        public int getValue(){
            int value = 0;
            for(Card card: cards){
                card.flip(); // turn the card over to see the value
                value += card.getPointValue();
                card.flip(); // hide the card again
            }
            return value;
        }

        public void displayHand() {
            for (Card card : cards) {
                if (!card.isFaceUp()) {
                    card.flip();
                    System.out.println(card.getSuit() + " " + card.getValue());
                }
            }
        }
    }

