package draftosaurus.domain.ports;

import draftosaurus.domain.models.BoardGame;

public interface GameSave {
    public void save(BoardGame boardGame);
    public BoardGame load();
}
