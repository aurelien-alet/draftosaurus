package draftosaurus.domain.movesCheckers;

import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.dinosaures.Dinosaure;

public class ConditionCheckerLonelyIsland extends ConditionChecker {
    
    private Integer PADOCK_SIZE = 1;
    private boolean ANY_DINOSAURE_CAN_BE_ASSIGNED = true;
    private boolean NO_DINOSAURE_CAN_BE_ASSIGNED_AS_PADDOCK_IS_FULL = false;

    public ConditionCheckerLonelyIsland(PaddockAssignements paddockAssignements) {
        super(paddockAssignements);
    }

    public boolean isDinosaureAssignableToPaddock(Dinosaure dinosaure){
        if(paddockAssignements.numberOfAssignedDinosaures() < PADOCK_SIZE){
            return ANY_DINOSAURE_CAN_BE_ASSIGNED;
        } else {
            return NO_DINOSAURE_CAN_BE_ASSIGNED_AS_PADDOCK_IS_FULL;
        }
    }

}
