package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    private Game g;

    @Before
    public void setUp() {
        g = new Game();
    }

    @Test
    public void canRoll() {
        g.roll(0);
    }

    @Test
    public void testSpare() {

    }

}
