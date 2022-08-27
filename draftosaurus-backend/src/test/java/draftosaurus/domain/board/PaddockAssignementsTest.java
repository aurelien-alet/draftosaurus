package draftosaurus.domain.board;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Arrays;

import java.util.ArrayList;

import draftosaurus.testUtils.DinosaureMock;
import draftosaurus.domain.dinosaures.Dinosaure;
import draftosaurus.domain.dinosaures.Diplodocus;
import draftosaurus.domain.dinosaures.Parasaurolophus;
import draftosaurus.domain.dinosaures.Specy;
import draftosaurus.domain.dinosaures.Spinosaurus;
import draftosaurus.domain.dinosaures.Stegosaurus;
import draftosaurus.domain.dinosaures.Triceratops;
import draftosaurus.domain.dinosaures.Tyrannosaurus;

public class PaddockAssignementsTest extends TestCase {

    public PaddockAssignementsTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( PaddockAssignementsTest.class );
    }

    public void testUnchangedPaddockAssignementsShouldNotHaveDinosaures() {
        ArrayList<Dinosaure> expectedDinosaures = new ArrayList<Dinosaure>();
        
        PaddockAssignements paddockAssignements = instanciatePaddockAssignements();

        ArrayList<Dinosaure> actualDinosaures = paddockAssignements.getAssignedDinosaures(); 
        assertEquals(expectedDinosaures, actualDinosaures);
    }

    public void testAssignDinosaureToPaddock() {
        Dinosaure expectedDinosaure = DinosaureMock.instanciateDinosaureMock();
        PaddockAssignements paddockAssignements = instanciatePaddockAssignements();

        paddockAssignements.assignDinosaure(expectedDinosaure);

        ArrayList<Dinosaure> actualDinosaures = paddockAssignements.getAssignedDinosaures();
        assertEquals(1, actualDinosaures.size());
        assertEquals(expectedDinosaure, actualDinosaures.get(0));
    }

    public void testShouldReturnAllAssignedDinosaures() {
        Dinosaure firstDinosaure = DinosaureMock.instanciateDinosaureMock();
        Dinosaure secondDinosaure = DinosaureMock.instanciateDinosaureMock();
        ArrayList<Dinosaure> expectedDinosaures = new ArrayList<Dinosaure>(
            Arrays.asList(firstDinosaure, secondDinosaure)
        );

        PaddockAssignements paddockAssignements = instanciatePaddockAssignementsWithDinosaures(
            firstDinosaure,
            secondDinosaure
        );

        ArrayList<Dinosaure> actualDinosaures = paddockAssignements.getAssignedDinosaures(); 
        assertEquals(expectedDinosaures, actualDinosaures);
    }

    public void testUnchangedPaddockAssignementsShouldHaveNoAssignement() {
        Integer expectedNumber = 0;
        
        PaddockAssignements paddockAssignements = instanciatePaddockAssignements();

        Integer actualNumber = paddockAssignements.numberOfAssignedDinosaures();
        assertEquals(expectedNumber, actualNumber);
    }

    public void testPaddockWithTwoAssignedDinosauresShouldReturnTwo() {
        Integer expectedNumber = 2;
        Dinosaure firstDinosaureInPaddock = DinosaureMock.instanciateDinosaureMock();
        Dinosaure secondDinosaureInPaddock = DinosaureMock.instanciateDinosaureMock();

        PaddockAssignements paddockAssignements = instanciatePaddockAssignementsWithDinosaures(
            firstDinosaureInPaddock,
            secondDinosaureInPaddock
        );

        Integer actualNumber = paddockAssignements.numberOfAssignedDinosaures();
        assertEquals(expectedNumber, actualNumber);
    }

    public void testUnchangedPaddockShlouldHaveAllAssignedSpecyToZero(){
        Integer expectedAssignedNumberSpecy = 0;

        PaddockAssignements paddockAssignements = instanciatePaddockAssignements();

        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.DIPLODOCUS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.PARASAUROLOPHUS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.SPINOSAURUS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.STEGOSAURUS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.TRICERATOPS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.TYRANNOSAURUS));
    }

    public void testTyrannosorusPaddockShouldHaveOneTyrannosorusAssigned(){
        Integer expectedAssignedNumberSpecy = 1;
        Tyrannosaurus dinosaureInPaddock = DinosaureMock.instanciateDinosaureSpecyMock(Tyrannosaurus.class);
        
        PaddockAssignements paddockAssignements = instanciatePaddockAssignementsWithDinosaures(dinosaureInPaddock);

        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.TYRANNOSAURUS));
    }

    public void testTyrannosorusPaddockShouldNotHaveOtherSpeciesAssigned(){
        Integer expectedAssignedNumberSpecy = 0;
        Tyrannosaurus dinosaureInPaddock = DinosaureMock.instanciateDinosaureSpecyMock(Tyrannosaurus.class);
        
        PaddockAssignements paddockAssignements = instanciatePaddockAssignementsWithDinosaures(dinosaureInPaddock);

        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.DIPLODOCUS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.PARASAUROLOPHUS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.SPINOSAURUS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.STEGOSAURUS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.TRICERATOPS));
    }

    public void testMultiTyrannosorusPaddockShouldHaveThreeTyrannosorusAssigned(){
        Integer expectedAssignedNumberSpecy = 3;
        Tyrannosaurus tyrannosaurus1 = DinosaureMock.instanciateDinosaureSpecyMock(Tyrannosaurus.class);
        Tyrannosaurus tyrannosaurus2 = DinosaureMock.instanciateDinosaureSpecyMock(Tyrannosaurus.class);
        Tyrannosaurus tyrannosaurus3 = DinosaureMock.instanciateDinosaureSpecyMock(Tyrannosaurus.class);
        
        PaddockAssignements paddockAssignements = instanciatePaddockAssignementsWithDinosaures(
            tyrannosaurus1,
            tyrannosaurus2,
            tyrannosaurus3
        );

        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.TYRANNOSAURUS));
    }

    public void testFullDinosauresPaddockShouldHaveAllDinosauresAssigned(){
        Integer expectedAssignedNumberSpecy = 1;
        Diplodocus diplodocusInPaddock = DinosaureMock.instanciateDinosaureSpecyMock(Diplodocus.class);
        Parasaurolophus parasaurolophusInPaddock = DinosaureMock.instanciateDinosaureSpecyMock(Parasaurolophus.class);
        Spinosaurus spinosaurusInPaddock = DinosaureMock.instanciateDinosaureSpecyMock(Spinosaurus.class);
        Stegosaurus stegosaurusInPaddock = DinosaureMock.instanciateDinosaureSpecyMock(Stegosaurus.class);
        Triceratops triceratopsInPaddock = DinosaureMock.instanciateDinosaureSpecyMock(Triceratops.class);
        Tyrannosaurus tyrannosaurusInPaddock = DinosaureMock.instanciateDinosaureSpecyMock(Tyrannosaurus.class);
        
        PaddockAssignements paddockAssignements = instanciatePaddockAssignementsWithDinosaures(
            diplodocusInPaddock,
            parasaurolophusInPaddock,
            spinosaurusInPaddock,
            stegosaurusInPaddock,
            triceratopsInPaddock,
            tyrannosaurusInPaddock
        );

        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.DIPLODOCUS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.PARASAUROLOPHUS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.SPINOSAURUS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.STEGOSAURUS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.TRICERATOPS));
        assertEquals(expectedAssignedNumberSpecy, paddockAssignements.numberOfAssignedSpecy(Specy.TYRANNOSAURUS));
    }

    private PaddockAssignements instanciatePaddockAssignements(){
        return new PaddockAssignements();
    }

    private PaddockAssignements instanciatePaddockAssignementsWithDinosaures(Dinosaure... dinosaures){
        PaddockAssignements paddockAssignements = new PaddockAssignements();
        
        for (Dinosaure dinosaure : dinosaures) {
            paddockAssignements.assignDinosaure(dinosaure);
        }

        return paddockAssignements;
    }

}
