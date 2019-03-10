package main;

public class Frame {
    private int firstScore = 0;
    private int secondScore = 0;

    private Boolean isSpare = false;
    private Boolean isStrike = false;

    private int frameScore = 0;

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

    public int getFirstScore() {
        return firstScore;
    }

    public void setFirstScore(int firstScore) {
        this.firstScore = firstScore;
    }

    public int getSecondScore() {
        return secondScore;
    }

    public void setSecondScore(int secondScore) {
        this.secondScore = secondScore;
    }

    public int getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(int frameScore) {
        this.frameScore = frameScore;
    }
}
