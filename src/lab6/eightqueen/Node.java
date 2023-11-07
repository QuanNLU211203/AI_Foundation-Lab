package lab6.eightqueen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Node implements Cloneable{
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		state = new Queen[N];
		generateBoard();
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = qi.clone();
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		for(int i = 0; i < N - 1; i++){
			for(int j = i + 1; j < N; j++){
				if(state[i].isConflict(state[j])){
					heuristic += 2;
				}
			}
		}
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		for(int i = 0; i < N; i++){
			for(int row = 0; row < N; row++){
				Node newNode = this.clone();
				if(newNode.state[i].getRow() != row){
					newNode.state[i].setRow(row);
				}
				result.add(newNode);
			}
		}
		return result;
	}

	public Node selectNextRandomCandidate() {
		int queenIndex = new Random().nextInt(N);
		int queenRow = new Random().nextInt(N);
		Node newNode = this.clone();
		newNode.state[queenIndex].move();
		return newNode;
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}

	@Override
	public Node clone(){
		return new Node(this);
	}

//	@Override
//	public int hashCode() {
//		String hashString = "";
//		for(Queen queen : state){
//			hashString += queen.getRow();
//		}
//		return Integer.parseInt(hashString);
//	}
}
