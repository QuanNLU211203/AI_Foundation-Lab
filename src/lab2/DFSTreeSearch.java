package lab2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DFSTreeSearch implements ISearchAlgo{
    @Override
    public Node execute(Node root, String goal) {
        try{
            Stack<Node> frontier = new Stack<Node>();
            frontier.add(root);

            while(!frontier.isEmpty()){
                Node node = frontier.pop();
                if(node.getLabel().equals(goal)){
                    return node;
                }

                List<Node> childs = node.getChildrenNodes();
                for(int i = childs.size() - 1; i >= 0; i--){
                    Node child = (Node) childs.get(i).clone();
                    child.setParent(node);
                    frontier.add(child);
                }
            }

            return null;
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
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