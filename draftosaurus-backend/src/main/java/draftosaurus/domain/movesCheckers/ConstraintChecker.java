package draftosaurus.domain.movesCheckers;

import draftosaurus.domain.board.PaddockAttributes;
import draftosaurus.domain.board.PaddockAssignements;

public abstract class ConstraintChecker {
    
    protected PaddockAttributes paddock;
    protected PaddockAssignements paddockAssignements;

    public ConstraintChecker(PaddockAttributes paddock, PaddockAssignements paddockAssignements){
        this.paddock = paddock;
        this.paddockAssignements = paddockAssignements;
    }

    public abstract boolean isPaddockAssignable();

}
