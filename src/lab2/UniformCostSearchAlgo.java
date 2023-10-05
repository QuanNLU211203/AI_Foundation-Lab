package lab2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UniformCostSearchAlgo implements ISearchAlgo{
    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<Node>();
        root.setPathCost(0);
        frontier.add(root);

        while(!frontier.isEmpty()){
            Node node = frontier.poll();
            if(node.getLabel().equals(goal)){
                return node;
            }

            for(Edge childEdge : node.getChildren()){
                Node childNode = childEdge.getEnd();
                double newCost = node.getPathCost() + childEdge.getWeight();
                if(frontier.contains(childNode) && childNode.getPathCost() > newCost){
                    frontier.remove(childNode);
                }
                childNode.setParent(node);
                childNode.setPathCost(newCost);
                frontier.add(childNode);
            }
        }

        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        Node startNode = execute(root, start);
        if(startNode != null){
            startNode.setParent(null);
            return execute(startNode, goal);
        }

        return null;
    }
}
