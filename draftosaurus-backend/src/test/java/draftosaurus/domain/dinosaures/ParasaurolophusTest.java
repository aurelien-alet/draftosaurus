package draftosaurus.domain.dinosaures;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ParasaurolophusTest extends TestCase {
    
    public ParasaurolophusTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( ParasaurolophusTest.class );
    }

    public void testParasaurolophusClassScoreShouldBe0() {
        Integer expectedScore = 0;

        assertEquals(expectedScore, Parasaurolophus.score);
    }

    public void testParasaurolophusClassSpecyShouldBeParasaurolophus() {
        Specy expectedSpecy = Specy.PARASAUROLOPHUS;

        assertEquals(expectedSpecy, Parasaurolophus.specy);
    }

    public void testParasaurolophusInstanceSpecyShouldBeParasaurolophus() {
        Parasaurolophus parasaurolophus = instanciateParasaurolophus();

        Specy expectedSpecy = Specy.PARASAUROLOPHUS;

        assertEquals(expectedSpecy, parasaurolophus.getSpecy());
    }

    public void testParasaurolophusExtendsDinosaure() {
        Parasaurolophus parasaurolophus = instanciateParasaurolophus();

        assertTrue(parasaurolophus instanceof Dinosaure);
    }

    private Parasaurolophus instanciateParasaurolophus(){
        return new Parasaurolophus();
    }
}
