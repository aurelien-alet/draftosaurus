package draftosaurus.domain.board;

public class Paddock {
    
    private Side side;
    private Biome biome;

    public Paddock(Biome biome, Side side){
        this.biome = biome;
        this.side= side;
    }

    public Biome getBiome() {
        return biome;
    }

    public Side getSide() {
        return side;
    }

}
