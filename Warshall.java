import java.util.*;

public class Warshall {
    static int min(int l, int r) {
        return l < r ? l : r;
    }

    static void warshall(int[][] a, int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    a[i][j] = (a[i][j] != 0) || ((a[i][k] != 0) && (a[k][j] != 0)) ? 1 : 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[10][10];
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();

        System.out.println("Enter the adjacency matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        warshall(a, n);

        System.out.println("All pairs shorted path matrix:");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}