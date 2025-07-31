public class Algorithm {
    private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.015;
    private static final double crossRate = 0.8;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    public static Population evolvePopulation(Population pop, int[][] clauses) {
        Population newPop = new Population(pop.size(), pop.getIndividual(0).size());

        int elitismOffset = 0;
        if (elitism) {
            newPop.saveIndividual(0, pop.getFittest());
            elitismOffset = 1;
        }

        for (int i = elitismOffset; i < pop.size(); i++) {
            Individual p1 = tournamentSelection(pop);
            Individual p2 = tournamentSelection(pop);
            Individual child;
            if (Math.random() <= crossRate) {
                child = crossover(p1, p2);
            } else {
                child = (p1.getFitness() > p2.getFitness()) ? p1 : p2;
            }
            mutate(child);
            newPop.saveIndividual(i, child);
        }

        return newPop;
    }

    private static Individual crossover(Individual p1, Individual p2) {
        Individual child = new Individual(p1.size());
        for (int i = 0; i < p1.size(); i++) {
            boolean gene = Math.random() <= uniformRate ? p1.getGene(i) : p2.getGene(i);
            child.setGene(i, gene);
        }
        return child;
    }

    private static void mutate(Individual indiv) {
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                indiv.setGene(i, !indiv.getGene(i));
            }
        }
    }

    private static Individual tournamentSelection(Population pop) {
        Population tournament = new Population(tournamentSize, pop.getIndividual(0).size());
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.saveIndividual(i, pop.getIndividual(randomId));
        }
        return tournament.getFittest();
    }
}
