package lab8;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		maxValue(node);
	}

	@Override
	public Node bestNextMove(Node node, boolean isMax) {
		return null;
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if(node.isTerminal()){
			System.out.println("Terminal: " + node.getLabel() + ", " + node.getValue());
			return node.getValue();
		}
		int max = Integer.MIN_VALUE;
		for(Node child : node.getChildren()){
			max = Math.max(max, minValue(child));
		}
		System.out.println("MAX: " + node.getLabel() + ", " + max);
		return max;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		if(node.isTerminal()){
			System.out.println("Terminal: " + node.getLabel() + ", " + node.getValue());
			return node.getValue();
		}
		int min = Integer.MAX_VALUE;
		for(Node child : node.getChildren()){
			min = Math.min(min, maxValue(child));
		}
		System.out.println("MIN: " + node.getLabel() + ", " + min);
		return min;
	}
}
