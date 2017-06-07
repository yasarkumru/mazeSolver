package algorithms;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import service.AlgoServices;
import service.Node;

public class PathSearchAlgorithms {

	public static final int DJISKTRA = 0;
	public static final int A_STAR = 1;

	public static void solveWithAstar(BufferedImage maze) {
		solveGeneric(maze, A_STAR);
	}

	public static void solveWithDjisktra(BufferedImage maze) {
		solveGeneric(maze, DJISKTRA);
	}

	public static void solveGeneric(BufferedImage maze, int algo) {
		boolean[][] discovered = new boolean[maze.getWidth()][maze.getHeight()];
		List<Node> startEndPoints = AlgoServices.getStartEndPoints(maze);
		Queue<Node> queue = new PriorityQueue<>();
		Node start = startEndPoints.get(0);
		Node end = startEndPoints.get(1);
		start.setCost(0);
		queue.add(start);
		while (!queue.isEmpty()) {
			Node pop = queue.poll();
			if (pop.equals(end)) {
				end.setParent(pop);
				break;
			}

			List<Node> childrenOfNode = AlgoServices.getChildrenOfNode(pop, maze, discovered);
			for (Node node : childrenOfNode) {
				setCost(pop, node);
				if (algo == A_STAR)
					setHeuristic(end, node);
				queue.add(node);
			}
			discovered[pop.getX()][pop.getY()] = true;
		}

		while (end != null) {
			maze.setRGB(end.getX(), end.getY(), AlgoServices.ROUTE);
			end = end.getParent();
		}
	}

	private static void setHeuristic(Node end, Node node) {
		float heuristicVal = (float) Math
				.sqrt(Math.pow(end.getX() - node.getX(), 2) + Math.pow(node.getY() - node.getY(), 2));
		node.setHeuristic(heuristicVal);
	}

	public static void setCost(Node from, Node to) {
		int cost = from.getCost() + 1;
		if (cost < to.getCost()) {
			to.setCost(cost);
			to.setParent(from);
		}

	}

}
