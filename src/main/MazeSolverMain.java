package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import algorithms.PathSearchAlgorithms;
import algorithms.TreeSearchAlgorithms;
import service.ImageServices;

public class MazeSolverMain {
	public static final String MAZE_FOLDER = "/home/yasar/Documents/mazes";
	public static final String SOLUTION_FOLDER = "/home/yasar/Documents/mazes/solutions";

	public static void main(String[] args) {
		try {
			File f = new File(MAZE_FOLDER);
			File[] listFiles = f.listFiles();
			for (File file : listFiles) {
				if (file.isDirectory())
					continue;

				BufferedImage read = ImageIO.read(file);

				System.out.println("File read: " + file.getName());

				BufferedImage dfs = ImageServices.normalizeImage(read, 1);
				TreeSearchAlgorithms.solveWithDFS(dfs);
				ImageIO.write(dfs, "bmp", new File(SOLUTION_FOLDER + "/" + file.getName() + "-dfs"));

				// BufferedImage bfs = ImageServices.normalizeImage(read, 1);
				// TreeSearchAlgorithms.solveWithBFS(bfs);
				// ImageIO.write(bfs, "bmp", new File(SOLUTION_FOLDER + "/" +
				// file.getName() + "-bfs"));

				// BufferedImage djisktra = ImageServices.normalizeImage(read,
				// 1);
				// PathSearchAlgorithms.solveWithDjisktra(djisktra);
				// ImageIO.write(djisktra, "bmp", new File(SOLUTION_FOLDER + "/"
				// + file.getName() + "-djiskstra"));

				BufferedImage astar = ImageServices.normalizeImage(read, 1);
				PathSearchAlgorithms.solveWithAstar(astar);
				ImageIO.write(astar, "bmp", new File(SOLUTION_FOLDER + "/" + file.getName() + "-astar"));

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
