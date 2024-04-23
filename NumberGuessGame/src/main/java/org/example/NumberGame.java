package org.example;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        NumberGame numberGame = new NumberGame();
        Scanner scanner = new Scanner(System.in);
        String play = "yes";

        while(play.equals("yes"))
        {
            Random rand = new Random();
            int randNum = rand.nextInt(100);
            int guess = -1;
            int tries = 0;

            play = numberGame.playNumberGame(guess, randNum, scanner, tries, play);

        }
        scanner.close();
    }

    public String playNumberGame(int guess, int randNum, Scanner scanner, int tries, String play) {
        while(guess != randNum)
        {
            System.out.println("Guess a number between 1 and 100:");
            guess = scanner.nextInt();
            tries++;

            if(guess == randNum)
            {
                System.out.println("Awesome! You guessed the number!");
                System.out.println("It only took you" + tries + "guesses!");
                System.out.println("Would you like to play again? Yes or No:");
                play = scanner. next().toLowerCase();
            }
            else if(guess > randNum)
            {
                System.out.println("Your guess is too high, try again");
            }
            else
            {
                System.out.println("Your guess is too low, try again");
            }

        }
        return play;
    }
}