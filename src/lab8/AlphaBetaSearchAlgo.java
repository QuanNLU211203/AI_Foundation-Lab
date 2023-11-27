package lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {
	private boolean reverse;

	public AlphaBetaSearchAlgo(boolean reverse){
		this.reverse = reverse;
	}

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	@Override
	public Node bestNextMove(Node node, boolean isMax) {
		if(isMax){
			return maxNode(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		else{
			return minNode(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		if(node.isTerminal()){
			System.out.println("Terminal: " + node.getLabel() + ", " + node.getValue());
			return node.getValue();
		}
		int max = Integer.MIN_VALUE;
		boolean canPrune = false;
		if(reverse){
			Collections.reverse(node.getChildren());
		}
		for(Node child : node.getChildren()){
			if(canPrune){
				System.out.println("PRUNE: " + child.getLabel());
			}
			else{
				max = Math.max(max, minValue(child, alpha, beta));
				alpha = Math.max(max, alpha);
				if(max >= beta){
					canPrune = true;
				}
			}
		}
		if(reverse){
			Collections.reverse(node.getChildren());
		}
		System.out.println("MAX: " + node.getLabel() + ", " + max);
		return max;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		if(node.isTerminal()){
			System.out.println("Terminal: " + node.getLabel() + ", " + node.getValue());
			return node.getValue();
		}
		int min = Integer.MAX_VALUE;
		boolean canPrune = false;
		if(reverse){
			Collections.reverse(node.getChildren());
		}
		for(Node child : node.getChildren()){
			if(canPrune){
				System.out.println("PRUNE: " + child.getLabel());
			}
			else{
				min = Math.min(min, maxValue(child, alpha, beta));
				beta = Math.min(min, beta);
				if(min <= alpha){
					canPrune = true;
				}
			}
		}
		if(reverse){
			Collections.reverse(node.getChildren());
		}
		System.out.println("MIN: " + node.getLabel() + ", " + min);
		return min;
	}

	public Node maxNode(Node node, int alpha, int beta){
		if(node.isTerminal()){
			return node;
		}
		Node maxNode = null;
		int maxValue = Integer.MIN_VALUE;
		if(reverse){
			Collections.reverse(node.getChildren());
		}
		for(Node child : node.getChildren()){
			int childValue = minValue(child, alpha, beta);
			if(childValue > maxValue){
				maxValue = childValue;
				maxNode = child;
				alpha = Math.max(maxValue, alpha);
			}
			if(maxValue >= beta){
				break;
			}
		}
		if(reverse){
			Collections.reverse(node.getChildren());
		}

		return maxNode;
	}

	public Node minNode(Node node, int alpha, int beta){
		if(node.isTerminal()){
			return node;
		}
		Node minNode = null;
		int minValue = Integer.MAX_VALUE;
		if(reverse){
			Collections.reverse(node.getChildren());
		}
		for(Node child : node.getChildren()){
			int childValue = maxValue(child, alpha, beta);
			if(childValue < minValue){
				minValue = childValue;
				minNode = child;
				beta = Math.min(minValue, beta);
			}
			if(minValue <= alpha){
				break;
			}
		}
		if(reverse){
			Collections.reverse(node.getChildren());
		}

		return minNode;
	}
}
