package test;

import main.Bowling;
import main.Frame;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BowlingTest {


    @Test
    public void testScore() {
        Bowling bowling = new Bowling();

        int score = bowling.calculateScore("X");
        Assert.assertEquals(3, score);
        score = bowling.calculateScore("x");
        Assert.assertEquals(3, score);

        score = bowling.calculateScore("/");
        Assert.assertEquals(2, score);

        score = bowling.calculateScore("0");
        Assert.assertEquals(1, score);
        score = bowling.calculateScore("6");
        Assert.assertEquals(1, score);
        score = bowling.calculateScore("9");
        Assert.assertEquals(1, score);

        score = bowling.calculateScore("abf");
        Assert.assertEquals(0, score);
    }

    @Test
    public void testFrame() {
        Frame frame = new Frame();
        frame.setFrameScore(10);
        frame.setFirstShot("9");
        frame.setSecondShot("/");

        Assert.assertEquals(10, frame.getFrameScore());
        Assert.assertEquals("9", frame.getFirstShot());
        Assert.assertEquals("/", frame.getSecondShot());
    }
}
