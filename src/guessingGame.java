import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class guessingGame {
    // These vars are global because we need it to replay the game at the same level.
    public static void main(String[] args) {
        int correctAnswer = generateNumber();
        playGame(correctAnswer);
    }

    private static boolean choiceChecker(int levelChoice) {
        boolean valid;
        if((levelChoice < 1) || (levelChoice > 4)) {
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }

    private static int generateNumber() {
        return ThreadLocalRandom.current().nextInt(1, 100 + 1);
    }

    private static void playGame(int actualAnswer) {
        int tries = 0;
        Scanner game = new Scanner(System.in);
        boolean winner = false;
        while (winner == false) {
            System.out.print("Enter your guess: ");
            int userGuess = game.nextInt();
            String guessResponse = checkGuess(userGuess, actualAnswer);
            System.out.println(guessResponse);
            tries++;
            if (guessResponse.equals("You got the answer!")) {
                System.out.println("You won!");
                break;
            }
        }
    }

    private static String checkGuess(int guess, int actualAnswer) {
        String guessResponse = "";
        if (guess < actualAnswer) {
            guessResponse = "The answer is higher than your guess";
        } else if (actualAnswer < guess) {
            guessResponse = "The answer is lower than your guess";
        } else if (actualAnswer == guess) {
            guessResponse = "You got the answer!";
        }
        return guessResponse;
    }
}
