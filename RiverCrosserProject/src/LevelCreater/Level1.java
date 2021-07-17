package LevelCreater;

import java.util.ArrayList;
import java.util.List;

import Actors.Carnivorous;
import Actors.Farmer;
import Actors.Herbivorous;
import Actors.ICrosser;
import Actors.Plant;
import Actors.ActorFactory;

public class Level1 implements ICrossingStrategy {

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) {

		System.out.println("boat riders" + boatRiders.size());
		System.out.println("real left" + leftBankCrossers.size());
		System.out.println("real right" + rightBankCrossers.size());
		boolean check = true;
		if (boatRiders.size() > 2) {
			return false;

		}
		for (int i = 0; i < boatRiders.size(); i++) {
			if (boatRiders.get(i).canSail() == true) {
				// flag = 0;
				check = false;
			}
		}

		if (rightBankCrossers.size() == 2 || rightBankCrossers.size() == 3) {
			if (Math.abs(rightBankCrossers.get(0).getEatingRank() - rightBankCrossers.get(1).getEatingRank()) == 1) {

				return false;
			}
		}

		if (leftBankCrossers.size() == 2 || leftBankCrossers.size() == 3) {
			if (Math.abs(leftBankCrossers.get(0).getEatingRank() - leftBankCrossers.get(1).getEatingRank()) == 1) {

				return false;
			}
		}

		if (check)
			return false;
		else
			return true;
	}

	@Override
	public List<ICrosser> getInitialCrossers() {

		List<ICrosser> intialCrossers = new ArrayList<ICrosser>();

		ActorFactory factory = new ActorFactory();
		ICrosser farmer = factory.getcrosser("farmer");
		farmer.setLabelToBeShown("Farmer can not eat anything");
		ICrosser goat = factory.getcrosser("herbivorous");
		goat.setLabelToBeShown("Goat can eat plant");
		ICrosser lion = factory.getcrosser("carnivorous");
		lion.setLabelToBeShown("Wolf can eat goat");
		ICrosser plant = factory.getcrosser("plant");
		plant.setLabelToBeShown("Plant can not eat anything");

		intialCrossers.add(farmer);
		intialCrossers.add(lion);
		intialCrossers.add(goat);
		intialCrossers.add(plant);

		return intialCrossers;
	}

	@Override
	public String[] getInstructions() {
		String[] instructions = new String[3];
		instructions[0] = "Help the farmer to move lion, goat and plant across the river";
		instructions[1] = "The boat can not move without the farmer";
		instructions[2] = "When the farmer is not nearby the wolf will eat the goat and the goat will eat the plant but you can leave the 3 of them alone";
		return instructions;
	}

}
