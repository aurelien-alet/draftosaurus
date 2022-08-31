package draftosaurus.domain.movesCheckers;

import draftosaurus.domain.board.PaddockAttributes;
import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.board.Side;

public class ConstraintCheckerToilet extends ConstraintChecker {

    private static Side expectedSide = Side.TOILET;
    private static boolean CAN_ASSIGN_AS_SIDE_IS_TOILET = true;
    private static boolean CANNOT_ASSIGN_AS_SIDE_IS_NOT_TOILET = false;

    public ConstraintCheckerToilet(PaddockAttributes paddock, PaddockAssignements paddockAssignements) {
        super(paddock, paddockAssignements);
    }

    @Override
    public boolean isPaddockAssignable() {
        if(paddock.getSide() == expectedSide ){
            return CAN_ASSIGN_AS_SIDE_IS_TOILET;
        } else {
            return CANNOT_ASSIGN_AS_SIDE_IS_NOT_TOILET;
        }
    }
    
}
