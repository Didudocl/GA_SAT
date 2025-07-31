public class FitnessCalc {
    static int[][] clauses = {{1, 4, 3, 7, -1, -7, -8, 10, 2, 3}};
    public static void setDatos(int [][] input) {
        clauses = input;
    }
    public static int evaluate(boolean[] individuo) {
        int satisfied = 0;
        for (int[] clause : clauses) {
            boolean clauseSatisfied = false;
            for (int literal : clause) {
                int var = Math.abs(literal) - 1;
                boolean value = individuo[var];
                if (literal < 0) value = !value;
                clauseSatisfied |= value;
            }
            if (clauseSatisfied) satisfied++;
        }
        return satisfied;
    }
}
