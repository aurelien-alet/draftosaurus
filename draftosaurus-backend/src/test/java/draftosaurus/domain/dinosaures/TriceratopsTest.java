package draftosaurus.domain.dinosaures;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TriceratopsTest extends TestCase {
    
    public TriceratopsTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( TriceratopsTest.class );
    }

    public void testTriceratopsClassScoreShouldBe0() {
        Integer expectedScore = 0;

        assertEquals(expectedScore, Triceratops.score);
    }

    public void testTriceratopsClassSpecyShouldBeTriceratops() {
        Specy expectedSpecy = Specy.TRICERATOPS;

        assertEquals(expectedSpecy, Triceratops.specy);
    }

    public void testTriceratopsInstanceSpecyShouldBeTriceratops() {
        Triceratops triceratops = instanciateTriceratops();

        Specy expectedSpecy = Specy.TRICERATOPS;

        assertEquals(expectedSpecy, triceratops.getSpecy());
    }

    public void testTriceratopsExtendsDinosaure() {
        Triceratops triceratops = instanciateTriceratops();

        assertTrue(triceratops instanceof Dinosaure);
    }

    private Triceratops instanciateTriceratops(){
        return new Triceratops();
    }
}
