package LevelCreater;

import java.util.ArrayList;
import java.util.List;

import Actors.ICrosser;

public class Level {
	
	ICrossingStrategy strategy ;
	
	 public Level(ICrossingStrategy strategy) {
		 this.strategy=strategy;
	 }
	 public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
				List<ICrosser> boatRiders) {
		 boolean x= this.strategy.isValid(rightBankCrossers, leftBankCrossers, boatRiders);
		 return x;
	 }
		public List<ICrosser> getInitialCrossers(){
			List<ICrosser> list = new ArrayList<ICrosser> ();
			list=this.strategy.getInitialCrossers();
			return list;
		}
		
		public String[] getInstructions() {
			String[] instructions = new String[3];
			instructions = this.strategy.getInstructions();
			return instructions;

		}

}
