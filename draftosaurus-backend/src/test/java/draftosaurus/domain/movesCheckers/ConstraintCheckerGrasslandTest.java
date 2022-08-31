package draftosaurus.domain.movesCheckers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import draftosaurus.domain.board.Biome;
import draftosaurus.domain.board.PaddockAttributes;
import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.board.Side;

import draftosaurus.testUtils.BoardMock;

public class ConstraintCheckerGrasslandTest extends TestCase {

    public ConstraintCheckerGrasslandTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( ConstraintCheckerGrasslandTest.class );
    }

    public void testShouldAssignToGrassland(){
        ConstraintCheckerGrassland grasslandToiletSideChecker = instanciateConstraintCheckerGrassland(
            Side.TOILET, Biome.GRASSLAND
        );
        ConstraintCheckerGrassland grasslandCafeteriaSideChecker = instanciateConstraintCheckerGrassland(
            Side.CAFETERIA, Biome.GRASSLAND
        );

        boolean grasslandToiletSideIsAssignable = grasslandToiletSideChecker.isPaddockAssignable();
        boolean grasslandCafeteriaSideIsAssignable = grasslandCafeteriaSideChecker.isPaddockAssignable();

        assertTrue(grasslandToiletSideIsAssignable);
        assertTrue(grasslandCafeteriaSideIsAssignable);
    }

    public void testShouldNotAssignToForest(){
        ConstraintCheckerGrassland forestToiletSideChecker = instanciateConstraintCheckerGrassland(
            Side.TOILET, Biome.FOREST
        );
        ConstraintCheckerGrassland forestCafeteriaSideChecker = instanciateConstraintCheckerGrassland(
            Side.CAFETERIA, Biome.FOREST
        );

        boolean forestToiletSideIsAssignable = forestToiletSideChecker.isPaddockAssignable();
        boolean forestCafeteriaSideIsAssignable = forestCafeteriaSideChecker.isPaddockAssignable();

        assertFalse(forestToiletSideIsAssignable);
        assertFalse(forestCafeteriaSideIsAssignable);
    }

    private static ConstraintCheckerGrassland instanciateConstraintCheckerGrassland(Side side, Biome biome){  
        PaddockAttributes paddockMock = BoardMock.instanciatePaddockAttributesWithAttributesMock(side, biome);
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsMock();

        return new ConstraintCheckerGrassland(paddockMock,  paddockAssignementsMock);
    }

}
