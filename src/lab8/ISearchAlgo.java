package lab8;

public interface ISearchAlgo {
	public void execute(Node node);
	public Node bestNextMove(Node node, boolean isMax);
}
