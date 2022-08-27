package draftosaurus.domain.board;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PaddockTest extends TestCase {

    public PaddockTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( PaddockTest.class );
    }

    public void testShouldInstanciateForestToiletSidePaddock() {
        Biome expectedBiome = Biome.FOREST;
        Side expectedSide = Side.TOILET;

        Paddock paddock = instanciatePaddock(expectedBiome, expectedSide);
       
        Biome actualBiome = paddock.getBiome();
        Side actualSide = paddock.getSide();
        assertEquals(expectedBiome, actualBiome);
        assertEquals(expectedSide, actualSide);
    }

    public void testShouldInstanciateForestCafeteriaSidePaddock() {
        Biome expectedBiome = Biome.FOREST;
        Side expectedSide = Side.CAFETERIA;

        Paddock paddock = instanciatePaddock(expectedBiome, expectedSide);
       
        Biome actualBiome = paddock.getBiome();
        Side actualSide = paddock.getSide();
        assertEquals(expectedBiome, actualBiome);
        assertEquals(expectedSide, actualSide);
    }

    public void testShouldInstanciateGrasslandToiletSidePaddock() {
        Biome expectedBiome = Biome.GRASSLAND;
        Side expectedSide = Side.TOILET;

        Paddock paddock = instanciatePaddock(expectedBiome, expectedSide);
       
        Biome actualBiome = paddock.getBiome();
        Side actualSide = paddock.getSide();
        assertEquals(expectedBiome, actualBiome);
        assertEquals(expectedSide, actualSide);
    }

    public void testShouldInstanciateGrasslandCafeteriaSidePaddock() {
        Biome expectedBiome = Biome.GRASSLAND;
        Side expectedSide = Side.CAFETERIA;

        Paddock paddock = instanciatePaddock(expectedBiome, expectedSide);
       
        Biome actualBiome = paddock.getBiome();
        Side actualSide = paddock.getSide();
        assertEquals(expectedBiome, actualBiome);
        assertEquals(expectedSide, actualSide);
    }

    public void testShouldInstanciateRiverPaddock() {
        Biome expectedBiome = Biome.RIVER;
        Side expectedSide = Side.RIVER;

        Paddock paddock = instanciatePaddock(expectedBiome, expectedSide);
       
        Biome actualBiome = paddock.getBiome();
        Side actualSide = paddock.getSide();
        assertEquals(expectedBiome, actualBiome);
        assertEquals(expectedSide, actualSide);
    }

    private Paddock instanciatePaddock(Biome biome, Side side){
        return new Paddock(biome, side);
    }

}
