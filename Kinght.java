import java.util.Scanner;

public class Kinght {
    static int N_MIN = 5; // Minimum valid value for N
    static int N;

   public static boolean isValid(int i, int j, int sol[][]) {
 if (i>=1 && i<=N && j>=1 && j<=N) {
 if(sol[i][j]==-1)
 return true;
 }
 return false;
 }

    public static boolean knightTour(int sol[][], int i, int j, int stepCount, int xMove[], int yMove[]) {
        if (stepCount == N * N)
            return true;
        for (int k = 0; k < 8; k++) {
            int nextI = i + xMove[k];
            int nextJ = j + yMove[k];
            if (isValid(nextI, nextJ, sol)) {
                sol[nextI][nextJ] = stepCount;
                if (knightTour(sol, nextI, nextJ, stepCount + 1, xMove, yMove))
                    return true;
                sol[nextI][nextJ] = -1; // backtracking
            }
        }
        return false;
    }

    public static boolean startKnightTour() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the chessboard (N >= 5): ");
        N = scanner.nextInt();

        if (N < N_MIN) {
            System.out.println("Invalid input. N must be greater than or equal to 5.");
            return false;
        }

        int[][] sol = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sol[i][j] = -1;
            }
        }

        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        sol[1][1] = 0; // Placing knight at cell(1, 1)

        if (knightTour(sol, 1, 1, 1, xMove, yMove)) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(sol[i][j] + "\t");
                }
                System.out.println("\n");
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        startKnightTour();
    }
}
