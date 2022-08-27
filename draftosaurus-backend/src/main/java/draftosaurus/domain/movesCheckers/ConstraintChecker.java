package draftosaurus.domain.movesCheckers;

import draftosaurus.domain.board.Paddock;
import draftosaurus.domain.board.PaddockAssignements;

public abstract class ConstraintChecker {
    
    protected Paddock paddock;
    protected PaddockAssignements paddockAssignements;

    public ConstraintChecker(Paddock paddock, PaddockAssignements paddockAssignements){
        this.paddock = paddock;
        this.paddockAssignements = paddockAssignements;
    }

    public abstract boolean isPaddockAssignable();

}
