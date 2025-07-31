import java.util.Random;

public class Individual {
    private boolean[] genes;
    private int fitness = Integer.MIN_VALUE;
    Random rand = new Random();

    public Individual(int numVars) {
        genes = new boolean[numVars];
        for (int i = 0; i < numVars; i++) {
            genes[i] = rand.nextBoolean();
        }
    }

    public boolean getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, boolean value) {
        genes[index] = value;
        fitness = Integer.MIN_VALUE;
    }

    public boolean[] getGenes() {
        return genes;
    }

    public int size() {
        return genes.length;
    }

    public int getFitness() {
        if (fitness == Integer.MIN_VALUE) {
            fitness = FitnessCalc.evaluate(genes);
        }
        return fitness;
    }
}
