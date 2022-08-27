package draftosaurus.domain.board;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import draftosaurus.domain.utils.IntGenerator;

public class ConstraintDiceTest extends TestCase {

    public ConstraintDiceTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( ConstraintDiceTest.class );
    }

    public void testConstraintDiceRollShouldReturnForest() {
        ConstraintDice dice = instanciateConstantConstraintDice(0);
        ConstraintDiceFace expectedFace = ConstraintDiceFace.FOREST_BIOME;

        ConstraintDiceFace actualFace = dice.roll();

        assertEquals(expectedFace, actualFace);
    }

    public void testConstraintDiceRollShouldReturnGrassland() {
        ConstraintDice dice = instanciateConstantConstraintDice(1);
        ConstraintDiceFace expectedFace = ConstraintDiceFace.GRASSLAND_BIOME;

        ConstraintDiceFace actualFace = dice.roll();

        assertEquals(expectedFace, actualFace);
    }

    public void testConstraintDiceRollShouldReturnToiletsSide() {
        ConstraintDice dice = instanciateConstantConstraintDice(2);
        ConstraintDiceFace expectedFace = ConstraintDiceFace.TOILETS_SIDE;

        ConstraintDiceFace actualFace = dice.roll();

        assertEquals(expectedFace, actualFace);
    }

    public void testConstraintDiceRollShouldReturnCafeteriaSide() {
        ConstraintDice dice = instanciateConstantConstraintDice(3);
        ConstraintDiceFace expectedFace = ConstraintDiceFace.CAFETERIA_SIDE;

        ConstraintDiceFace actualFace = dice.roll();

        assertEquals(expectedFace, actualFace);
    }

    public void testConstraintDiceRollShouldReturnEmptyPaddock() {
        ConstraintDice dice = instanciateConstantConstraintDice(4);
        ConstraintDiceFace expectedFace = ConstraintDiceFace.EMPTY_PADDOCK;

        ConstraintDiceFace actualFace = dice.roll();

        assertEquals(expectedFace, actualFace);
    }

    public void testConstraintDiceRollShouldReturnTyrannosaurusWarning() {
        ConstraintDice dice = instanciateConstantConstraintDice(5);
        ConstraintDiceFace expectedFace = ConstraintDiceFace.NO_TYRANNOSAURUS;

        ConstraintDiceFace actualFace = dice.roll();

        assertEquals(expectedFace, actualFace);
    }

    private ConstraintDice instanciateConstantConstraintDice(Integer constantFaceNumber){
        IntGeneratorMock intGeneratorMock = new IntGeneratorMock();
        intGeneratorMock.setMockResult(constantFaceNumber);
        return new ConstraintDice(intGeneratorMock);
    }

    private class IntGeneratorMock implements IntGenerator {

        Integer mockResult = -1;

        public Integer pickNumberBetweenAInclusiveAndBExclusive(Integer a, Integer b) {
            return mockResult;
        }

        public void setMockResult(Integer i){
            mockResult = i;
        }
    }

}
