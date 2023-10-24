package lab4;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo{
    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return 1;
            }
        });


        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        return null;
    }
}
