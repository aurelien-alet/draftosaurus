package draftosaurus.domain.utils;

import java.util.ArrayList;

public interface ListShuffler {
    public <T> ArrayList<T> shuffleRandomly(ArrayList<T> list);
}
