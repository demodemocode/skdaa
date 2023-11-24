import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class a6 {

    // Node class to represent decisions in the branch and bound tree
    static class Node implements Comparable<Node> {
        int level; // Student number
        int[] assigned; // Assignments
        int cost; // Current cost
        boolean[] assignedClubs; // Clubs already assigned

        Node(int level, int[] assigned, boolean[] assignedClubs, int cost) {
            this.level = level;
            this.assigned = assigned.clone();
            this.assignedClubs = assignedClubs.clone();
            this.cost = cost;
        }

        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public int findMinimumCostAssignment(int[][] costMatrix) {
        int n = costMatrix.length;
        int[] assigned = new int[n];
        boolean[] assignedClubs = new boolean[n];
        Arrays.fill(assigned, -1); // -1 indicates no assignment

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(-1, assigned, assignedClubs, 0));

        while (!pq.isEmpty()) {
            Node min = pq.poll();
            int i = min.level + 1;

            if (i == n) {
                printAssignments(min, costMatrix);
                return min.cost; // All students are assigned to a club
            }

            for (int j = 0; j < n; j++) {
                if (!min.assignedClubs[j]) { // Check if club is not yet assigned
                    int[] newAssigned = min.assigned.clone();
                    boolean[] newAssignedClubs = min.assignedClubs.clone();
                    newAssigned[i] = j;
                    newAssignedClubs[j] = true;

                    Node child = new Node(i, newAssigned, newAssignedClubs, min.cost + costMatrix[i][j]);
                    pq.add(child);
                }
            }
        }
        return -1; // No feasible assignment
    }

    private void printAssignments(Node node, int[][] costMatrix) {
        System.out.println("Assignments and Costs:");
        for (int i = 0; i < node.assigned.length; i++) {
            int club = node.assigned[i];
            int cost = costMatrix[i][club];
            System.out.println("Student " + i + " is assigned to Club " + club + " with Cost " + cost);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        a6 ca = new a6();

        System.out.println("Enter the number of Student: ");
        int n = sc.nextInt();

        int[][] costMatrix = new int[n][n];

        System.out.println("Enter the cost Matrix: ");
        for(int i=0; i<n; i++){
            for(int j = 0; j<n; j++){
                costMatrix[i][j] = sc.nextInt();
            }
        }

        int minCost = ca.findMinimumCostAssignment(costMatrix);
        System.out.println("Minimum total cost: " + minCost);
    }
}