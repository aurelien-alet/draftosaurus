package draftosaurus.domain.movesCheckers;

import draftosaurus.domain.board.Biome;
import draftosaurus.domain.board.Paddock;
import draftosaurus.domain.board.PaddockAssignements;

public class ConstraintCheckerForest extends ConstraintChecker {

    private static Biome expectedBiome = Biome.FOREST;
    private static boolean CAN_ASSIGN_AS_BIOME_IS_FOREST = true;
    private static boolean CANNOT_ASSIGN_AS_BIOME_IS_NOT_FOREST = false;

    public ConstraintCheckerForest(Paddock paddock, PaddockAssignements paddockAssignements) {
        super(paddock, paddockAssignements);
    }

    @Override
    public boolean isPaddockAssignable() {
        if(paddock.getBiome() == expectedBiome ){
            return CAN_ASSIGN_AS_BIOME_IS_FOREST;
        } else {
            return CANNOT_ASSIGN_AS_BIOME_IS_NOT_FOREST;
        }
    }
    
}
