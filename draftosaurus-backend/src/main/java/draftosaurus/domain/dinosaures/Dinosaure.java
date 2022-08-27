package draftosaurus.domain.dinosaures;

public abstract class Dinosaure {
    static Integer score = -1;
    static Specy specy = Specy.GENERIC;
   
    public Dinosaure(){
    }

    public abstract Specy getSpecy();
}