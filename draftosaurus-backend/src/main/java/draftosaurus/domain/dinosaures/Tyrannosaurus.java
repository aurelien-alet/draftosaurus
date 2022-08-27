package draftosaurus.domain.dinosaures;

public class Tyrannosaurus extends Dinosaure {
 
    public static final Integer score = 1;
    public static final Specy specy = Specy.TYRANNOSAURUS;

    public Tyrannosaurus() {
        super();
    }

    @Override
    public Specy getSpecy() {
        return specy;
    }
}
