package draftosaurus.domain.movesCheckers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import draftosaurus.domain.board.Biome;
import draftosaurus.domain.board.PaddockAttributes;
import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.board.Side;

import draftosaurus.testUtils.BoardMock;

public class ConstraintCheckerCafeteriaTest extends TestCase {

    public ConstraintCheckerCafeteriaTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( ConstraintCheckerCafeteriaTest.class );
    }
    
        public void testShouldAssignToCafetaria(){
            ConstraintCheckerCafeteria grasslandCafetatiaSideChecker = instanciateConstraintCheckerCafeteria(
                Side.CAFETERIA, Biome.GRASSLAND
            );
            ConstraintCheckerCafeteria forestCafeteriaSideChecker = instanciateConstraintCheckerCafeteria(
                Side.CAFETERIA, Biome.FOREST
            );
    
            boolean grasslandCafetariaSideIsAssignable = grasslandCafetatiaSideChecker.isPaddockAssignable();
            boolean forestCafeteriaSideIsAssignable = forestCafeteriaSideChecker.isPaddockAssignable();
    
            assertTrue(grasslandCafetariaSideIsAssignable);
            assertTrue(forestCafeteriaSideIsAssignable);
        }

    public void testShouldNotAssignToToilet(){
        ConstraintCheckerCafeteria grasslandToiletSideChecker = instanciateConstraintCheckerCafeteria(
            Side.TOILET, Biome.GRASSLAND
        );
        ConstraintCheckerCafeteria forestToiletSideChecker = instanciateConstraintCheckerCafeteria(
            Side.TOILET, Biome.FOREST
        );

        boolean grasslandToiletSideIsAssignable = grasslandToiletSideChecker.isPaddockAssignable();
        boolean forestToiletSideIsAssignable = forestToiletSideChecker.isPaddockAssignable();

        assertFalse(grasslandToiletSideIsAssignable);
        assertFalse(forestToiletSideIsAssignable);
    }

    private static ConstraintCheckerCafeteria instanciateConstraintCheckerCafeteria(Side side, Biome biome){  
        PaddockAttributes paddockMock = BoardMock.instanciatePaddockAttributesWithAttributesMock(side, biome);
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsMock();

        return new ConstraintCheckerCafeteria(paddockMock,  paddockAssignementsMock);
    }

}
