package draftosaurus.domain.movesCheckers;

import draftosaurus.domain.board.PaddockAttributes;
import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.dinosaures.Specy;

public class ConstraintCheckerNoTyrannosaurus extends ConstraintChecker {

    private static boolean CAN_ASSIGN_AS_THERE_IS_NO_TYRANNOSAURUS_IN_PADDOCK = true;
    private static boolean CANNOT_ASSIGN_AS_THERE_ARE_TYRANNOSAURUS_IN_PADDOCK = false;

    public ConstraintCheckerNoTyrannosaurus(PaddockAttributes paddock, PaddockAssignements paddockAssignements) {
        super(paddock, paddockAssignements);
    }

    @Override
    public boolean isPaddockAssignable() {
        if(paddockAssignements.numberOfAssignedSpecy(Specy.TYRANNOSAURUS) > 0 ){
            return CANNOT_ASSIGN_AS_THERE_ARE_TYRANNOSAURUS_IN_PADDOCK;
        } else {
            return CAN_ASSIGN_AS_THERE_IS_NO_TYRANNOSAURUS_IN_PADDOCK;
        }
    }
    
}
