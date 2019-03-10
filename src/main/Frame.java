package main;

public class Frame {
    private int frameScore = 0;

    private Boolean isSpare = false;
    private Boolean isStrike = false;

    private Frame previousFrame;
    private Frame nextFrame;

    public int getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(int score) {
        frameScore = score;
    }


    public Frame getPreviousFrame() {
        return previousFrame;
    }

    public void setPreviousFrame(Frame previousFrame) {
        this.previousFrame = previousFrame;
    }

    public Frame getNextFrame() {
        return nextFrame;
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public Boolean getSpare() {
        return isSpare;
    }

    public void setSpare(Boolean spare) {
        isSpare = spare;
    }

    public Boolean getStrike() {
        return isStrike;
    }

    public void setStrike(Boolean strike) {
        isStrike = strike;
    }
}
