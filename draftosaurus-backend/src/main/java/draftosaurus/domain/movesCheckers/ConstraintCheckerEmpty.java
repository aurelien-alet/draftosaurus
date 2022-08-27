package draftosaurus.domain.movesCheckers;

import draftosaurus.domain.board.Paddock;
import draftosaurus.domain.board.PaddockAssignements;

public class ConstraintCheckerEmpty extends ConstraintChecker {

    private static boolean CAN_ASSIGN_AS_THERE_IS_NO_DINOSAURE_IN_PADDOCK = true;
    private static boolean CANNOT_ASSIGN_AS_THERE_ARE_DINOSAURES_IN_PADDOCK = false;

    public ConstraintCheckerEmpty(Paddock paddock, PaddockAssignements paddockAssignements) {
        super(paddock, paddockAssignements);
    }

    @Override
    public boolean isPaddockAssignable() {
        if(paddockAssignements.numberOfAssignedDinosaures() > 0 ){
            return CANNOT_ASSIGN_AS_THERE_ARE_DINOSAURES_IN_PADDOCK;
        } else {
            return CAN_ASSIGN_AS_THERE_IS_NO_DINOSAURE_IN_PADDOCK;
        }
    }
    
}
