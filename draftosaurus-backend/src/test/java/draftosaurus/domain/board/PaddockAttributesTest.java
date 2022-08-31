package draftosaurus.domain.board;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PaddockAttributesTest extends TestCase {

    public PaddockAttributesTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( PaddockAttributesTest.class );
    }

    public void testShouldInstanciateForestToiletSidePaddock() {
        Biome expectedBiome = Biome.FOREST;
        Side expectedSide = Side.TOILET;

        PaddockAttributes paddock = instanciatePaddock(expectedBiome, expectedSide);
       
        Biome actualBiome = paddock.getBiome();
        Side actualSide = paddock.getSide();
        assertEquals(expectedBiome, actualBiome);
        assertEquals(expectedSide, actualSide);
    }

    public void testShouldInstanciateForestCafeteriaSidePaddock() {
        Biome expectedBiome = Biome.FOREST;
        Side expectedSide = Side.CAFETERIA;

        PaddockAttributes paddock = instanciatePaddock(expectedBiome, expectedSide);
       
        Biome actualBiome = paddock.getBiome();
        Side actualSide = paddock.getSide();
        assertEquals(expectedBiome, actualBiome);
        assertEquals(expectedSide, actualSide);
    }

    public void testShouldInstanciateGrasslandToiletSidePaddock() {
        Biome expectedBiome = Biome.GRASSLAND;
        Side expectedSide = Side.TOILET;

        PaddockAttributes paddock = instanciatePaddock(expectedBiome, expectedSide);
       
        Biome actualBiome = paddock.getBiome();
        Side actualSide = paddock.getSide();
        assertEquals(expectedBiome, actualBiome);
        assertEquals(expectedSide, actualSide);
    }

    public void testShouldInstanciateGrasslandCafeteriaSidePaddock() {
        Biome expectedBiome = Biome.GRASSLAND;
        Side expectedSide = Side.CAFETERIA;

        PaddockAttributes paddock = instanciatePaddock(expectedBiome, expectedSide);
       
        Biome actualBiome = paddock.getBiome();
        Side actualSide = paddock.getSide();
        assertEquals(expectedBiome, actualBiome);
        assertEquals(expectedSide, actualSide);
    }

    public void testShouldInstanciateRiverPaddock() {
        Biome expectedBiome = Biome.RIVER;
        Side expectedSide = Side.RIVER;

        PaddockAttributes paddock = instanciatePaddock(expectedBiome, expectedSide);
       
        Biome actualBiome = paddock.getBiome();
        Side actualSide = paddock.getSide();
        assertEquals(expectedBiome, actualBiome);
        assertEquals(expectedSide, actualSide);
    }

    private PaddockAttributes instanciatePaddock(Biome biome, Side side){
        return new PaddockAttributes(biome, side);
    }

}
