package draftosaurus.domain.dinosaures;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TyrannosaurusTest extends TestCase{
    
    public TyrannosaurusTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( TyrannosaurusTest.class );
    }

    public void testTyrannosaurusClassScoreShouldBe1() {
        Integer expectedScore = 1;

        assertEquals(expectedScore, Tyrannosaurus.score);
    }

    public void testTyrannosaurusClassSpecyShouldBeTyrannosaurus() {
        Specy expectedSpecy = Specy.TYRANNOSAURUS;

        assertEquals(expectedSpecy, Tyrannosaurus.specy);
    }

    public void testTyrannosaurusInstanceSpecyShouldBeTyrannosaurus() {
        Tyrannosaurus tyrannosaurus = instanciateTyrannosaurus();

        Specy expectedSpecy = Specy.TYRANNOSAURUS;

        assertEquals(expectedSpecy, tyrannosaurus.getSpecy());
    }

    public void testTyrannosaurusExtendsDinosaure() {
        Tyrannosaurus tyrannosaurus = instanciateTyrannosaurus();

        assertTrue(tyrannosaurus instanceof Dinosaure);
    }

    private Tyrannosaurus instanciateTyrannosaurus(){
        return new Tyrannosaurus();
    }
}
