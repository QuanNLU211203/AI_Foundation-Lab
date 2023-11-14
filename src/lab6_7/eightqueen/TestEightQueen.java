package lab6_7.eightqueen;

public class TestEightQueen {
    public static void main(String[] args) {
        HillClimbingSearch hillClimbing = new HillClimbingSearch();
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing();
        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(100, 0.03, 1000);
        geneticAlgorithm.initPopulation();

        int count = 0;
        for(int i = 0; i < 100; i++){
//            Node node = simulatedAnnealing.execute(new Node(true), 1000, 0.999);
//            Node node = hillClimbing.executeHillClimbingWithRandomRestart(new Node(true));
            Node node = geneticAlgorithm.execute();
            if(node.getH() == 0){
                count++;
                System.out.println("OK");
            }
            geneticAlgorithm.initPopulation();
        }

        System.out.println("Tỷ lệ thành công:" + count * 1.0/ 100);

//        Node result = simulatedAnnealing.execute(node, 1000, 0.9999);
    }
}
