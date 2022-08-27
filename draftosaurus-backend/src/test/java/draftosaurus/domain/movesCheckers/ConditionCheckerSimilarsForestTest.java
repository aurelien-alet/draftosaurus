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

public class ConditionCheckerSimilarsForestTest extends TestCase {

    public ConditionCheckerSimilarsForestTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( ConditionCheckerSimilarsForestTest.class );
    }

    public void testEmptySimilarForestPadockShouldAcceptAnyDinosaure() {
        ConditionCheckerSimilarsForest conditionChecker = 
            instanciateEmptyConditionCheckerSimilarsForest();
        
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

    public void testDiplodocusSimilarForestPadockShouldNotAcceptOtherDinosaures() {
        ConditionCheckerSimilarsForest conditionChecker = 
            instanciateDiplodocusConditionCheckerSimilarsForest();
        
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

        assertFalse(parasaurolophusResult);
        assertFalse(spinosaurusResult);
        assertFalse(stagosaurusResult);
        assertFalse(triceratopsResult);
        assertFalse(tyrannosaurusResult);
    }

    public void testDiplodocusSimilarForestPadockShouldAcceptDiplodocus() {
        ConditionCheckerSimilarsForest conditionChecker = 
            instanciateDiplodocusConditionCheckerSimilarsForest();

        boolean diplodocusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Diplodocus.class)
        );

        assertTrue(diplodocusResult);
    }

    private static ConditionCheckerSimilarsForest instanciateEmptyConditionCheckerSimilarsForest(){
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsMock();
        return new ConditionCheckerSimilarsForest(paddockAssignementsMock);
    }

    private static ConditionCheckerSimilarsForest 
    instanciateDiplodocusConditionCheckerSimilarsForest(){
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsWithDinosauresMock(
            new Pair<>(1, Specy.DIPLODOCUS)
        );
        return new ConditionCheckerSimilarsForest(paddockAssignementsMock);
    }

}
