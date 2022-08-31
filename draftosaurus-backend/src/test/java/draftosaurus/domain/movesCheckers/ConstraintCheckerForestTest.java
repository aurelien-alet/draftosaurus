package draftosaurus.domain.movesCheckers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import draftosaurus.domain.board.Biome;
import draftosaurus.domain.board.PaddockAttributes;
import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.board.Side;

import draftosaurus.testUtils.BoardMock;

public class ConstraintCheckerForestTest extends TestCase {

    public ConstraintCheckerForestTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( ConstraintCheckerForestTest.class );
    }

    public void testShouldAssignToForest(){
        ConstraintCheckerForest forestToiletSideChecker = instanciateConstraintCheckerForest(
            Side.TOILET, Biome.FOREST
        );
        ConstraintCheckerForest forestCafeteriaSideChecker = instanciateConstraintCheckerForest(
            Side.CAFETERIA, Biome.FOREST
        );

        boolean forestToiletSideIsAssignable = forestToiletSideChecker.isPaddockAssignable();
        boolean forestCafeteriaSideIsAssignable = forestCafeteriaSideChecker.isPaddockAssignable();

        assertTrue(forestToiletSideIsAssignable);
        assertTrue(forestCafeteriaSideIsAssignable);
    }

    public void testShouldNotAssignToGrassland(){
        ConstraintCheckerForest grasslandToiletSideChecker = instanciateConstraintCheckerForest(
            Side.TOILET, Biome.GRASSLAND
        );
        ConstraintCheckerForest grasslandCafeteriaSideChecker = instanciateConstraintCheckerForest(
            Side.CAFETERIA, Biome.GRASSLAND
        );

        boolean grasslandToiletSideIsAssignable = grasslandToiletSideChecker.isPaddockAssignable();
        boolean grasslandCafeteriaSideIsAssignable = grasslandCafeteriaSideChecker.isPaddockAssignable();

        assertFalse(grasslandToiletSideIsAssignable);
        assertFalse(grasslandCafeteriaSideIsAssignable);
    }

    private static ConstraintCheckerForest instanciateConstraintCheckerForest(Side side, Biome biome){  
        PaddockAttributes paddockMock = BoardMock.instanciatePaddockAttributesWithAttributesMock(side, biome);
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsMock();

        return new ConstraintCheckerForest(paddockMock,  paddockAssignementsMock);
    }

}
