import java.util.Arrays;

public class FloydAlgorithm {

    private static final int INF = Integer.MAX_VALUE / 4;

    private static void printMatrix(int[][] M) {
        int n = M.length;
        for (int[] ints : M) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == INF) System.out.print("∞\t");
                else System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] floydWarshallTrace(int[][] W) {
        int n = W.length;
        int[][] D = new int[n][n];
        for (int i = 0; i < n; i++) {
            D[i] = Arrays.copyOf(W[i], n);
        }

        System.out.println("Початкова матриця (ваги):");
        printMatrix(D);
        System.out.println();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (D[i][k] == INF) continue;
                for (int j = 0; j < n; j++) {
                    if (D[k][j] == INF) continue;
                    int throughK = D[i][k] + D[k][j];
                    if (throughK < D[i][j]) {
                        D[i][j] = throughK;
                    }
                }
            }

            System.out.println("Після k = " + (k + 1));
            printMatrix(D);
            System.out.println();
        }

        return D;
    }

    public static void main(String[] args) {
        final int INF_LOCAL = INF;
        int[][] W = {
                // 1   2   3   4   5   6   7   8
                {0,   2,   7,   5,   6,   INF_LOCAL, 10,  INF_LOCAL}, // 1
                {2,   0,   INF_LOCAL, INF_LOCAL, 8,   INF_LOCAL, INF_LOCAL, INF_LOCAL}, // 2
                {7,   INF_LOCAL, 0,   INF_LOCAL, 3,   5,   9,   INF_LOCAL}, // 3
                {5,   INF_LOCAL, INF_LOCAL, 0,   6,   4,   4,   INF_LOCAL}, // 4
                {6,   8,   3,   6,   0,   3,   INF_LOCAL, INF_LOCAL}, // 5
                {INF_LOCAL, INF_LOCAL, 5,   4,   3,   0,   INF_LOCAL, 1}, // 6
                {10,  INF_LOCAL, 9,   4,   INF_LOCAL, INF_LOCAL, 0,   6}, // 7
                {INF_LOCAL, INF_LOCAL, INF_LOCAL, INF_LOCAL, INF_LOCAL, 1,   6,   0} // 8
        };

        int[][] D = floydWarshallTrace(W);

        System.out.println("Фінальна матриця найкоротших відстаней:");
        printMatrix(D);
    }
}