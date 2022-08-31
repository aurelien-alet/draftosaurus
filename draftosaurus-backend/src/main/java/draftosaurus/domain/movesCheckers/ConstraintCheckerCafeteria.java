package draftosaurus.domain.movesCheckers;

import draftosaurus.domain.board.PaddockAttributes;
import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.board.Side;

public class ConstraintCheckerCafeteria extends ConstraintChecker {

    private static Side expectedSide = Side.CAFETERIA;
    private static boolean CAN_ASSIGN_AS_SIDE_IS_CAFETERIA = true;
    private static boolean CANNOT_ASSIGN_AS_SIDE_IS_NOT_CAFETERIA = false;

    public ConstraintCheckerCafeteria(PaddockAttributes paddock, PaddockAssignements paddockAssignements) {
        super(paddock, paddockAssignements);
    }

    @Override
    public boolean isPaddockAssignable() {
        if(paddock.getSide() == expectedSide ){
            return CAN_ASSIGN_AS_SIDE_IS_CAFETERIA;
        } else {
            return CANNOT_ASSIGN_AS_SIDE_IS_NOT_CAFETERIA;
        }
    }
    
}
