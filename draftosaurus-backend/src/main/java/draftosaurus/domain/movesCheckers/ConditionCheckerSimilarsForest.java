package draftosaurus.domain.movesCheckers;

import draftosaurus.domain.dinosaures.Specy;
import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.dinosaures.Dinosaure;

public class ConditionCheckerSimilarsForest extends ConditionChecker {
    
    private boolean ANY_DINOSAURE_CAN_BE_ASSIGNED = true;
    private boolean DINOSAURE_SIMILAR_SPECY_TO_ASSIGNED_CAN_BE_ASSIGNED = true;
    private boolean DINOSAURE_DIFFERENT_SPECY_TO_ASSIGNED_CANNOT_BE_ASSIGNED = false;

    public ConditionCheckerSimilarsForest(PaddockAssignements paddockAssignements) {
        super(paddockAssignements);
    }

    public boolean isDinosaureAssignableToPaddock(Dinosaure dinosaure){
        if( isPaddockEmpty(paddockAssignements) ){
            return isDinosaureAssignableToEmptyPaddock(dinosaure);
        } else {
            return isDinosaureAssignableToAlreadyAssignedPaddock(dinosaure);
        }
    }

    private boolean isPaddockEmpty(PaddockAssignements paddockAssignements){
        return paddockAssignements.numberOfAssignedDinosaures() == 0;
    }

    private boolean isDinosaureAssignableToEmptyPaddock(Dinosaure dinosaure){
        return ANY_DINOSAURE_CAN_BE_ASSIGNED;
    }

    private boolean isDinosaureAssignableToAlreadyAssignedPaddock(Dinosaure dinosaure){
        Specy dinosaureToAssignSpecy = dinosaure.getSpecy();
        if( paddockAssignements.numberOfAssignedSpecy(dinosaureToAssignSpecy) > 0 ){
            return  DINOSAURE_SIMILAR_SPECY_TO_ASSIGNED_CAN_BE_ASSIGNED;
        } else {
            return DINOSAURE_DIFFERENT_SPECY_TO_ASSIGNED_CANNOT_BE_ASSIGNED;
        }
    }
}
