import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 0;
        int maxAttempts = 5;
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have chosen a number between " + minRange + " and " + maxRange + ". Guess which one it is.");

        while (numberOfAttempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfAttempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number correctly in " + numberOfAttempts + " attempts.");
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (numberOfAttempts == maxAttempts) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The number was " + randomNumber + ".");
        }

        scanner.close();
    }
}r
