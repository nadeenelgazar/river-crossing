package LevelCreater;

import java.util.List;
import Actors.ICrosser;

public interface ICrossingStrategy {

	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders);

	public List<ICrosser> getInitialCrossers();

	public String[] getInstructions();

}
