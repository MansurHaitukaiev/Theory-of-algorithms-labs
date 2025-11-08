import java.util.Arrays;

public class PrimAlgorithm {
    private static final int INF = 9999999;
    private static final int V = 8;

    // мтриця суміжності для графа з картинки
    private static final int[][] G = {
            // 1   2   3   4   5   6   7   8
            {INF, 2,  7, 5,  6,  INF, 10, INF}, // 1
            {2,   INF, INF, INF, 8,  INF, INF, INF}, // 2
            {7,   INF, INF, INF, 3,  5,  9,  INF}, // 3
            {5,   INF, INF, INF, 6,  4,  4,  INF}, // 4
            {6,   8,   3,  6,  INF, 3,  INF, INF}, // 5
            {INF, INF, 5,  4,  3,  INF, INF, 1},   // 6
            {10,  INF, 9,  4,  INF, INF, INF, 6},  // 7
            {INF, INF, INF, INF, INF, 1,  6,  INF} // 8
    };

    public static void main(String[] args) {
        boolean[] selected = new boolean[V];
        Arrays.fill(selected, false);

        selected[7] = true; // починаємо з вершини 1
        int no_edge = 0;
        int totalWeight = 0; // сума ваг мкд

        System.out.println("Edge : Weight");

        while (no_edge < V - 1) {
            int min = INF;
            int x = 0;
            int y = 0;

            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && G[i][j] < min) {
                            min = G[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            System.out.println((x + 1) + " - " + (y + 1) + " : " + G[x][y]);
            totalWeight += G[x][y];   // додаємо вагу ребра до суми
            selected[y] = true;
            no_edge++;
        }

        System.out.println("Total weight of MST = " + totalWeight);
    }
}