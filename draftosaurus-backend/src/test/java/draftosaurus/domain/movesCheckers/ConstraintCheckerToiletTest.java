package draftosaurus.domain.movesCheckers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import draftosaurus.domain.board.Biome;
import draftosaurus.domain.board.PaddockAttributes;
import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.board.Side;

import draftosaurus.testUtils.BoardMock;

public class ConstraintCheckerToiletTest extends TestCase {

    public ConstraintCheckerToiletTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( ConstraintCheckerToiletTest.class );
    }

    public void testShouldAssignToToilet(){
        ConstraintCheckerToilet grasslandToiletSideChecker = instanciateConstraintCheckerToilet(
            Side.TOILET, Biome.GRASSLAND
        );
        ConstraintCheckerToilet forestToiletSideChecker = instanciateConstraintCheckerToilet(
            Side.TOILET, Biome.FOREST
        );

        boolean grasslandToiletSideIsAssignable = grasslandToiletSideChecker.isPaddockAssignable();
        boolean forestToiletSideIsAssignable = forestToiletSideChecker.isPaddockAssignable();

        assertTrue(grasslandToiletSideIsAssignable);
        assertTrue(forestToiletSideIsAssignable);
    }

    public void testShouldNotAssignToCafetaria(){
        ConstraintCheckerToilet grasslandCafetatiaSideChecker = instanciateConstraintCheckerToilet(
            Side.CAFETERIA, Biome.GRASSLAND
        );
        ConstraintCheckerToilet forestCafeteriaSideChecker = instanciateConstraintCheckerToilet(
            Side.CAFETERIA, Biome.FOREST
        );

        boolean grasslandCafetariaSideIsAssignable = grasslandCafetatiaSideChecker.isPaddockAssignable();
        boolean forestCafeteriaSideIsAssignable = forestCafeteriaSideChecker.isPaddockAssignable();

        assertFalse(grasslandCafetariaSideIsAssignable);
        assertFalse(forestCafeteriaSideIsAssignable);
    }

    private static ConstraintCheckerToilet instanciateConstraintCheckerToilet(Side side, Biome biome){  
        PaddockAttributes paddockMock = BoardMock.instanciatePaddockAttributesWithAttributesMock(side, biome);
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsMock();

        return new ConstraintCheckerToilet(paddockMock,  paddockAssignementsMock);
    }

}
