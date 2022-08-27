package draftosaurus.domain.dinosaures;

public class Parasaurolophus extends Dinosaure {
 
    public static final Integer score = 0;
    public static final Specy specy = Specy.PARASAUROLOPHUS;

    public Parasaurolophus() {
        super();
    }

    @Override
    public Specy getSpecy() {
        return specy;
    }
}
