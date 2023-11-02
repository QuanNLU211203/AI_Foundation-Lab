package lab5;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class HillClimbing extends AbstractSearch{
    public HillClimbing() {
        super("Hill Climbing");
    }

    @Override
    public Node execute(Puzzle model) {
        PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
        Set<Node> explored = new HashSet<>();

        model.getInitialState().setParent(null);
        model.getInitialState().setG(0);
        frontier.add(model.getInitialState());

        while (!frontier.isEmpty()){
            Node currentState = frontier.poll();
            if(currentState.equals(model.getGoalState())){
                return currentState;
            }
            explored.add(currentState);

            Node goodNode = null;
            for(Node successor : model.getSuccessors(currentState)){
                if(!explored.contains(successor) && !frontier.contains(successor)){
                    if(goodNode == null || goodNode.getH() > successor.getH()){
                        successor.setG(currentState.getG() + 1); // Set G
                        successor.setParent(currentState); //Dùng cho việc truy vết
                        goodNode = successor;
                    }
                }
            }
            if(goodNode != null && currentState.getH() > goodNode.getH()){
                frontier.add(goodNode);
            }
        }

        return null;
    }
}
