package service;

import java.awt.image.BufferedImage;

public class ImageServices {
	public static BufferedImage normalizeImage(BufferedImage maze, int pixel) {
		BufferedImage subimage = maze.getSubimage(0, 0, maze.getWidth() - 1, maze.getHeight() - 1);
		BufferedImage norImage = new BufferedImage(subimage.getWidth(), subimage.getHeight(),
				BufferedImage.TYPE_INT_RGB);
		for (int i = 0; i < norImage.getWidth(); i++) {
			for (int j = 0; j < norImage.getHeight(); j++) {
				norImage.setRGB(i, j, subimage.getRGB(i, j));
			}
		}
		return norImage;
	}

	public static void visualizeImage(BufferedImage image) {
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				if (image.getRGB(i, j) == AlgoServices.WALL)
					System.out.print("#");
				else
					System.out.print(" ");
			}
			System.out.println();

		}
	}

}
