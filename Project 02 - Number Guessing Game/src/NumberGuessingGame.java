import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    // constants used in the game
    static final int MAX_NUMBER = 100;
    static final int EASY_ATTEMPTS = 10;
    static final int MEDIUM_ATTEMPTS = 7;
    static final int HARD_ATTEMPTS = 5;

    // method to choose difficulty and return max attempts
    static int chooseDifficulty(Scanner sc) {
        System.out.println("\nChoose Difficulty Level");
        System.out.println("1. Easy (10 attempts)");
        System.out.println("2. Medium (7 attempts)");
        System.out.println("3. Hard (5 attempts)");
        System.out.print("Enter your choice : ");

        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number : ");
            sc.next();
        }

        int choice = sc.nextInt();

        if (choice == 1)
            return EASY_ATTEMPTS;
        if (choice == 2)
            return MEDIUM_ATTEMPTS;
        if (choice == 3)
            return HARD_ATTEMPTS;

        System.out.println("Invalid choice. Defaulting to Medium difficulty.");
        return MEDIUM_ATTEMPTS;
    }

    // method to safely read a guess from user
    static int getValidGuess(Scanner sc) {
        while (true) {
            System.out.print("Enter your guess : ");
            // check if input is a number
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.next();
                continue;
            }

            int guess = sc.nextInt();

            // check if guess is within range
            if (guess < 1 || guess > MAX_NUMBER) {
                System.out.println("Enter a number between 1 and " + MAX_NUMBER);
                continue;
            }
            return guess;
        }
    }

    // method to calculate score based on attempts
    static int calculateScore(int attempts) {
        int score = 100 - (attempts - 1) * 10;
        if (score < 0)
            score = 0;
        return score;
    }

    // method that runs one round of the game
    static void playGame(Scanner sc) {
        Random random = new Random();
        int maxAttempts = chooseDifficulty(sc);
        int secretNumber = random.nextInt(MAX_NUMBER) + 1;
        int attempts = 0;
        System.out.println("\nGuess the number between 1 and " + MAX_NUMBER);
        while (attempts < maxAttempts) {
            int guess = getValidGuess(sc);
            attempts++;
            if (guess == secretNumber) {
                int score = calculateScore(attempts);
                System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                System.out.println("Your score: " + score);
                return;
            }

            if (guess < secretNumber) {
                System.out.println("Too low.");
            } else {
                System.out.println("Too high.");
            }
            System.out.println("Attempts left : " + (maxAttempts - attempts));
        }
        System.out.println("\nYou ran out of attempts.");
        System.out.println("The correct number was : " + secretNumber);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char playAgain;
        System.out.println("     Number Guessing Game     ");
        do {
            playGame(sc);
            System.out.print("\nDo you want to play again? (y/n) : ");
            playAgain = sc.next().charAt(0);
        } while (playAgain == 'y' || playAgain == 'Y');
        System.out.println("Thanks for playing!");
        sc.close();
    }
}