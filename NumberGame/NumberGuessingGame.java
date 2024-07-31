package codsoft;

import java.util.*;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int roundsPlayed = 0;
        int totalScore = 0;

        while (playAgain) {
            totalScore += playGame(scanner);
            roundsPlayed++;
            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! You played " + roundsPlayed + " rounds and scored " + totalScore + " points.");
        scanner.close();
    }

    private static int playGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Guess a number between " + MIN_RANGE + " and " + MAX_RANGE);

        while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low!");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                hasGuessedCorrectly = true;
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
        }

        return hasGuessedCorrectly ? MAX_ATTEMPTS - attempts + 1 : 0;
    }
}

