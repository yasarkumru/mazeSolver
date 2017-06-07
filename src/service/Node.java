package service;

public class Node implements Comparable<Node> {

	private int x;
	private int y;
	private Node parent;
	private int cost = Integer.MAX_VALUE;
	private float heuristic = 0;

	public Node(int x, int y, Node parent) {
		super();
		this.x = x;
		this.y = y;
		this.parent = parent;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Node))
			return false;
		Node n = (Node) obj;
		return n.x == this.x && n.y == this.y;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public float getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(float heuristic) {
		this.heuristic = heuristic;
	}

	@Override
	public String toString() {
		return x + " " + y + " cost: " + cost;
	}

	@Override
	public int compareTo(Node o) {
		float totalO = o.getCost() + o.getHeuristic();
		float totalthis = getCost() + getHeuristic();
		
		if(totalthis> totalO)
			return 1;
		else if (totalthis < totalO)
			return -1;
		return 0;
	}

}
