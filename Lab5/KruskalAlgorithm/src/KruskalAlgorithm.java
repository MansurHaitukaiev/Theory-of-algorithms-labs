import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {

    static class Edge implements Comparable<Edge> {
        int u;  // вершина 1
        int v;  // вершина 2
        int w;  // вага

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.w, other.w);
        }
    }

    static class Graph {
        private List<Edge> G = new ArrayList<>(); // усі ребра
        private List<Edge> T = new ArrayList<>(); // MST
        private int[] parent;
        private int V; // кількість вершин

        public Graph(int V) {
            this.V = V;
            parent = new int[V + 1];   // вершини нумеруємо з 1 до V
            for (int i = 1; i <= V; i++) {
                parent[i] = i;
            }
        }

        public void addWeightedEdge(int u, int v, int w) {
            G.add(new Edge(u, v, w));
        }

        public int findSet(int i) {
            if (i == parent[i]) return i;
            return findSet(parent[i]);
        }

        public void unionSet(int u, int v) {
            parent[u] = parent[v];
        }

        public void kruskal() {
            Collections.sort(G); // сортуємо за вагою
            for (Edge e : G) {
                int uRep = findSet(e.u);
                int vRep = findSet(e.v);

                if (uRep != vRep) {
                    T.add(e);              // додаємо ребро в дерево
                    unionSet(uRep, vRep);  // об’єднуємо множини
                }
            }
        }

        public void print() {
            System.out.println("Edge : Weight");
            int total = 0;
            for (Edge e : T) {
                System.out.println(e.u + " - " + e.v + " : " + e.w);
                total += e.w;
            }
            System.out.println("Total weight of MST = " + total);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);

        g.addWeightedEdge(1, 2, 2);

        g.addWeightedEdge(1, 3, 7);
        g.addWeightedEdge(1, 4, 5);
        g.addWeightedEdge(1, 5, 6);
        g.addWeightedEdge(1, 7, 10);

        g.addWeightedEdge(2, 5, 8);

        g.addWeightedEdge(3, 5, 3);
        g.addWeightedEdge(3, 6, 5);
        g.addWeightedEdge(3, 7, 9);

        g.addWeightedEdge(4, 5, 6);
        g.addWeightedEdge(4, 6, 4);
        g.addWeightedEdge(4, 7, 4);

        g.addWeightedEdge(5, 6, 3);

        g.addWeightedEdge(6, 8, 1);

        g.addWeightedEdge(7, 8, 6);

        g.kruskal();
        g.print();
    }
}