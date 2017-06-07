package algorithms;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import service.AlgoServices;
import service.Node;

public class TreeSearchAlgorithms {
	public static final int DFS = 0;
	public static final int BFS = 1;

	public static void solveWithDFS(BufferedImage maze) {
		solveGeneric(maze, DFS);
	}

	public static void solveWithBFS(BufferedImage maze) {
		solveGeneric(maze, BFS);
	}

	private static void solveGeneric(BufferedImage maze, int algo) {
		List<Node> dataType = new LinkedList<>();
		List<Node> startEndPoints = AlgoServices.getStartEndPoints(maze);
		boolean[][] discovered = new boolean[maze.getWidth()][maze.getHeight()];

		int endX = startEndPoints.get(1).getX();
		int endY = startEndPoints.get(1).getY();
		Node end = new Node(endX, endY, null);

		int startX = startEndPoints.get(0).getX();
		int startY = startEndPoints.get(0).getY();
		dataType.add(new Node(startX, startY, null));
		while (!dataType.isEmpty()) {
			Node pop;
			if (algo == DFS)
				pop = dataType.remove(dataType.size() - 1);
			else
				pop = dataType.remove(0);
			
			if (pop.equals(end)) {
				end.setParent(pop);
				break;
			}
			discovered[pop.getX()][pop.getY()] = true;
			List<Node> childrenOfNode = AlgoServices.getChildrenOfNode(pop, maze, discovered);
			for (Node node : childrenOfNode) {
				dataType.add(node);
			}
		}

		while (end != null) {
			maze.setRGB(end.getX(), end.getY(), AlgoServices.ROUTE);
			end = end.getParent();
		}
	}
	
	public void solveWithDjisktra(){
		
	}

}
