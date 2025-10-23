package com.pluralsight;

import java.util.Scanner;

public class MainApp {
    public  static  final Scanner keyboard = new Scanner(System.in); // dot notation; how we access things
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand player1Hand = new Hand();
        Hand player2Hand = new Hand();

        homeScreen();
        System.out.println("Enter player 1's name: ");
        String player1Name = keyboard.nextLine();

        System.out.println("Enter player 2's name: ");
        String player2Name = keyboard.nextLine();

        deck.shuffle(); // shuffle deck

// deal 5 cards
        for (int i = 0; i < 2; i++) {
// get a card from the deck
            Card card = deck.deal();
// deal that card to the hand
            player1Hand.deal(deck.deal());
            player2Hand.deal(deck.deal());
        }

        System.out.println(player1Name + " hand is worth " + player1Hand.getValue());
        System.out.println(player2Name + " hand is worth " + player2Hand.getValue());
    }
    public static  void homeScreen(){
        System.out.println("Welcome to BlackJack");

    }
}

