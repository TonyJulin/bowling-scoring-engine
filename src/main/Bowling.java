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
        System.out.println("Total Score: " + score);
    }

    private void printInstructions() {
        System.out.println("***Instructions***");
    }

    public int play() {
        List<Frame> frames = new ArrayList<>();
        int frameNumber = 0;
        String input = "";

        Scanner scanner = new Scanner(System.in);
        while (frameNumber < 10) {
            Frame frame = new Frame();
            System.out.println("\nFrame: " + (frameNumber + 1));

            if(frameNumber == 9) {
                System.out.println("First roll score: ");
                input = scanner.next();
                if (input.equals(QUIT)) {
                    break;
                } else {
                    frame = calculateTenthFrameRoll(input, frame);
                    frames.add(frame);
                    break;
                }
            }


            frame = calculateFirstRoll(input, frame);
            if (!frame.getStrike()) {
                System.out.println("Second roll score: ");
                input = scanner.next();
                if (input.equals(QUIT)) {
                    break;
                } else {
                    frame = calculateSecondRoll(input, frame);
                }
            }
            frames.add(frame);
            frameNumber++;
        }

        int totalScore = calculateTotalScore(frames);
        return totalScore;
    }

    private Frame calculateTenthFrameRoll(String input, Frame frame) {
        
    }

    public Frame calculateFirstRoll(String input, Frame frame) {
        if (input.equals(STRIKE_UPPER) || input.equals(STRIKE_LOWER)) {
            frame.setStrike(true);
        } else if (input.equals(SPARE)) {
            System.out.println("Cannot get a spare on the first roll of a frame. Score for this roll will be set to 0.");
            frame.setFirstScore(0);
        } else if (input.matches("[0-9]")) {
            frame.setFirstScore(Integer.parseInt(input));
        } else {
            System.out.println("Invalid input: " + input + " - Score for the first roll will be set to 0.");
            frame.setFirstScore(0);
        }

        return frame;
    }

    public Frame calculateSecondRoll(String input, Frame frame) {
        if (input.equals(STRIKE_UPPER) || input.equals(STRIKE_LOWER)) {
            System.out.println("Cannot score a strike on the second roll.");
        } else if (input.equals(SPARE)) {
            frame.setSpare(true);
        } else if (input.matches("[0-9]")) {
            int parsedInput = Integer.parseInt(input);
            if(frame.getFirstScore() + parsedInput > 10) {
                System.out.println("Second roll and first roll cannot add up to more than 10. Second roll score will be 0.");
            } else {
                frame.setSecondScore(parsedInput);
            }
        } else {
            System.out.println("Invalid input for the second roll: " + input);
        }

        return frame;
    }

    public int calculateTotalScore(List<Frame> frames) {
        int totalScore = 0;
        for (int i = 0; i < frames.size(); i++) {
            if (i < 9) {
                totalScore += calculateFrameScore(frames, i);
            } else {

            }
        }
        return totalScore;
    }

    public int calculateFrameScore(List<Frame> frames, int currentIndex) {
        Frame currentFrame = frames.get(currentIndex);
        if (currentFrame.getSpare()) {
            if (currentIndex + 1 > frames.size() - 1) {
                return 10;
            } else {
                Frame nextFrame = frames.get(currentIndex + 1);
                return 10 + calculateSpare(nextFrame);
            }
        } else if (currentFrame.getStrike()) {
            if (currentIndex + 1 > frames.size() - 1) {
                return 10;
            } else {
                return 10 + calculateStrikeScore(frames, currentIndex + 1);
            }
        }
        return currentFrame.getFirstScore() + currentFrame.getSecondScore();
    }

    private int calculateStrikeScore(List<Frame> frames, int nextIndex) {
        Frame nextFrame = frames.get(nextIndex);
        if (nextFrame.getSpare()) {
            return 10;
        } else if (nextFrame.getStrike()) {
            int nextNextIndex = nextIndex + 1;
            if (nextNextIndex > frames.size() - 1) {
                return 10;
            } else {
                Frame nextNextFrame = frames.get(nextNextIndex);
                if (nextNextFrame.getStrike()) {
                    return 20;
                } else {
                    return 10 + nextNextFrame.getFirstScore();
                }
            }
        } else {
            return nextFrame.getFirstScore() + nextFrame.getSecondScore();
        }
    }

    private int calculateSpare(Frame frame) {
        if (frame.getStrike()) {
            return 10;
        } else {
            return frame.getFirstScore();
        }
    }
}
