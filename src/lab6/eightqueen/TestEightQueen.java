package lab6.eightqueen;

public class TestEightQueen {
    public static void main(String[] args) {
        Node node = new Node();
        HillClimbingSearch hillClimbing = new HillClimbingSearch();
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
//        Node result = hillClimbing.executeHillClimbingWithRandomRestart(node);
        Node result = simulatedAnnealing.execute(node, 1000, 0.9999);
        result.displayBoard();
    }
}
