package test.java;

import main.java.Bowling;
import main.java.BowlingFrame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class BowlingTest {
    Bowling bowling;
    BowlingFrame frame;

    @Before
    public void initialize() {
        bowling = new Bowling();
        frame = new BowlingFrame();
    }

    @Test
    public void testPlay() {
        String rollOne = "5";
        InputStream in = new ByteArrayInputStream(rollOne.getBytes());
        System.setIn(in);

        String rollTwo = "4";
        InputStream in2 = new ByteArrayInputStream(rollTwo.getBytes());
        System.setIn(in2);

        String quit = "q";
        InputStream in3 = new ByteArrayInputStream(quit.getBytes());
        System.setIn(in3);

        Assert.assertEquals(9, bowling.play());
    }

    @Test
    public void testPlaySpare() {

    }

    @Test
    public void testPlayStrike() {

    }

    @Test
    public void testPlayUnfinished() {

    }

    @Test
    public void testFrame() {
        BowlingFrame frame = new BowlingFrame();
        frame.setFirstScore(10);
        Assert.assertEquals(10, frame.getFirstScore());

        Assert.assertFalse(frame.getStrike());
        frame.setStrike(true);
        Assert.assertTrue(frame.getStrike());

        Assert.assertFalse(frame.getSpare());
        frame.setSpare(true);
        Assert.assertTrue(frame.getSpare());
    }

    @Test
    public void testFirstRoll() {
        Bowling bowling = new Bowling();
        BowlingFrame frame = new BowlingFrame();

        frame = bowling.calculateFirstRoll("X", frame);
        Assert.assertTrue(frame.getStrike());
        Assert.assertEquals(0, frame.getFirstScore());
        Assert.assertFalse(frame.getSpare());

        frame = new BowlingFrame();
        frame = bowling.calculateFirstRoll("/", frame);
        Assert.assertFalse(frame.getStrike());
        Assert.assertEquals(0, frame.getFirstScore());
        Assert.assertFalse(frame.getSpare());

        frame = new BowlingFrame();
        frame = bowling.calculateFirstRoll("9", frame);
        Assert.assertFalse(frame.getStrike());
        Assert.assertEquals(9, frame.getFirstScore());
        Assert.assertFalse(frame.getSpare());

        frame = new BowlingFrame();
        frame = bowling.calculateFirstRoll("abcd", frame);
        Assert.assertFalse(frame.getStrike());
        Assert.assertEquals(0, frame.getFirstScore());
        Assert.assertFalse(frame.getSpare());
    }

    @Test
    public void testSecondRollStrike() {
        Bowling bowling = new Bowling();
        BowlingFrame frame = new BowlingFrame();

        // Verify Strike
        frame.setFirstScore(0);
        frame = bowling.calculateSecondRoll("X", frame);
        Assert.assertFalse(frame.getStrike());

        frame.setSecondScore(2);
        frame = bowling.calculateSecondRoll("X", frame);
        Assert.assertFalse(frame.getStrike());
    }

    @Test
    public void testSecondRollSpare() {
        Bowling bowling = new Bowling();
        BowlingFrame frame = new BowlingFrame();

        frame = bowling.calculateSecondRoll("/", frame);
        Assert.assertTrue(frame.getSpare());

        frame = new BowlingFrame();
        frame.setFirstScore(5);
        frame = bowling.calculateSecondRoll("/", frame);
        Assert.assertTrue(frame.getSpare());
    }

    @Test
    public void testSecondRollOpen() {
        Bowling bowling = new Bowling();
        BowlingFrame frame = new BowlingFrame();

        frame = bowling.calculateSecondRoll("9", frame);
        Assert.assertEquals(9, frame.getSecondScore());

        frame = bowling.calculateSecondRoll("4", frame);
        Assert.assertEquals(4, frame.getSecondScore());

        frame.setSecondScore(0);
        frame = bowling.calculateSecondRoll("10", frame);
        Assert.assertEquals(0, frame.getSecondScore());
    }

    @Test
    public void testSecondRollInvalid() {
        Bowling bowling = new Bowling();
        BowlingFrame frame = new BowlingFrame();

        frame = bowling.calculateSecondRoll("abcd", frame);
        Assert.assertEquals(0, frame.getSecondScore());
    }
}
