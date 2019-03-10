package main;

public class Frame {
    private int frameScore = 0;
    private String firstShot;
    private String secondShot;
    private Frame previousFrame;
    private Frame nextFrame;

    public int getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(int score) {
        frameScore = score;
    }

    public String getFirstShot() {
        return firstShot;
    }

    public void setFirstShot(String firstShot) {
        this.firstShot = firstShot;
    }

    public String getSecondShot() {
        return secondShot;
    }

    public void setSecondShot(String secondShot) {
        this.secondShot = secondShot;
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
}
