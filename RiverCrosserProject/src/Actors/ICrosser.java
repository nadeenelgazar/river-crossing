package Actors;

import java.awt.image.BufferedImage;

public interface ICrosser {
	
	
	public boolean canSail ();
	
	public double getweight();
		
	public int getEatingRank ();

	public BufferedImage[] getImages();
	
	public ICrosser makeCopy ();
	
	public void setLabelToBeShown (String label);

	public String getLabelToBeShown ();

}
