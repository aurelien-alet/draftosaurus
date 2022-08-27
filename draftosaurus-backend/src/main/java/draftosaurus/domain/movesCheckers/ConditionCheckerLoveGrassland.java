package draftosaurus.domain.movesCheckers;

import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.dinosaures.Dinosaure;

public class ConditionCheckerLoveGrassland extends ConditionChecker {
    
    private boolean ANY_DINOSAURE_ACCEPTED_HERE = true;

    public ConditionCheckerLoveGrassland(PaddockAssignements paddockAssignements) {
        super(paddockAssignements);
    }

    public boolean isDinosaureAssignableToPaddock(Dinosaure dinosaure){
        return ANY_DINOSAURE_ACCEPTED_HERE;
    }

}
