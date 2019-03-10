package test;

import main.Bowling;
import main.Frame;
import org.junit.Assert;
import org.junit.Test;

public class BowlingTest {


    @Test
    public void testScore() {
//        Bowling bowling = new Bowling();
//
//        int score = bowling.calculateFirstRoll("X");
//        Assert.assertEquals(3, score);
//        score = bowling.calculateFirstRoll("x");
//        Assert.assertEquals(3, score);
//
//        score = bowling.calculateFirstRoll("/");
//        Assert.assertEquals(2, score);
//
//        score = bowling.calculateFirstRoll("0");
//        Assert.assertEquals(1, score);
//        score = bowling.calculateFirstRoll("6");
//        Assert.assertEquals(1, score);
//        score = bowling.calculateFirstRoll("9");
//        Assert.assertEquals(1, score);
//
//        score = bowling.calculateFirstRoll("abf");
//        Assert.assertEquals(0, score);
    }

    @Test
    public void testFrame() {
        Frame frame = new Frame();
        frame.setFrameScore(10);
        Assert.assertEquals(10, frame.getFrameScore());

        Assert.assertFalse(frame.getStrike());
        frame.setStrike(true);
        Assert.assertTrue(frame.getStrike());

        Assert.assertFalse(frame.getSpare());
        frame.setSpare(true);
        Assert.assertTrue(frame.getSpare());

        Assert.assertNull(frame.getPreviousFrame());
        Assert.assertNull(frame.getNextFrame());
    }

    @Test
    public void testFirstRoll() {
        Bowling bowling = new Bowling();
        Frame frame = new Frame();

        frame = bowling.calculateFirstRoll("X", frame);
        Assert.assertTrue(frame.getStrike());
        Assert.assertEquals(0, frame.getFrameScore());
        Assert.assertFalse(frame.getSpare());
    }
}
