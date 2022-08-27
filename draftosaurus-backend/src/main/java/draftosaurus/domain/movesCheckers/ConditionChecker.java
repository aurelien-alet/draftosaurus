package draftosaurus.domain.movesCheckers;

import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.dinosaures.Dinosaure;

public abstract class ConditionChecker {
    
    protected PaddockAssignements paddockAssignements;

    public ConditionChecker(PaddockAssignements paddockAssignements){
        this.paddockAssignements = paddockAssignements;
    }

    public abstract boolean isDinosaureAssignableToPaddock(Dinosaure dinosaure);
}
