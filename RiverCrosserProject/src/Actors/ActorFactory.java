package Actors;

public class ActorFactory {
	public ICrosserModified getcrosser(String crosserType) {
		if (crosserType == null)
			return null;
		if (crosserType.equalsIgnoreCase("farmer"))
			return new Farmer();
		else if (crosserType.equalsIgnoreCase("Herbivorous"))
			return new Herbivorous();
		else if (crosserType.equalsIgnoreCase("carnivorous"))
			return new Carnivorous();

		else if (crosserType.equalsIgnoreCase("plant"))
			return Plant.getInstance();
		return null;
	}

}