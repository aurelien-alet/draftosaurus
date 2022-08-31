package draftosaurus.domain.game;

import draftosaurus.domain.board.Biome;
import draftosaurus.domain.board.DinosauresDraw;
import draftosaurus.domain.board.PaddockAssignements;
import draftosaurus.domain.board.PaddockAttributes;
import draftosaurus.domain.board.Side;
import draftosaurus.domain.models.BoardGame;
import draftosaurus.domain.models.Draw;
import draftosaurus.domain.models.Paddock;
import draftosaurus.domain.models.Player;
import draftosaurus.domain.models.PlayerBoard;
import draftosaurus.domain.ports.GameSave;
import draftosaurus.domain.utils.ListShuffler;

public class Game {
    
    private Integer NUMBER_OF_DINOSAURES_BY_SPECY;
    private Integer NUMBER_OF_DINOSAURES_TO_DRAW;
    private ListShuffler listShuffler;
    private GameSave gameSave;
    private BoardGame boardGame;

    public Game(ListShuffler listShuffler, GameSave gameSave, GameProperties properties){
        this.listShuffler = listShuffler;
        this.gameSave = gameSave;
        NUMBER_OF_DINOSAURES_BY_SPECY = properties.getNumberOfDinosauresBySpecy();
        NUMBER_OF_DINOSAURES_TO_DRAW = properties.getNumberOfDinosauresToDraw();
    }

    public void start(){
        boardGame = new BoardGame();
        
        DinosauresDraw dinosauresDraw = new DinosauresDraw(listShuffler, NUMBER_OF_DINOSAURES_BY_SPECY);
        
        Player humanPlayer = instanciatePlayer(dinosauresDraw);
        boardGame.humanPlayer = humanPlayer;
        
        Player IAPlayer = instanciatePlayer(dinosauresDraw);
        boardGame.IAPlayer = IAPlayer;
        
        Draw draw = instanciateDraw(dinosauresDraw);
        boardGame.draw = draw;
    }

    public void save(){
        gameSave.save(boardGame);
    }

    public void load(){
        boardGame = gameSave.load();
    }

    public BoardGame getBoardGame(){
        return boardGame;
    }

    
    private Player instanciatePlayer(DinosauresDraw dinosauresDraw){
        Player player = new Player();
        
        player.dinosaures = dinosauresDraw.draw(NUMBER_OF_DINOSAURES_TO_DRAW);

        PlayerBoard playerBoard = instanciatePlayerBoard();
        player.board = playerBoard;

        return player;
    }

    private Draw instanciateDraw(DinosauresDraw dinosauresDraw){
        Draw draw = new Draw();
        draw.dinosaures = dinosauresDraw.getStock();
        return draw;
    }

    private PlayerBoard instanciatePlayerBoard(){
        PlayerBoard playerBoard = new PlayerBoard();

        playerBoard.similarsForestPaddock = instancianteSimilarsForestPaddock();
        playerBoard.woodTrioPaddock = instancianteWoodTrioPaddock();
        playerBoard.loveGrasslandPaddock = instancianteLoveGrasslandPaddock();
        playerBoard.jungleKingPaddock = instancianteJungleKingPaddock();
        playerBoard.differencesGrasslandPaddock = instancianteDifferencesGrasslandPaddock();
        playerBoard.lonelyIslandPaddock = instancianteLonelyIslandPaddock();

        return playerBoard;
    }

    private Paddock instancianteSimilarsForestPaddock(){
        Paddock paddock = new Paddock();

        paddock.assignements = new PaddockAssignements();
        paddock.attributes = new PaddockAttributes(Biome.FOREST, Side.CAFETERIA);

        return paddock;
    }

    private Paddock instancianteWoodTrioPaddock(){
        Paddock paddock = new Paddock();

        paddock.assignements = new PaddockAssignements();
        paddock.attributes = new PaddockAttributes(Biome.FOREST, Side.CAFETERIA);

        return paddock;
    }

    private Paddock instancianteLoveGrasslandPaddock(){
        Paddock paddock = new Paddock();

        paddock.assignements = new PaddockAssignements();
        paddock.attributes = new PaddockAttributes(Biome.GRASSLAND, Side.CAFETERIA);

        return paddock;
    }

    private Paddock instancianteJungleKingPaddock(){
        Paddock paddock = new Paddock();

        paddock.assignements = new PaddockAssignements();
        paddock.attributes = new PaddockAttributes(Biome.FOREST, Side.TOILET);

        return paddock;
    }

    private Paddock instancianteDifferencesGrasslandPaddock(){
        Paddock paddock = new Paddock();

        paddock.assignements = new PaddockAssignements();
        paddock.attributes = new PaddockAttributes(Biome.GRASSLAND, Side.TOILET);

        return paddock;
    }

    private Paddock instancianteLonelyIslandPaddock(){
        Paddock paddock = new Paddock();

        paddock.assignements = new PaddockAssignements();
        paddock.attributes = new PaddockAttributes(Biome.GRASSLAND, Side.TOILET);

        return paddock;
    }
}
