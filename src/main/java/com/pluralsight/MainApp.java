package com.pluralsight;

import java.util.Scanner;

public class MainApp {
    public static final Scanner keyboard = new Scanner(System.in); // dot notation; how we access things

    public static void main(String[] args) {

        homeScreen();
        System.out.println("Enter player 1's name: ");
        String player1Name = keyboard.nextLine();

        System.out.println("Enter player 2's name: ");
        String player2Name = keyboard.nextLine();

        Deck deck = new Deck();
        Hand player1Hand = new Hand(player1Name);
        Hand player2Hand = new Hand(player2Name);

        deck.shuffle(); // shuffle deck

        for (int i = 0; i < 2; i++) {
            player1Hand.deal(deck.deal());
            player2Hand.deal(deck.deal());
        }
        player1Hand.displayHand();
        System.out.println();
        player2Hand.displayHand();

        determineWinner(player1Name, player1Hand.getValue(), player2Name, player2Hand.getValue());
    }

    public static void determineWinner(String player1, int score1, String player2, int score2) {
        if (score1 > 21 && score2 > 21) {
            System.out.println("Both players busted! No winner.."); // guard clause/early return: check special cases FIRST. return immediately
            return;
        }
        if (score1 > 21) {
            System.out.println(player2 + " wins!");
            return;
        }
        if (score2 > 21) {
            System.out.println(player1 + " wins!");
            return;
        }
        if (score1 > score2) {
            System.out.println("Player " + player1 + " wins with" + score1 + "!");
        } else if (score2 > score1) {
            System.out.println("Player " + player2 + " wins with" + score2 + "!");
        } else {
            System.out.println("Its a tie at " + score1 + "!");
        }
    }

    private static void homeScreen() {
        System.out.println("Welcome to BlackJack");
    }

}
