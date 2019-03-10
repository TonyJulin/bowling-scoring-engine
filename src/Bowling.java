import java.util.Scanner;

public class Bowling {
    private static final String STRIKE_UPPER = "X";
    private static final String STRIKE_LOWER = "x";
    private static final String SPARE = "/";
    private static final String QUIT = "q";

    public static void main(String[] args) {
        int frameNumber = 0;
        int score = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("***Instructions***");


        String input = scanner.next();
        while (frameNumber < 10 && !input.equals("q")) {
            System.out.println("Input: " + input);

            input = scanner.next();
            frameNumber++;
        }

        System.out.println("score: " + score);
    }
}
