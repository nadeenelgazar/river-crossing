package Actors;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Farmer implements ICrosserModified {

	private double weight;
	private String label;

	@Override
	public int getEatingRank() {
		return 5;
	}

	public BufferedImage[] getImages() {
		BufferedImage[] bufferedImages = new BufferedImage[5];
		File initialImage1 = new File("farmer4.png");
		File initialImage2 = new File("farmer3.png");
		File initialImage3 = new File("Farmer.png");
		File initialImage4 = new File("farmer2.png");
		try {
			bufferedImages[0] = ImageIO.read(initialImage1);
			bufferedImages[1] = ImageIO.read(initialImage2);
			bufferedImages[2] = ImageIO.read(initialImage3);
			bufferedImages[3] = ImageIO.read(initialImage4);
			BufferedImage scaledImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);

			Graphics2D graphics2D = scaledImage.createGraphics();

			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			graphics2D.drawImage(bufferedImages[0], 0, 0, 50, 50, null);
			graphics2D.drawImage(bufferedImages[1], 0, 0, 50, 50, null);
			graphics2D.drawImage(bufferedImages[2], 0, 0, 50, 50, null);
			graphics2D.drawImage(bufferedImages[3], 0, 0, 50, 50, null);

			graphics2D.dispose();
			bufferedImages[0] = scaledImage;
			bufferedImages[1] = scaledImage;
			bufferedImages[2] = scaledImage;
			bufferedImages[3] = scaledImage;

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
	public double getweight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public boolean canSail() {
		return true;
	}

	@Override
	public ICrosser makeCopy() {
		// TODO Auto-generated method stub
		return null;
	}

}
