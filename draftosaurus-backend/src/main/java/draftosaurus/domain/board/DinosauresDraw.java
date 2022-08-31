package draftosaurus.domain.board;

import java.util.ArrayList;

import draftosaurus.domain.dinosaures.Dinosaure;
import draftosaurus.domain.dinosaures.Diplodocus;
import draftosaurus.domain.dinosaures.Parasaurolophus;
import draftosaurus.domain.dinosaures.Spinosaurus;
import draftosaurus.domain.dinosaures.Stegosaurus;
import draftosaurus.domain.dinosaures.Triceratops;
import draftosaurus.domain.dinosaures.Tyrannosaurus;
import draftosaurus.domain.exceptions.EmptyStockException;
import draftosaurus.domain.utils.ListShuffler;

public class DinosauresDraw {
    
    private ListShuffler listShuffler;
    private ArrayList<Dinosaure> stock;

    public DinosauresDraw(ListShuffler listShuffler, Integer numberOfDinosaureBySpecy){
        this.listShuffler = listShuffler;
        instanciateStock(numberOfDinosaureBySpecy);
        shuffleStock();
    }

    public ArrayList<Dinosaure> draw( Integer numberToDraw ){
        Integer stockSize = stock.size();
        
        throwExceptionIfNotEnoughtDinosaureInStock(stockSize, numberToDraw);
        
        ArrayList<Dinosaure> drawResult =  catchAboveStockDinosaures(numberToDraw);
        removeAboveStockDinosaures(numberToDraw);
        return drawResult;
    }

    public ArrayList<Dinosaure> getStock(){
        return stock;
    }

    private void instanciateStock(Integer numberOfDinosaureBySpecy){
        stock = new ArrayList<Dinosaure>();
        for( Integer i = 0; i < numberOfDinosaureBySpecy; i++ ){
            stock.add(new Diplodocus());
            stock.add(new Parasaurolophus());
            stock.add(new Spinosaurus());
            stock.add(new Stegosaurus());
            stock.add(new Triceratops());
            stock.add(new Tyrannosaurus());
        }
    }

    private void shuffleStock(){
        stock = listShuffler.shuffleRandomly(stock);
    }

    private static void throwExceptionIfNotEnoughtDinosaureInStock(Integer stockSize, Integer numberToDraw){
        if( numberToDraw > stockSize ){
            throw new EmptyStockException("Not enought dinosaures left in stock : " + stockSize);
        }
    }

    private ArrayList<Dinosaure> catchAboveStockDinosaures(Integer numberOfDinosaures){
        return new ArrayList<Dinosaure>(stock.subList(0, numberOfDinosaures));
    }

    private void removeAboveStockDinosaures(Integer numberOfDinosaures){
        stock = new ArrayList<Dinosaure>(stock.subList(numberOfDinosaures, stock.size()));
    }
}
