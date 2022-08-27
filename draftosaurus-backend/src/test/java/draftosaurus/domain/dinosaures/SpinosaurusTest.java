package draftosaurus.domain.dinosaures;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SpinosaurusTest extends TestCase {
    
    public SpinosaurusTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( SpinosaurusTest.class );
    }

    public void testSpinosaurusClassScoreShouldBe0() {
        Integer expectedScore = 0;

        assertEquals(expectedScore, Spinosaurus.score);
    }

    public void testSpinosaurusClassSpecyShouldBeSpinosaurus() {
        Specy expectedSpecy = Specy.SPINOSAURUS;

        assertEquals(expectedSpecy, Spinosaurus.specy);
    }

    public void testSpinosaurusInstanceSpecyShouldBeSpinosaurus() {
        Spinosaurus spinosaurus = instanciateSpinosaurus();

        Specy expectedSpecy = Specy.SPINOSAURUS;

        assertEquals(expectedSpecy, spinosaurus.getSpecy());
    }

    public void testSpinosaurusExtendsDinosaure() {
        Spinosaurus spinosaurus = instanciateSpinosaurus();

        assertTrue(spinosaurus instanceof Dinosaure);
    }

    private Spinosaurus instanciateSpinosaurus(){
        return new Spinosaurus();
    }
}
