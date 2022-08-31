package draftosaurus.domain.movesCheckers;

import draftosaurus.domain.board.Biome;
import draftosaurus.domain.board.PaddockAttributes;
import draftosaurus.domain.board.PaddockAssignements;

public class ConstraintCheckerGrassland extends ConstraintChecker {

    private static Biome expectedBiome = Biome.GRASSLAND;
    private static boolean CAN_ASSIGN_AS_BIOME_IS_GRASSLAND = true;
    private static boolean CANNOT_ASSIGN_AS_BIOME_IS_NOT_GRASSLAND = false;

    public ConstraintCheckerGrassland(PaddockAttributes paddock, PaddockAssignements paddockAssignements) {
        super(paddock, paddockAssignements);
    }

    @Override
    public boolean isPaddockAssignable() {
        if(paddock.getBiome() == expectedBiome ){
            return CAN_ASSIGN_AS_BIOME_IS_GRASSLAND;
        } else {
            return CANNOT_ASSIGN_AS_BIOME_IS_NOT_GRASSLAND;
        }
    }
    
}
