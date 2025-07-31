import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GA {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de variables: ");
        int numVariables = scanner.nextInt();

        System.out.print("Ingrese el número de cláusulas: ");
        int numClauses = scanner.nextInt();

        System.out.print("Ingrese el número de literales por cláusula: ");
        int literalsPerClause = scanner.nextInt();

        System.out.print("Ingrese el tamaño de la población: ");
        final int POPULATION_SIZE = scanner.nextInt();

        int[][] clauses = new int[numClauses][literalsPerClause];
        Random random = new Random();

        for (int i = 0; i < numClauses; i++) {
            for (int j = 0; j < literalsPerClause; j++) {
                int variable = random.nextInt(numVariables) + 1;
                int sign = random.nextBoolean() ? 1 : -1;
                clauses[i][j] = sign * variable;
            }
        }

        Population population = new Population(POPULATION_SIZE, numVariables);
        FitnessCalc.setDatos(clauses);

        int generationCount = 0;

        System.out.println("Fitness inicial:" + population.getFittest().getFitness());

        while(generationCount<POPULATION_SIZE*1000 && population.getFittest().getFitness()!= clauses.length) {
            generationCount++;
            if (generationCount % 1000 == 0) {
                System.out.println("Generacion:" + generationCount);
            }
            population = Algorithm.evolvePopulation(population, clauses);
        }

        System.out.println("Expresión booleana con " + numVariables + " variables y " + clauses.length + " cláusulas.");
        System.out.println("Fitness final: " + population.getFittest().getFitness());

        if (population.getFittest().getFitness() == clauses.length) {
            System.out.println("Se resolvió satisfactoriamente. Solución:");
            System.out.println(Arrays.toString(population.getFittest().getGenes()));
        } else {
            System.out.println("No se pudo resolver completamente.");
        }

        scanner.close();
    }
}