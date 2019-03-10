package test;

import main.Bowling;
import main.Frame;
import org.junit.Assert;
import org.junit.Test;

public class BowlingTest {
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

        frame = new Frame();
        frame = bowling.calculateFirstRoll("/", frame);
        Assert.assertFalse(frame.getStrike());
        Assert.assertEquals(0, frame.getFrameScore());
        Assert.assertFalse(frame.getSpare());

        frame = new Frame();
        frame = bowling.calculateFirstRoll("9", frame);
        Assert.assertFalse(frame.getStrike());
        Assert.assertEquals(9, frame.getFrameScore());
        Assert.assertFalse(frame.getSpare());

        frame = new Frame();
        frame = bowling.calculateFirstRoll("abcd", frame);
        Assert.assertFalse(frame.getStrike());
        Assert.assertEquals(0, frame.getFrameScore());
        Assert.assertFalse(frame.getSpare());
    }

    @Test
    public void testSecondRollStrike() {
        Bowling bowling = new Bowling();
        Frame frame = new Frame();

        // Verify Strike
        frame.setFrameScore(2);
        frame = bowling.calculateSecondRoll("X", frame);
        Assert.assertFalse(frame.getStrike());

        frame.setFrameScore(0);
        frame = bowling.calculateSecondRoll("X", frame);
        Assert.assertFalse(frame.getStrike());
    }

    @Test
    public void testSecondRollSpare() {
        Bowling bowling = new Bowling();
        Frame frame = new Frame();

        frame = bowling.calculateSecondRoll("/", frame);
        Assert.assertTrue(frame.getSpare());

        frame = new Frame();
        frame.setFrameScore(5);
        frame = bowling.calculateSecondRoll("/", frame);
        Assert.assertTrue(frame.getSpare());
    }

    @Test
    public void testSecondRollOpen() {
        Bowling bowling = new Bowling();
        Frame frame = new Frame();

        frame = bowling.calculateSecondRoll("9", frame);
        Assert.assertEquals(9, frame.getFrameScore());

        frame.setFrameScore(6);
        frame = bowling.calculateSecondRoll("4", frame);
        Assert.assertEquals(10, frame.getFrameScore());

        frame.setFrameScore(5);
        frame = bowling.calculateSecondRoll("6", frame);
        Assert.assertEquals(5, frame.getFrameScore());
    }

    @Test
    public void testSecondRollInvalid() {
        Bowling bowling = new Bowling();
        Frame frame = new Frame();

        frame = bowling.calculateSecondRoll("abcd", frame);
        Assert.assertEquals(0, frame.getFrameScore());

        frame.setFrameScore(9);
        frame = bowling.calculateSecondRoll("abcd", frame);
        Assert.assertEquals(9, frame.getFrameScore());
    }
}
