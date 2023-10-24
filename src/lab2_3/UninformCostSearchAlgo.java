package lab2_3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class UninformCostSearchAlgo implements ISearchAlgo{
    @Override
    public Node execute(Node root, String goal) {
        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                double result = o1.getPathCost() - o2.getPathCost();
                if(result == 0){
                    return o1.compareTo(o2);
                }
                else{
                    return (result > 0) ? (1):(-1);
                }
            }
        };
        PriorityQueue<Node> frontier = new PriorityQueue<Node>(comparator);
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
                if (!frontier.contains(childNode)){
                    childNode.setParent(node);
                    childNode.setPathCost(newCost);
                    frontier.add(childNode);
                }
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
