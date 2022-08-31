package draftosaurus.testUtils;

import org.mockito.Mockito;

import draftosaurus.domain.ports.GameSave;

public class AdaptersMock {
    
    public static GameSave instanciateGameSaveMock(){
        return Mockito.mock(GameSave.class);
    }

}
