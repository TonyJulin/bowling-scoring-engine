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
        System.out.println("calculateFirstRoll: " + score);
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
            frame = calculateFirstRoll(input, frame);
            frame =  calculateSecondRoll(input, frame);

            input = scanner.next();
            frameNumber++;
        }


        return totalScore;
    }

    public Frame calculateFirstRoll(String input, Frame frame) {
        if (input.equals(STRIKE_UPPER) || input.equals(STRIKE_LOWER)) {
            frame.setStrike(true);
        } else if (input.equals(SPARE)) {
            System.out.println("Cannot get a spare on the first roll. Score for this roll will be set to 0.");
            frame.setFrameScore(0);
        } else if (input.matches("[0-9]")) {
            frame.setFrameScore(Integer.parseInt(input));
        } else {
            System.out.println("Invalid input. Score for the first roll will be set to 0.");
            frame.setFrameScore(0);
        }

        return frame;
    }

    private Frame calculateSecondRoll(String input, Frame frame) {
        return frame;
    }
}
