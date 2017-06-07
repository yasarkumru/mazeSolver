package service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlgoServices {
	public static final int WALL = Color.BLACK.getRGB();
	public static final int PATH = Color.WHITE.getRGB();
	public static final int ROUTE = Color.RED.getRGB();

	public static List<Node> getStartEndPoints(BufferedImage maze) {
		List<Node> points = new ArrayList<>(2);
		for (int i = 0; i < maze.getWidth(); i++) {
			if (maze.getRGB(i, 0) == PATH)
				points.add(new Node(i, 0, null));
			if (maze.getRGB(i, maze.getHeight() - 1) == PATH)
				points.add(new Node(i, maze.getHeight() - 1, null));
		}

		for (int i = 0; i < maze.getHeight(); i++) {
			if (maze.getRGB(0, i) == PATH)
				points.add(new Node(0, i, null));
			if (maze.getRGB(maze.getWidth() - 1, i) == PATH)
				points.add(new Node(maze.getWidth() - 1, i, null));
		}
		return points;
	}

	public static List<Node> getChildrenOfNode(Node n, BufferedImage maze, boolean[][] discovered) {
		List<Node> children = new LinkedList<>();
		int x = n.getX();
		int y = n.getY();
		try {
			if (maze.getRGB(x + 1, y) == PATH && !discovered[x + 1][y]) {
				children.add(new Node(x + 1, y, n));
			}
		} catch (Exception e) {
		}
		try {
			if (maze.getRGB(x - 1, y) == PATH && !discovered[x - 1][y]) {
				children.add(new Node(x - 1, y, n));
			}
		} catch (Exception e) {
		}
		try {
			if (maze.getRGB(x, y + 1) == PATH && !discovered[x][y + 1]) {
				children.add(new Node(x, y + 1, n));
			}
		} catch (Exception e) {
		}
		try {
			if (maze.getRGB(x, y - 1) == PATH && !discovered[x][y - 1]) {
				children.add(new Node(x, y - 1, n));
			}
		} catch (Exception e) {
		}
		return children;
	}
}
