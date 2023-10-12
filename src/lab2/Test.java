package lab2;

public class Test {
    public static void main(String[] args) {
        ISearchAlgo bfsGraphSearch = new BreadthFirstSearchAlgo();
        ISearchAlgo bfsTreeSearch = new BFSTreeSearch();
        ISearchAlgo dfsGraphSearch = new DepthFirstSearchAlgo();
        ISearchAlgo dfsTreeSearch = new DFSTreeSearch();
        ISearchAlgo uniformCostSearch = new UniformCostSearchAlgo();
        ISearchAlgo depthLimit5 = new DepthLimitedSearch(3);

        Node nodeS = createTestSet1();
        Node result = bfsTreeSearch.execute(nodeS, "G");
        System.out.println(result);
        System.out.println(result.getPathCost());
    }

    public static Node createTestSet1(){
        Node nodeS = new Node("S");
        Node nodeA = new Node("A"); Node nodeB = new Node("B");
        Node nodeC = new Node("C"); Node nodeD = new Node("D");
        Node nodeE = new Node("E"); Node nodeF = new Node("F");
        Node nodeG = new Node("G"); Node nodeH = new Node("H");
        nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
        nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
        nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
        nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
        nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);

        return nodeS;
    }

    public static Node createTestSet2(){
        Node nodeStart = new Node("S");
        Node nodeA = new Node("A"); Node nodeB = new Node("B");
        Node nodeC = new Node("C"); Node nodeD = new Node("D");
        Node nodeE = new Node("E"); Node nodeF = new Node("F");
        Node nodeH = new Node("H"); Node nodeP = new Node("P");
        Node nodeQ = new Node("Q"); Node nodeR = new Node("R");
        Node nodeGoal = new Node("G");

        nodeStart.addEdge(nodeD, 3); nodeStart.addEdge(nodeE, 9); nodeStart.addEdge(nodeP, 1);
        nodeB.addEdge(nodeA, 2);
        nodeC.addEdge(nodeA, 2);
        nodeD.addEdge(nodeB, 1); nodeD.addEdge(nodeC, 8); nodeD.addEdge(nodeE, 3);
        nodeE.addEdge(nodeH, 1); nodeE.addEdge(nodeR, 9);
        nodeF.addEdge(nodeC, 5); nodeF.addEdge(nodeGoal, 5);
        nodeH.addEdge(nodeP, 4); nodeH.addEdge(nodeQ, 4);
        nodeP.addEdge(nodeQ, 15);
        nodeQ.addEdge(nodeR, 3);
        nodeR.addEdge(nodeF, 5);

        return nodeStart;
    }
}
