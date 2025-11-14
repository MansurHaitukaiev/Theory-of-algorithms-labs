import java.util.Arrays;

public class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] G, int start) {
        int n = G.length;
        int[] dist = new int[n];
        int[] pred = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        Arrays.fill(pred, -1);
        dist[start] = 0;

        System.out.println("Початкові відстані:");
        printDistances(dist);

        for (int i = 0; i < n; i++) {
            int u = -1;
            int minDist = INF;
            for (int j = 0; j < n-1; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    u = j;
                }
            }

            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (G[u][v] != INF && !visited[v]) {
                    if (dist[v] > dist[u] + G[u][v]) {
                        dist[v] = dist[u] + G[u][v];
                        pred[v] = u;
                    }
                }
            }

            System.out.println("Ітерація " + (i + 1) + ":");
            printDistances(dist);
        }

        System.out.println("\nНайкоротші відстані від вершини " + (start + 1) + " до:");
        for (int i = 0; i < n; i++) {
            if (i != start) {
                System.out.println((i + 1) + ": " + (dist[i] == INF ? "∞" : dist[i]));
            }
        }
    }

    private static void printDistances(int[] dist) {
        for (int d : dist) {
            if (d == INF) System.out.print("∞\t");
            else System.out.print(d + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final int INF = Integer.MAX_VALUE;
        int[][] G = {
                // 1  2  3  4  5  6  7  8
                {INF, 2, 7, 5, 6, INF, 10, INF}, // 1
                {2, INF, INF, INF, 8, INF, INF, INF}, // 2
                {7, INF, INF, INF, 3, 5, 9, INF}, // 3
                {5, INF, INF, INF, 6, 4, 4, INF}, // 4
                {6, 8, 3, 6, INF, 3, INF, INF}, // 5
                {INF, INF, 5, 4, 3, INF, INF, 1}, // 6
                {10, INF, 9, 4, INF, INF, INF, 6}, // 7
                {INF, INF, INF, INF, INF, 1, 6, INF} // 8
        };

        int startVertex = 0;
        dijkstra(G, startVertex);
    }
}