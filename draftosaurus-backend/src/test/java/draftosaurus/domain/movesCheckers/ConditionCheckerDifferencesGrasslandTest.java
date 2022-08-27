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

public class ConditionCheckerDifferencesGrasslandTest extends TestCase {

    public ConditionCheckerDifferencesGrasslandTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( ConditionCheckerDifferencesGrasslandTest.class );
    }

    public void testEmptyDifferencesGrasslandPadockShouldAcceptAnyDinosaure() {
        ConditionCheckerDifferencesGrassland conditionChecker = 
            instanciateEmptyConditionCheckerDifferencesGrassland();
        
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

    public void testSpinosaurusDifferencesGrasslandPadockShouldAcceptAnyOtherDinosaures() {
        ConditionCheckerDifferencesGrassland conditionChecker = 
            instanciateSpinosaurusConditionCheckerDifferencesGrassland();
        
        boolean diplodocusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Diplodocus.class)
        );
        boolean parasaurolophusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Parasaurolophus.class)
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

        assertTrue(diplodocusResult);
        assertTrue(parasaurolophusResult);
        assertTrue(stagosaurusResult);
        assertTrue(triceratopsResult);
        assertTrue(tyrannosaurusResult);
    }

    public void testSpinosaurusDifferencesGrasslandPadockShouldNotAcceptSpinosaurus() {
        ConditionCheckerDifferencesGrassland conditionChecker = 
            instanciateSpinosaurusConditionCheckerDifferencesGrassland();

        boolean spinosaurusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Spinosaurus.class)
        );

        assertFalse(spinosaurusResult);
    }

    public void testBigDifferencesGrasslandPaddockShouldAcceptUnassignedDinosaureType() {
        ConditionCheckerDifferencesGrassland conditionChecker = 
            instanciateBigConditionCheckerDifferencesGrassland();

        boolean parasaurolophusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Parasaurolophus.class)
        );

        assertTrue(parasaurolophusResult);
    }

    public void testBigDifferencesGrasslandPaddockShouldNotAcceptAlreadyAssignedDinosaureType() {
        ConditionCheckerDifferencesGrassland conditionChecker = 
            instanciateBigConditionCheckerDifferencesGrassland();

        boolean diplodocusResult = conditionChecker.isDinosaureAssignableToPaddock(
            DinosaureMock.instanciateDinosaureSpecyMock(Diplodocus.class)
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

        assertFalse(diplodocusResult);
        assertFalse(spinosaurusResult);
        assertFalse(stagosaurusResult);
        assertFalse(triceratopsResult);
        assertFalse(tyrannosaurusResult);
    }

    private static ConditionCheckerDifferencesGrassland 
    instanciateEmptyConditionCheckerDifferencesGrassland(){
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsMock();
        return new ConditionCheckerDifferencesGrassland(paddockAssignementsMock);
    }

    private static ConditionCheckerDifferencesGrassland 
    instanciateSpinosaurusConditionCheckerDifferencesGrassland(){
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsWithDinosauresMock(
            new Pair<>(1, Specy.SPINOSAURUS)
        );
        return new ConditionCheckerDifferencesGrassland(paddockAssignementsMock);
    }

    private static ConditionCheckerDifferencesGrassland 
    instanciateBigConditionCheckerDifferencesGrassland(){
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsWithDinosauresMock(
            new Pair<>(1, Specy.DIPLODOCUS),
            new Pair<>(1, Specy.SPINOSAURUS),
            new Pair<>(1, Specy.STEGOSAURUS),
            new Pair<>(1, Specy.TRICERATOPS),
            new Pair<>(1, Specy.TYRANNOSAURUS)
        );
        return new ConditionCheckerDifferencesGrassland(paddockAssignementsMock);
    }

}
