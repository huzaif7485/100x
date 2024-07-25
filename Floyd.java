import java.util.*;

public class Floyd {
    static int min(int l, int r) {
        return l < r ? l : r;
    }

    static void floyd(int[][] a, int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    a[i][j] = min(a[i][j], a[i][k] + a[k][j]);
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
        floyd(a, n);

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