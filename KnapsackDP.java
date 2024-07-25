import java.util.Scanner;

public class KnapsackDP {

    static void display(int n, int[] w, int[] p) {
        for (int i = 1; i <= n; i++) {
            
        }
    }

    static void knapsack(int m, int n, int[] p, int[] w, int[][] t) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < w[i]) 
                    t[i][j] = t[i - 1][j];
                else 
                    t[i][j] = Integer.max(t[i - 1][j], t[i - 1][j - w[i]] + p[i]);
            }
        }
    }

    static void optimal(int m, int n, int[] w, int[][] t) {
        int i = n, k = m;
        while (i > 0 && k > 0) {
            if (t[i][k] != t[i - 1][k]) {
                System.out.println("Item: " + i + "\t Weight: " + w[i]);
                k -= w[i];
            }
            i--;
        }
        System.out.println("Total profit: " + t[n][m]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        System.out.printf("Enter %d profits:\n", n);
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++)
            p[i] = sc.nextInt();

        System.out.printf("Enter %d weights:\n", n);
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++)
            w[i] = sc.nextInt();

        System.out.print("Enter capacity: ");
        int m = sc.nextInt();

        int[][] t = new int[n + 1][m + 1];
        knapsack(m, n, p, w, t);

        System.out.println("Knapsack Table");
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++)
                System.out.print(t[i][j] + "\t");
            System.out.println();
        }

        optimal(m, n, w, t);
        sc.close();
    }
}
