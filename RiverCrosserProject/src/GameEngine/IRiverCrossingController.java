package GameEngine;

import java.util.List;
import Actors.ICrosser;
import LevelCreater.ICrossingStrategy;

public interface IRiverCrossingController {

	public void newGame(ICrossingStrategy gameStrategy);

	public void resetGame();

	public String[] getInstructions();

	public List<ICrosser> getCrossersOnRightBank();

	public List<ICrosser> getCrossersOnLeftBank();

	public boolean isBoatOnTheLeftBank();

	public int getNumberOfSails();

	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank);

	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank);

	public boolean canUndo();

	public boolean canRedo();

	public void undo();

	public void redo();

	public void saveGame();

	public void loadGame();

	public List<List<ICrosser>> solveGame();

}
