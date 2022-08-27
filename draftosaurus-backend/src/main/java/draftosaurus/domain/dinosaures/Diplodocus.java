package draftosaurus.domain.dinosaures;

public class Diplodocus extends Dinosaure {
 
    public static final Integer score = 0;
    public static final Specy specy = Specy.DIPLODOCUS;

    public Diplodocus() {
        super();
    }

    @Override
    public Specy getSpecy() {
        return specy;
    }
}
