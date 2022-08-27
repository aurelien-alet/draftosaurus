package draftosaurus.testUtils;

import static org.mockito.ArgumentMatchers.any;

import org.mockito.Mockito;
import org.javatuples.Pair;

import draftosaurus.domain.board.Biome;
import draftosaurus.domain.board.Paddock;
import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.board.Side;
import draftosaurus.domain.dinosaures.Specy;

public class BoardMock {

    public static Paddock instanciatePaddock(){
        return Mockito.mock(Paddock.class);
    }

    public static Paddock instanciatePaddockWithAttributes(Side side, Biome biome){     
        Paddock paddockMock =  Mockito.mock(Paddock.class);

        Mockito.when(paddockMock.getSide()).thenReturn(side);
        Mockito.when(paddockMock.getBiome()).thenReturn(biome);

        return paddockMock;
    }

    public static PaddockAssignements instanciatePaddockAssignementsMock(){
        PaddockAssignements paddockAssignementsMock = Mockito.mock(PaddockAssignements.class);
        
        Mockito.when(paddockAssignementsMock.numberOfAssignedDinosaures()).thenReturn(0);
        Mockito.when(paddockAssignementsMock.numberOfAssignedSpecy((Specy) any())).thenReturn(0);
    
        return paddockAssignementsMock;
    }

    @SafeVarargs
    public static PaddockAssignements instanciatePaddockAssignementsWithDinosauresMock(
        Pair<Integer, Specy>... speciesInstances
    ){
        PaddockAssignements paddockAssignementsMock = Mockito.mock(PaddockAssignements.class);
        
        Integer totalNumberDinosaures = getTotalDinosauresForMock(speciesInstances);
        Mockito.when(paddockAssignementsMock.numberOfAssignedDinosaures()).thenReturn(totalNumberDinosaures);
        Mockito.when(paddockAssignementsMock.numberOfAssignedSpecy((Specy) any())).thenReturn(0);
        mockNumberOfAssignedSpecyReturn(paddockAssignementsMock, speciesInstances);
    
        return paddockAssignementsMock;
    }

    @SafeVarargs
    private static Integer getTotalDinosauresForMock(Pair<Integer, Specy>... speciesInstances){
        Integer total = 0;
        for(Pair<Integer, Specy> speciesInstance: speciesInstances){
            total += (Integer) speciesInstance.getValue(0);
        }
        return total;
    }

    @SafeVarargs
    private static void mockNumberOfAssignedSpecyReturn(
        PaddockAssignements paddockAssignementsMock, Pair<Integer, Specy>... speciesInstances
    ){
        Integer specyNumber;
        Specy specy;
        for(Pair<Integer, Specy> speciesInstance: speciesInstances){
            specyNumber = (Integer) speciesInstance.getValue(0);
            specy = (Specy) speciesInstance.getValue(1);
            Mockito.when(paddockAssignementsMock.numberOfAssignedSpecy(specy)).thenReturn(specyNumber);
        }
    }
}
