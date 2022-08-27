package draftosaurus.domain.movesCheckers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.javatuples.Pair;

import draftosaurus.domain.board.Paddock;
import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.dinosaures.Specy;
import draftosaurus.testUtils.BoardMock;

public class ConstraintCheckerEmptyTest extends TestCase {

    public ConstraintCheckerEmptyTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( ConstraintCheckerEmptyTest.class );
    }

    public void testShouldAssignToEmptyPaddock(){
        ConstraintCheckerEmpty constraintChecker = instanciateConstraintCheckerEmpty();

        boolean isPaddockAssignable = constraintChecker.isPaddockAssignable();

        assertTrue(isPaddockAssignable);
    }

    public void testShouldNotAssignToPaddockNotEmpty(){
        ConstraintCheckerEmpty constraintChecker = instanciateConstraintCheckerWithDiplodocus();

        boolean isPaddockAssignable = constraintChecker.isPaddockAssignable();

        assertFalse(isPaddockAssignable);
    }

    private static ConstraintCheckerEmpty instanciateConstraintCheckerEmpty(){  
        Paddock paddockMock = BoardMock.instanciatePaddock();
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsMock();

        return new ConstraintCheckerEmpty(paddockMock, paddockAssignementsMock);
    }

    private static ConstraintCheckerEmpty instanciateConstraintCheckerWithDiplodocus(){  
        Paddock paddockMock = BoardMock.instanciatePaddock();
        PaddockAssignements paddockAssignementsMock = BoardMock.instanciatePaddockAssignementsWithDinosauresMock(
            new Pair<>(1, Specy.DIPLODOCUS)
        );

        return new ConstraintCheckerEmpty(paddockMock,  paddockAssignementsMock);
    }
}
