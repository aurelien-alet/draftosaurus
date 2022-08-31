package draftosaurus.domain.board;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

import draftosaurus.domain.dinosaures.Dinosaure;
import draftosaurus.domain.dinosaures.Specy;
import draftosaurus.domain.exceptions.EmptyStockException;
import draftosaurus.domain.utils.ListShuffler;
import draftosaurus.testUtils.UtilsMock;

public class DinosauresDrawTest extends TestCase {

    public DinosauresDrawTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( DinosauresDrawTest.class );
    }

    public void testDinosauresStockShouldBeInstanciatedWithAllDinosauresSpecies() {
        int ignoreGenericSize = 1;
        int numberOfSpecies = 6;
        DinosauresDraw dinosauresDraw = instanciateDinosauresDrawWithIdentityShuffler(1);
        
        ArrayList<Dinosaure> dinosauresInStock = dinosauresDraw.draw(numberOfSpecies);

        assertEquals(numberOfSpecies, Specy.values().length - ignoreGenericSize);
        assertEquals(Specy.DIPLODOCUS, dinosauresInStock.get(0).getSpecy());
        assertEquals(Specy.PARASAUROLOPHUS, dinosauresInStock.get(1).getSpecy());
        assertEquals(Specy.SPINOSAURUS, dinosauresInStock.get(2).getSpecy());
        assertEquals(Specy.STEGOSAURUS, dinosauresInStock.get(3).getSpecy());
        assertEquals(Specy.TRICERATOPS, dinosauresInStock.get(4).getSpecy());
        assertEquals(Specy.TYRANNOSAURUS, dinosauresInStock.get(5).getSpecy());
    }

    public void testDinosauresStockShouldBeInstanciatedWithTwoOfEachDinosauresSpecies() {
        DinosauresDraw dinosauresDraw = instanciateDinosauresDrawWithIdentityShuffler(2);
        
        ArrayList<Dinosaure> dinosauresInStock = dinosauresDraw.draw(12);

        assertEquals(Specy.DIPLODOCUS, dinosauresInStock.get(0).getSpecy());
        assertEquals(Specy.DIPLODOCUS, dinosauresInStock.get(6).getSpecy());
        assertEquals(Specy.PARASAUROLOPHUS, dinosauresInStock.get(1).getSpecy());
        assertEquals(Specy.PARASAUROLOPHUS, dinosauresInStock.get(7).getSpecy());
    }

    public void testInstanciatedDinosaureStockShouldBeShuffled() {
        DinosauresDraw dinosauresDraw = instanciateDinosauresDrawWithExchageTwoFirstsSuhffler(1);
  
        ArrayList<Dinosaure> dinosauresInStock = dinosauresDraw.draw(2);

        assertEquals(Specy.PARASAUROLOPHUS, dinosauresInStock.get(0).getSpecy());
        assertEquals(Specy.DIPLODOCUS, dinosauresInStock.get(1).getSpecy());
    }

    public void testSeveralDrawInARowShouldReturnDinosauresInTheRightOrder() {
        int numberToDraw = 2;
        DinosauresDraw dinosauresDraw = instanciateDinosauresDrawWithIdentityShuffler(1);

        ArrayList<Dinosaure> draw0 = dinosauresDraw.draw(numberToDraw);
        ArrayList<Dinosaure> draw1 = dinosauresDraw.draw(numberToDraw);
        ArrayList<Dinosaure> draw2 = dinosauresDraw.draw(numberToDraw);

        assertEquals(numberToDraw, draw0.size());
        assertEquals(Specy.DIPLODOCUS, draw0.get(0).getSpecy());
        assertEquals(Specy.PARASAUROLOPHUS, draw0.get(1).getSpecy());
        assertEquals(numberToDraw, draw1.size());
        assertEquals(Specy.SPINOSAURUS, draw1.get(0).getSpecy());
        assertEquals(Specy.STEGOSAURUS, draw1.get(1).getSpecy());
        assertEquals(numberToDraw, draw2.size());
        assertEquals(Specy.TRICERATOPS, draw2.get(0).getSpecy());
        assertEquals(Specy.TYRANNOSAURUS, draw2.get(1).getSpecy());
    }

    public void testDrawShouldReturnAnExceptionIfNotEnoughtDinosauresInStock() {
        String expectedMessage = "Not enought dinosaures left in stock : 6";
        
        DinosauresDraw dinosauresDraw = instanciateDinosauresDrawWithIdentityShuffler(1);

        try {
            dinosauresDraw.draw(7);
            fail( "Missing EmptyStockException exception" );
       } catch( EmptyStockException e ) {
            assertEquals( expectedMessage, e.getMessage() ); 
       }

    }

    public void testShouldGetStock() {
        DinosauresDraw dinosauresDraw = instanciateDinosauresDrawWithIdentityShuffler(1);
        
        ArrayList<Dinosaure> stock = dinosauresDraw.getStock();

        assertEquals(Specy.DIPLODOCUS, stock.get(0).getSpecy());
        assertEquals(Specy.PARASAUROLOPHUS, stock.get(1).getSpecy());
        assertEquals(Specy.SPINOSAURUS, stock.get(2).getSpecy());
        assertEquals(Specy.STEGOSAURUS, stock.get(3).getSpecy());
        assertEquals(Specy.TRICERATOPS, stock.get(4).getSpecy());
        assertEquals(Specy.TYRANNOSAURUS, stock.get(5).getSpecy());
    }

    private DinosauresDraw instanciateDinosauresDrawWithIdentityShuffler(Integer numberOfDinosaureBySpecy){
        ListShuffler listShuffler = UtilsMock.instanciateListShufflerIdentityMock();
        
        return new DinosauresDraw(listShuffler, numberOfDinosaureBySpecy);
    }

    private DinosauresDraw instanciateDinosauresDrawWithExchageTwoFirstsSuhffler(Integer numberOfDinosaureBySpecy){
        ListShuffler listShuffler = UtilsMock.instanciateListShufflerExchageTwoFirstsMock();
        
        return new DinosauresDraw(listShuffler, numberOfDinosaureBySpecy);
    }

}
