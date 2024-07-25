import java.util.*;

public class dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt() + 1;

        int c[][] = new int[n][n];
        int path[] = new int[n], visited[] = new int[n], dist[] = new int[n];

        n -= 1;

        System.out.println("Enter cost matrix");
        for (int i = 1; i <= n ; i++)
            for (int j = 1; j <= n; j++)
                c[i][j] = sc.nextInt();

        System.out.println("Enter source vertex");
        int sv = sc.nextInt();

        dij(c, n, sv, path, visited, dist);
        printPath(n, sv, path, visited, dist);
    }

    static void dij(int[][] c, int n, int sv, int[] path, int[] visited, int[] dist) {
        for (int i = 1; i <= n; i++) {
            dist[i] = c[sv][i];
            path[i] = dist[i] == 999 ? 0 : sv;
        }

        int count = 1;
        while (count <= n) {
            int min = 999, v = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0 && dist[i] < min) {
                    min = dist[i];
                    v = i;
                }
            }
            visited[v] = 1;
            count++;
            for (int i = 1; i <= n; i++) {
                if (dist[i] > (dist[v] + c[v][i])) {
                    dist[i] = dist[v] + c[v][i];
                    path[i] = v;
                }
            }
        }
    }

    static void printPath(int n, int sv, int[] path, int[] visited, int[] dist) {
        for (int i = 1; i <= n; i++) {
            if (visited[i] != 0 && i != sv) {
                System.out.println("Shortest path cost from " + sv + " to " + i + ": " + dist[i]);
                System.out.print("Path: " + i);
                int j = path[i];
                while (j != sv) {
                    System.out.printf("<-->%d", j);
                    j = path[j];
                }
                System.out.println("<-->" + sv);
            }
        }
    }
}