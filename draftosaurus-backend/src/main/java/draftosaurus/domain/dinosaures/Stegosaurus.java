package draftosaurus.domain.dinosaures;

public class Stegosaurus extends Dinosaure {
 
    public static final Integer score = 0;
    public static final Specy specy = Specy.STEGOSAURUS;

    public Stegosaurus() {
        super();
    }

    @Override
    public Specy getSpecy() {
        return specy;
    }
}
