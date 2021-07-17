package Actors;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Carnivorous implements ICrosserModified {

	private double weight;
	private String label;

	@Override
	public double getweight() {
		return 0;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int getEatingRank() {
		return 2;
	}

	public BufferedImage[] getImages() {
		BufferedImage[] bufferedImages = new BufferedImage[1];
		File initialImage = new File("wolf.png");
		try {
			bufferedImages[0] = ImageIO.read(initialImage);
			BufferedImage scaledImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);

			Graphics2D graphics2D = scaledImage.createGraphics();

			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			graphics2D.drawImage(bufferedImages[0], 0, 0, 50, 50, null);

			graphics2D.dispose();
			bufferedImages[0] = scaledImage;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return bufferedImages;
	}

	@Override
	public void setLabelToBeShown(String label) {
		this.label = label;

	}

	@Override
	public String getLabelToBeShown() {
		return label;
	}

	@Override
	public boolean canSail() {
		return false;
	}

	@Override
	public ICrosser makeCopy() {
		return null;
	}

}
