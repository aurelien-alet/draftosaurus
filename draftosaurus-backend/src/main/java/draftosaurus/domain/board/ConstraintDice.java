package draftosaurus.domain.board;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import draftosaurus.domain.utils.IntGenerator;

public class ConstraintDice {

    private IntGenerator intGenerator;
    private static final List<ConstraintDiceFace> FACES = Collections.unmodifiableList(
        Arrays.asList(ConstraintDiceFace.values())
    );
    private static final Integer FACES_NUMBER = FACES.size();

    public ConstraintDice(IntGenerator intGenerator){
        this.intGenerator = intGenerator;
    }

    public ConstraintDiceFace roll()  {
        Integer randomlySelectedInt = intGenerator.pickNumberBetweenAInclusiveAndBExclusive(0, FACES_NUMBER);
        ConstraintDiceFace randomlySelectedFace = FACES.get(randomlySelectedInt);
        return randomlySelectedFace;
    }
}
