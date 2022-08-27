package draftosaurus.domain.dinosaures;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DiplodocusTest extends TestCase {
    
    public DiplodocusTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( DiplodocusTest.class );
    }

    public void testDiplodocusClassScoreShouldBe0() {
        Integer expectedScore = 0;
        
        assertEquals(expectedScore, Diplodocus.score);
    }

    public void testDiplodocusClassSpecyShouldBeDiplodocus() {
        Specy expectedSpecy = Specy.DIPLODOCUS;

        assertEquals(expectedSpecy, Diplodocus.specy);
    }

    public void testDiplodocusInstanceSpecyShouldBeDiplodocus() {
        Diplodocus diplodocus = instanciateDiplodocus();

        Specy expectedSpecy = Specy.DIPLODOCUS;

        assertEquals(expectedSpecy, diplodocus.getSpecy());
    }

    public void testDiplodocusExtendsDinosaure() {
        Diplodocus diplodocus = instanciateDiplodocus();

        assertTrue(diplodocus instanceof Dinosaure);
    }

    private Diplodocus instanciateDiplodocus(){
        return new Diplodocus();
    }
}
