package draftosaurus.domain.dinosaures;

public class Spinosaurus extends Dinosaure {
 
    public static final Integer score = 0;
    public static final Specy specy = Specy.SPINOSAURUS;

    public Spinosaurus() {
        super();
    }

    @Override
    public Specy getSpecy() {
        return specy;
    }
}
