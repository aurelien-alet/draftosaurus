package draftosaurus.testUtils;

import org.mockito.Mockito;

import draftosaurus.domain.dinosaures.Dinosaure;
import draftosaurus.domain.dinosaures.Specy;

public class DinosaureMock {
    
    public static Dinosaure instanciateDinosaureMock(){
        return Mockito.mock(Dinosaure.class);
    } 

    public static <T extends Dinosaure> T instanciateDinosaureSpecyMock(
        Class<T> dinosaureSpecyClass
    ){

        Specy value = Utils.getStaticFieldValueFromGenericClass(dinosaureSpecyClass, Specy.class);

        T dinosaureMock = Mockito.mock(dinosaureSpecyClass);
        Mockito.when(dinosaureMock.getSpecy()).thenReturn(value);
        return dinosaureMock;

    }
 
}
