import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class guessingGameAI {
    public static void main(String[] args) {
        computerGuess(1, 100);

    }
    public static void computerGuess(int guessFloor, int guessCeiling){
        int guess = ThreadLocalRandom.current().nextInt(guessFloor, guessCeiling + 1);
        System.out.print("I guessed " + guess + ". Is it higher or lower? ");
        Scanner myScanner = new Scanner(System.in);
        String userResponse = myScanner.next();
        if(userResponse.equals("higher")){
            computerGuess(guess, guessCeiling);
        }
        if(userResponse.equals("lower")){
            computerGuess(guessFloor, guess);

        }
        if(userResponse.equals("correct")){
            System.out.println("I won!!!!");
        }
    }


}
