package draftosaurus.domain.game;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.Mockito;

import draftosaurus.domain.board.Biome;
import draftosaurus.domain.board.Side;
import draftosaurus.domain.models.BoardGame;
import draftosaurus.domain.models.Draw;
import draftosaurus.domain.models.Player;
import draftosaurus.domain.models.PlayerBoard;
import draftosaurus.domain.ports.GameSave;
import draftosaurus.domain.utils.ListShuffler;
import draftosaurus.testUtils.AdaptersMock;
import draftosaurus.testUtils.ModelsMock;
import draftosaurus.testUtils.UtilsMock;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GameTest extends TestCase {
    
    public GameTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( GameTest.class );
    }

    public void testGameStartShouldInstanciateBoardGame() {
        Game game = instanciateGame();

        game.start();
        
        assertNotNull(game.getBoardGame());
    }

    public void testGameStartShouldInstanciatePlayers() {
        Game game = instanciateGame();

        game.start();
        
        BoardGame boardGame = game.getBoardGame();
        assertNotNull(boardGame.humanPlayer);
        assertNotNull(boardGame.IAPlayer);
    }

    public void testGameStartShouldInstanciateDraw() {
        Game game = instanciateGame();

        game.start();
        
        Draw draw = getDrawFromGame(game);
        assertNotNull(draw);
    }

    public void testGameStartShouldInstanciateDinosauresInDraw() {
        int expectedNumberOfDinosauresInDraw = 48;
        Game game = instanciateGame();

        game.start();
        
        Draw draw = getDrawFromGame(game);
        assertEquals(expectedNumberOfDinosauresInDraw, draw.dinosaures.size());
    }

    public void testGameStartShouldInstanciateHumanPlayer() {
        Game game = instanciateGame();

        game.start();
        
        Player humanPlayer = getHumanPlayerFromGame(game);
        assertNotNull(humanPlayer);
    }

    public void testGameStartShouldInstanciateIAPlayer() {
        Game game = instanciateGame();

        game.start();
        
        Player IAPlayer = getIAPlayerFromGame(game);
        assertNotNull(IAPlayer);
    }

    public void testGameStartShouldInstanciateHumanPlayerDinosaures() {
        int expectedNumberOfDinosaures = 6;
        Game game = instanciateGame();

        game.start();
        
        Player humanPlayer = getHumanPlayerFromGame(game);
        assertEquals(expectedNumberOfDinosaures, humanPlayer.dinosaures.size());
    }

    public void testGameStartShouldInstanciateIAPlayerDinosaures() {
        int expectedNumberOfDinosaures = 6;
        Game game = instanciateGame();

        game.start();
        
        Player IAPlayer = getIAPlayerFromGame(game);
        assertEquals(expectedNumberOfDinosaures, IAPlayer.dinosaures.size());
    }

    public void testGameStartShouldInstanciateHumanPlayerBoard() {
        Game game = instanciateGame();

        game.start();
        
        PlayerBoard humanPlayerBoard = getHumanPlayerBoardFromGame(game);
        assertNotNull(humanPlayerBoard);
    }

    public void testGameStartShouldInstanciateIAPlayerBoard() {
        Game game = instanciateGame();

        game.start();
        
        PlayerBoard IAPlayerBoard = getIAPlayerBoardFromGame(game);
        assertNotNull(IAPlayerBoard);
    }

    public void testGameStartShouldInstanciateHumanPlayerBoardPaddocks() {
        Game game = instanciateGame();

        game.start();
        
        PlayerBoard humanPlayerBoard = getHumanPlayerBoardFromGame(game);
        
        assertNotNull(humanPlayerBoard.similarsForestPaddock);
        assertEquals(Side.CAFETERIA, humanPlayerBoard.similarsForestPaddock.attributes.getSide());
        assertEquals(Biome.FOREST, humanPlayerBoard.similarsForestPaddock.attributes.getBiome());
        
        assertNotNull(humanPlayerBoard.woodTrioPaddock);
        assertEquals(Side.CAFETERIA, humanPlayerBoard.woodTrioPaddock.attributes.getSide());
        assertEquals(Biome.FOREST, humanPlayerBoard.woodTrioPaddock.attributes.getBiome());
        
        assertNotNull(humanPlayerBoard.loveGrasslandPaddock);
        assertEquals(Side.CAFETERIA, humanPlayerBoard.loveGrasslandPaddock.attributes.getSide());
        assertEquals(Biome.GRASSLAND, humanPlayerBoard.loveGrasslandPaddock.attributes.getBiome());
        
        assertNotNull(humanPlayerBoard.jungleKingPaddock);
        assertEquals(Side.TOILET, humanPlayerBoard.jungleKingPaddock.attributes.getSide());
        assertEquals(Biome.FOREST, humanPlayerBoard.jungleKingPaddock.attributes.getBiome());
        
        assertNotNull(humanPlayerBoard.differencesGrasslandPaddock);
        assertEquals(Side.TOILET, humanPlayerBoard.differencesGrasslandPaddock.attributes.getSide());
        assertEquals(Biome.GRASSLAND, humanPlayerBoard.differencesGrasslandPaddock.attributes.getBiome());
        
        assertNotNull(humanPlayerBoard.lonelyIslandPaddock);
        assertEquals(Side.TOILET, humanPlayerBoard.lonelyIslandPaddock.attributes.getSide());
        assertEquals(Biome.GRASSLAND, humanPlayerBoard.lonelyIslandPaddock.attributes.getBiome());
    }

    public void testGameStartShouldInstanciateIAPlayerBoardPaddocks() {
        Game game = instanciateGame();

        game.start();
        
        PlayerBoard IAPlayerBoard = getIAPlayerBoardFromGame(game);
        
        assertNotNull(IAPlayerBoard.similarsForestPaddock);
        assertEquals(Side.CAFETERIA, IAPlayerBoard.similarsForestPaddock.attributes.getSide());
        assertEquals(Biome.FOREST, IAPlayerBoard.similarsForestPaddock.attributes.getBiome());
        
        assertNotNull(IAPlayerBoard.woodTrioPaddock);
        assertEquals(Side.CAFETERIA, IAPlayerBoard.woodTrioPaddock.attributes.getSide());
        assertEquals(Biome.FOREST, IAPlayerBoard.woodTrioPaddock.attributes.getBiome());
        
        assertNotNull(IAPlayerBoard.loveGrasslandPaddock);
        assertEquals(Side.CAFETERIA, IAPlayerBoard.loveGrasslandPaddock.attributes.getSide());
        assertEquals(Biome.GRASSLAND, IAPlayerBoard.loveGrasslandPaddock.attributes.getBiome());
        
        assertNotNull(IAPlayerBoard.jungleKingPaddock);
        assertEquals(Side.TOILET, IAPlayerBoard.jungleKingPaddock.attributes.getSide());
        assertEquals(Biome.FOREST, IAPlayerBoard.jungleKingPaddock.attributes.getBiome());
        
        assertNotNull(IAPlayerBoard.differencesGrasslandPaddock);
        assertEquals(Side.TOILET, IAPlayerBoard.differencesGrasslandPaddock.attributes.getSide());
        assertEquals(Biome.GRASSLAND, IAPlayerBoard.differencesGrasslandPaddock.attributes.getBiome());
        
        assertNotNull(IAPlayerBoard.lonelyIslandPaddock);
        assertEquals(Side.TOILET, IAPlayerBoard.lonelyIslandPaddock.attributes.getSide());
        assertEquals(Biome.GRASSLAND, IAPlayerBoard.lonelyIslandPaddock.attributes.getBiome());
    }

    public void testGameSaveShouldCallAdapter(){
        GameSave gameSave = AdaptersMock.instanciateGameSaveMock();
        Game game = instanciateGameWithGameSave(gameSave);

        game.save();

        verify(gameSave, times(1)).save(game.getBoardGame());
    }

    public void testGameLoadShouldCallAdapter() {
        GameSave gameSave = AdaptersMock.instanciateGameSaveMock();
        BoardGame boardGame = ModelsMock.instanciateBoardGameMock();
        Mockito.when(gameSave.load()).thenReturn(boardGame);
        Game game = instanciateGameWithGameSave(gameSave);

        game.load();

        Mockito.verify(gameSave, Mockito.times(1)).load();
        assertNotNull(game.getBoardGame());
    }

    private Game instanciateGame() {
        ListShuffler listShufflerMock = UtilsMock.instanciateListShufflerIdentityMock();
        GameSave gameSave = AdaptersMock.instanciateGameSaveMock();
        GameProperties GameProperties = UtilsMock.instanciateGamePropertiesMock();
        return new Game(listShufflerMock, gameSave, GameProperties); 
    }

    private Game instanciateGameWithGameSave(GameSave gameSave) {
        ListShuffler listShufflerMock = UtilsMock.instanciateListShufflerIdentityMock();
        GameProperties GameProperties = UtilsMock.instanciateGamePropertiesMock();
        return new Game(listShufflerMock, gameSave, GameProperties); 
    }

    private Draw getDrawFromGame(Game game) {
        BoardGame boardGame = game.getBoardGame();
        return boardGame.draw;
    }

    private Player getHumanPlayerFromGame(Game game){
        BoardGame boardGame = game.getBoardGame();
        return boardGame.humanPlayer;
    }

    private Player getIAPlayerFromGame(Game game){
        BoardGame boardGame = game.getBoardGame();
        return boardGame.IAPlayer;
    }

    private PlayerBoard getHumanPlayerBoardFromGame(Game game){
        Player humanPlayer = getHumanPlayerFromGame(game);
        return humanPlayer.board;
    }

    private PlayerBoard getIAPlayerBoardFromGame(Game game){
        Player IAPlayer = getIAPlayerFromGame(game);
        return IAPlayer.board;
    }

}
