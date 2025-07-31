public class Population {
    private Individual[] individuals;

    public Population(int size, int numVars) {
        individuals = new Individual[size];
        for (int i = 0; i < size; i++) {
            individuals[i] = new Individual(numVars);
        }
    }

    public Individual getIndividual(int index) {
        return individuals[index];
    }

    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];
        for (int i = 1; i < individuals.length; i++) {
            if (individuals[i].getFitness() > fittest.getFitness()) {
                fittest = individuals[i];
            }
        }
        return fittest;
    }

    public int size() {
        return individuals.length;
    }
}
