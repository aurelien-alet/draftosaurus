package draftosaurus.domain.dinosaures;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class StegosaurusTest extends TestCase {
    
    public StegosaurusTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( StegosaurusTest.class );
    }

    public void testStegosaurusClassScoreShouldBe0() {
        Integer expectedScore = 0;

        assertEquals(expectedScore, Stegosaurus.score);
    }

    public void testStegosaurusClassSpecyShouldBeStegosaurus() {
        Specy expectedSpecy = Specy.STEGOSAURUS;

        assertEquals(expectedSpecy, Stegosaurus.specy);
    }

    public void testStegosaurusInstanceSpecyShouldBeStegosaurus() {
        Stegosaurus stegosaurus = instanciateStegosaurus();

        Specy expectedSpecy = Specy.STEGOSAURUS;

        assertEquals(expectedSpecy, stegosaurus.getSpecy());
    }

    public void testStegosaurusExtendsDinosaure() {
        Stegosaurus stegosaurus = instanciateStegosaurus();

        assertTrue(stegosaurus instanceof Dinosaure);
    }

    private Stegosaurus instanciateStegosaurus(){
        return new Stegosaurus();
    }
}
