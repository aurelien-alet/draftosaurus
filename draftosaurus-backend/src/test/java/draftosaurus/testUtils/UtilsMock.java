package draftosaurus.testUtils;

import java.util.ArrayList;

import draftosaurus.domain.game.GameProperties;
import draftosaurus.domain.utils.ListShuffler;

public class UtilsMock {
    
    public static ListShufflerIdentityMock instanciateListShufflerIdentityMock() {
        return new ListShufflerIdentityMock();
    }

    public static ListShufflerExchageTwoFirstsMock instanciateListShufflerExchageTwoFirstsMock() {
        return new ListShufflerExchageTwoFirstsMock();
    }

    public static GamePropertiesMock instanciateGamePropertiesMock() {
        return new GamePropertiesMock();
    }

    private static class ListShufflerIdentityMock implements ListShuffler {

        public <T> ArrayList<T> shuffleRandomly(ArrayList<T> list){
            return list;
        }

    }

    private static class ListShufflerExchageTwoFirstsMock implements ListShuffler {

        public <T> ArrayList<T> shuffleRandomly(ArrayList<T> list){
            T element0 = list.get(0);
            T element1 = list.get(1);
            
            list.set(0, element1);
            list.set(1, element0);
            
            return list;
        }

    }

    private static class GamePropertiesMock implements GameProperties {

        @Override
        public Integer getNumberOfDinosauresBySpecy() {
            return 10;
        }

        @Override
        public Integer getNumberOfDinosauresToDraw() {
            return 6;
        }
    }

}
