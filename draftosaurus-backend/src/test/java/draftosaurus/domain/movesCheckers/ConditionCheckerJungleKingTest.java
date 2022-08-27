package draftosaurus.domain.movesCheckers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.javatuples.Pair;

import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.dinosaures.Diplodocus;
import draftosaurus.domain.dinosaures.Parasaurolophus;
import draftosaurus.domain.dinosaures.Specy;
import draftosaurus.domain.dinosaures.Spinosaurus;
import draftosaurus.domain.dinosaures.Stegosaurus;
import draftosaurus.domain.dinosaures.Triceratops;
import draftosaurus.domain.dinosaures.Tyrannosaurus;

import draftosaurus.testUtils.BoardMock;
import draftosaurus.testUtils.DinosaureMock;

public class ConditionCheckerJungleKingTest extends TestCase {

    public ConditionCheckerJungleKingTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( ConditionCheckerJungleKingTest.class );
    }

    public void testEmptyJungleKingPadockShouldAcceptAnyDinosaure() {
        ConditionCheckerJungleKing conditionChecker = 
            instanciateEmptyConditionCheckerJungleKing();
        
        boolean genericResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureMock()
        );
        boolean diplodocusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Diplodocus.class)
        );
        boolean parasaurolophusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Parasaurolophus.class)
        );
        boolean spinosaurusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Spinosaurus.class)
        );
        boolean stagosaurusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Stegosaurus.class)
        );
        boolean triceratopsResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Triceratops.class)
        );
        boolean tyrannosaurusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Tyrannosaurus.class)
        );

        assertTrue(genericResult);
        assertTrue(diplodocusResult);
        assertTrue(parasaurolophusResult);
        assertTrue(spinosaurusResult);
        assertTrue(stagosaurusResult);
        assertTrue(triceratopsResult);
        assertTrue(tyrannosaurusResult);
    }

    public void testNotemptyJungleKingPadockShouldAcceptNoNewDinosaure() {
        ConditionCheckerJungleKing conditionChecker = 
            instanciateDinosaureConditionCheckerJungleKing();
        
        boolean genericResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureMock()
        );
        boolean diplodocusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Diplodocus.class)
        );
        boolean parasaurolophusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Parasaurolophus.class)
        );
        boolean spinosaurusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Spinosaurus.class)
        );
        boolean stagosaurusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Stegosaurus.class)
        );
        boolean triceratopsResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Triceratops.class)
        );
        boolean tyrannosaurusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Tyrannosaurus.class)
        );

        assertFalse(genericResult);
        assertFalse(diplodocusResult);
        assertFalse(parasaurolophusResult);
        assertFalse(spinosaurusResult);
        assertFalse(stagosaurusResult);
        assertFalse(triceratopsResult);
        assertFalse(tyrannosaurusResult);
    }

    private static ConditionCheckerJungleKing instanciateEmptyConditionCheckerJungleKing(){
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsMock();
        return new ConditionCheckerJungleKing(paddockAssignementsMock);
    }

    private static ConditionCheckerJungleKing 
    instanciateDinosaureConditionCheckerJungleKing(){
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsWithDinosauresMock(
            new Pair<>(1, Specy.GENERIC)
        );
        return new ConditionCheckerJungleKing(paddockAssignementsMock);
    }

}
