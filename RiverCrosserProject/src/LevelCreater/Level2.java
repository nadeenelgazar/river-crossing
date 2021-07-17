package LevelCreater;

import java.util.ArrayList;
import java.util.List;

import Actors.ICrosser;
import Actors.ICrosserModified;
import Actors.ActorFactory;

public class Level2 implements ICrossingStrategy {

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) {

		System.out.println("boat riders" + boatRiders.size());
		System.out.println("real left" + leftBankCrossers.size());
		System.out.println("real right" + rightBankCrossers.size());

		int flag = 1;
		boolean check = true;
		if (boatRiders.size() > 2) {
			return false;

		}
		for (int i = 0; i < boatRiders.size(); i++) {
			if (boatRiders.get(i).canSail() == true) {
				flag = 0;
			}
		}

		if (boatRiders.size() == 2) {
			if (boatRiders.get(0).getweight() + boatRiders.get(1).getweight() > 100)
				return false;
		}
		if (flag == 1)
			return false;
		else
			return true;
	}

	@Override
	public List<ICrosser> getInitialCrossers() {

		List<ICrosser> intialCrossers = new ArrayList<ICrosser>();

		ActorFactory factory = new ActorFactory();
		ICrosserModified farmer1 = factory.getcrosser("farmer");
		farmer1.setWeight(90);
		farmer1.setLabelToBeShown("Farmer 1: " + String.valueOf(farmer1.getweight()) + " kg");
		ICrosserModified farmer2 = factory.getcrosser("farmer");
		farmer2.setWeight(80);
		farmer2.setLabelToBeShown("Farmer 2: " + String.valueOf(farmer2.getweight()) + " kg");
		ICrosserModified farmer3 = factory.getcrosser("farmer");
		farmer3.setWeight(60);
		farmer3.setLabelToBeShown("Farmer 3: " + String.valueOf(farmer3.getweight()) + " kg");
		ICrosserModified farmer4 = factory.getcrosser("farmer");
		farmer4.setWeight(40);
		farmer4.setLabelToBeShown("Farmer 4: " + String.valueOf(farmer4.getweight()) + " kg");
		ICrosserModified goat = factory.getcrosser("herbivorous");
		goat.setWeight(20);
		goat.setLabelToBeShown("Goat: " + String.valueOf(goat.getweight()) + " kg");

		intialCrossers.add(farmer1);
		intialCrossers.add(farmer2);
		intialCrossers.add(farmer3);
		intialCrossers.add(farmer4);
		intialCrossers.add(goat);

		return intialCrossers;
	}

	@Override
	public String[] getInstructions() {
		String[] instructions = new String[3];
		instructions[0] = "Help the farmers to pass across the river with their animal";
		instructions[1] = "The boat can not move without a farmer";
		instructions[2] = "The maximum weight the boat can bare is '100kg' and the maximum number of riders is '2'";
		return instructions;
	}

}
