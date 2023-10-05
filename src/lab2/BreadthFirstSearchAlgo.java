package lab2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class BreadthFirstSearchAlgo implements ISearchAlgo{
    @Override
    public Node execute(Node root, String goal) {
        Queue<Node> frontier = new LinkedList<Node>();
        Set<Node> explored = new HashSet<Node>();
        frontier.add(root);

        while(!frontier.isEmpty()){
            Node node = frontier.poll();
            if(node.getLabel().equals(goal)){
                return node;
            }

            for(Node child : node.getChildrenNodes()){
                if(!explored.contains(child)){
                    child.setParent(node);
                    explored.add(child);
                    frontier.add(child);
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
