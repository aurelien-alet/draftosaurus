package draftosaurus.domain.board;

import java.util.ArrayList;

import draftosaurus.domain.dinosaures.Specy;
import draftosaurus.domain.dinosaures.Dinosaure;

public class PaddockAssignements {
    
    private ArrayList<Dinosaure> assignedDinosaures = new ArrayList<Dinosaure>();

    public PaddockAssignements() {
    }

    public void assignDinosaure(Dinosaure dinosaure){
        assignedDinosaures.add(dinosaure);
    }

    public ArrayList<Dinosaure> getAssignedDinosaures(){
        return assignedDinosaures;
    }

    public Integer numberOfAssignedDinosaures(){
        return assignedDinosaures.size();
    }

    public Integer numberOfAssignedSpecy(Specy specy){
        Integer number = 0;
        for(Dinosaure dinosaure: assignedDinosaures){
            if(dinosaure.getSpecy() == specy){
                number += 1;
            }
        }
        return number;
    }
}
