package lab4;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarSearchAlgo implements IInformedSearchAlgo{
    @Override
    public Node execute(Node root, String goal) {
        root.setG(0);
        root.setParent(null);

        Comparator fc = new NodeComparatorFactory().getFComarator();
        PriorityQueue<Node> frontier = new PriorityQueue<>(fc);
        Set<Node> explored = new HashSet<>();
        frontier.add(root);

        while (!frontier.isEmpty()) {
            System.out.println(frontier);
            Node node = frontier.poll();
            if (node.getLabel().equals(goal)) {
                return node;
            }
            explored.add(node);

            for(Edge edge : node.getChildren()){
                Node child = edge.getEnd();
                double newG = node.getG() + edge.getWeight();
                boolean inFrontier = frontier.contains(child);
                boolean inExplored = explored.contains(child);
                boolean shouldAddToFrontier = false; //Nếu shouldAdd = true thì thêm vô frontier
                if (child.getG() > newG){
                    //Trong trường hợp F(oldChild) > F(newChild) thì sẽ có 2 trường hợp xảy ra
                    if(inFrontier){
                        //TH1: oldChild trong frontier và newChild tốt hơn
                        //Thay thế oldChild = newChild
                        frontier.remove(child);
                        shouldAddToFrontier = true;
                    }
                    else if(inExplored){
                        //TH2: oldChild đã xét qua, nhưng newChild tốt hơn
                        //Thêm newChild vào lại frontier
                        shouldAddToFrontier = true;
                    }
                }
                else if(!inExplored && !inFrontier){
                    //Đây là TH child chưa được xét qua
                    shouldAddToFrontier = true;
                }
                // Suy ra các trường hợp sau sẽ không được bỏ vào frontier
                // (1): newChild tệ hơn oldChild trong frontier
                // (2): newChild tệ hơn oldChild trong explored

                if(shouldAddToFrontier){
                    child.setG(newG);
                    child.setParent(node);
                    frontier.add(child);
                }
            }
        }

        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        return null;
    }

    public boolean isAdmissibleH(Node root, String goal){
        double trueCost = new UninformCostSearchAlgo().execute(root, goal).getG();
        if(trueCost >= root.getH()){
            return true;
        }
        else{
            return false;
        }
    }
}
