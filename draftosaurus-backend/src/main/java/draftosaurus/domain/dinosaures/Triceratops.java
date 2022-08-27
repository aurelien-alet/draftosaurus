package draftosaurus.domain.dinosaures;

public class Triceratops extends Dinosaure {
 
    public static final Integer score = 0;
    public static final Specy specy = Specy.TRICERATOPS;

    public Triceratops() {
        super();
    }

    @Override
    public Specy getSpecy() {
        return specy;
    }
}
