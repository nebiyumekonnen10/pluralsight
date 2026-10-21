import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the game score: ");
        String input = scanner.nextLine();

        HighScoreParser parser = new HighScoreParser(input);

        parser.displayWinner();

        scanner.close();
    }
}