package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bowling {
    private static final String STRIKE_UPPER = "X";
    private static final String STRIKE_LOWER = "x";
    private static final String SPARE = "/";
    private static final String QUIT = "q";

    public static void main(String[] args) {
        Bowling bowling = new Bowling();
        bowling.printInstructions();

        int score = bowling.play();
        System.out.println("calculateScore: " + score);
    }

    private void printInstructions() {
        System.out.println("***Instructions***");
    }

    public int play() {
        List<Frame> frames = new ArrayList<>();
        int frameNumber = 0;
        int totalScore = 0;

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        while (frameNumber < 10 && !input.equals(QUIT)) {
            Frame frame = new Frame();
            frame.setFrameScore(calculateScore(input));

            input = scanner.next();
            frameNumber++;
        }


        return totalScore;
    }

    public int calculateScore(String input) {
        int score = 0;
        if (input.equals(STRIKE_UPPER) || input.equals(STRIKE_LOWER)) {
            score = 3;
        } else if (input.equals(SPARE)) {
            score = 2;
        } else if (input.matches("[0-9]")) {
            score = 1;
        } else {
            System.out.println("Invalid input. Frame will not be scored.");
        }

        return score;
    }
}
