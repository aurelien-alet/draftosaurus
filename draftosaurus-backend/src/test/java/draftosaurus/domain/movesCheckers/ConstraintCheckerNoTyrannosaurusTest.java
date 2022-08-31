package draftosaurus.domain.movesCheckers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.javatuples.Pair;

import draftosaurus.domain.board.PaddockAttributes;
import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.dinosaures.Specy;
import draftosaurus.testUtils.BoardMock;

public class ConstraintCheckerNoTyrannosaurusTest extends TestCase {

    public ConstraintCheckerNoTyrannosaurusTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( ConstraintCheckerNoTyrannosaurusTest.class );
    }

    public void testShouldAssignToEmptyPaddock(){
        ConstraintCheckerNoTyrannosaurus constraintChecker = instanciateConstraintCheckerEmpty();

        boolean isPaddockAssignable = constraintChecker.isPaddockAssignable();

        assertTrue(isPaddockAssignable);
    }

    public void testShouldAssignToPaddockWithoutTyrannosaurus(){
        ConstraintCheckerNoTyrannosaurus constraintChecker = instanciateConstraintCheckerWithDiplodocus();

        boolean isPaddockAssignable = constraintChecker.isPaddockAssignable();

        assertTrue(isPaddockAssignable);
    }

    public void testShouldNotAssignToPaddockWithTyrannosaurus(){
        ConstraintCheckerNoTyrannosaurus constraintChecker = instanciateConstraintCheckerWithTyrannosaurus();

        boolean isPaddockAssignable = constraintChecker.isPaddockAssignable();

        assertFalse(isPaddockAssignable);
    }

    private static ConstraintCheckerNoTyrannosaurus instanciateConstraintCheckerEmpty(){  
        PaddockAttributes paddockMock = BoardMock.instanciatePaddockAttributesMock();
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsMock();

        return new ConstraintCheckerNoTyrannosaurus(paddockMock, paddockAssignementsMock);
    }

    private static ConstraintCheckerNoTyrannosaurus instanciateConstraintCheckerWithDiplodocus(){  
        PaddockAttributes paddockMock = BoardMock.instanciatePaddockAttributesMock();
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsWithDinosauresMock(
            new Pair<>(1, Specy.DIPLODOCUS)
        );

        return new ConstraintCheckerNoTyrannosaurus(paddockMock,  paddockAssignementsMock);
    }

    private static ConstraintCheckerNoTyrannosaurus instanciateConstraintCheckerWithTyrannosaurus(){  
        PaddockAttributes paddockMock = BoardMock.instanciatePaddockAttributesMock();
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsWithDinosauresMock(
            new Pair<>(1, Specy.TYRANNOSAURUS)
        );

        return new ConstraintCheckerNoTyrannosaurus(paddockMock,  paddockAssignementsMock);
    }
}
