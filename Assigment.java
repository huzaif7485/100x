import java.util.*;

class Node {
    Node parent;
    int pathCost;
    int cost;
    int workerID;
    int jobID;
    boolean assigned[];

    public Node(int N) {
        assigned = new boolean[N];
    }
}



public class Assigment {

    // write your code here 
    static final int N = 4;

    static Node newNode(int x, int y, boolean assigned[], Node parent) {
        Node node = new Node(N);
        for (int j = 0; j < N; j++)
            node.assigned[j] = assigned[j];
        if (y != -1)
            node.assigned[y] = true;

        node.parent = parent;
        node.workerID = x;
        node.jobID = y;
        return node;
    }

    static int calculateCost(int costMatrix[][], int x, int y, boolean assigned[]) {
        int cost = 0;
        boolean available[] = new boolean[N];
        Arrays.fill(available, true);

        for (int i = x + 1; i < N; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < N; j++) {
                if (!assigned[j] && available[j] && costMatrix[i][j] < min) {
                    minIndex = j;
                    min = costMatrix[i][j];
                }
            }
            cost += min;
            available[minIndex] = false;
        }
        return cost;
    }

    static void printAssignments (Node min) {
        if (min.parent == null) 
            return;
            printAssignments(min.parent);
            System.out.println("Assign Worker " + (char)(min.workerID + 'A') + " to Job " + min.jobID);
        }
    
        static int findMinCost(int costMatrix[][], int[] ids) {
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
            boolean assigned[] = new boolean[N];
            Node root = newNode(-1, -1, assigned, null);
            root.pathCost = root.cost = 0;
            root.workerID = -1;
            pq.add(root);
    
            while (!pq.isEmpty()) {
                Node min = pq.poll();
                int i = min.workerID + 1;
                if (i == N) {
                    printAssignments(min);
                    return min.cost;
                }
                for (int j = 0; j < N; j++) {
                    if (!min.assigned[j]) {
                        Node child = newNode(ids[i], j, min.assigned, min);
                        child.pathCost = min.pathCost + costMatrix[i][j];
                        child.cost = child.pathCost + calculateCost(costMatrix, i, j, child.assigned);
                        pq.add(child);
                    }
                }
            }
            return 0;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of workers: ");
    int n = sc.nextInt();
    int[] ids = new int[n];
    int[][] c = new int[n][n];
    System.out.println("Enter worker IDs: ");
    for (int i = 0; i < n; i++)
    ids[i] = (int)(sc.next().charAt(0)) - (int)('A');
    System.out.println("Enter the cost matrix: ");
    for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
    c[i][j] = sc.nextInt();
    
    
    
    
    
    
    
    
    
    
            System.out.println("Optimal cost is " + findMinCost(c, ids));
        } 
}