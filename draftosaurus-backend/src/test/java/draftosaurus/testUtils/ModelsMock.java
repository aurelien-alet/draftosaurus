package draftosaurus.testUtils;

import org.mockito.Mockito;

import draftosaurus.domain.models.BoardGame;

public class ModelsMock {
    
    public static BoardGame instanciateBoardGameMock(){
        return Mockito.mock(BoardGame.class);
    } 

}
