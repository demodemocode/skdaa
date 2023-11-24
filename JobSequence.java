import java.util.*;
public class JobSequence {

public static int getMaxProfit(int[] profit, int[] deadline,int[] seq, int n)
 {
List<int[]> jobs = new ArrayList<>();

for (int i = 0; i < n; i++) 
{
jobs.add(new int[]{profit[i], deadline[i],seq[i]});
}

jobs.sort((a, b) -> Integer.compare(b[0], a[0]));
int[] total = new int[Arrays.stream(deadline).max().getAsInt() + 1];
int[] total1 = new int[Arrays.stream(deadline).max().getAsInt() + 1];

for (int i = 0; i < n;i++) {
for (int day = jobs.get(i)[1]; day > 0; day--) {
if (total[day] == 0) {
total[day] = jobs.get(i)[0];
total1[day] = jobs.get(i)[2];


break;
 }
 }
 }
int maxProfit = Arrays.stream(total).sum();

for(int i=0;i<seq.length;i++)
{if(total1[i]!=0)
{
System.out.print(total1[i]+",");
}
}
return maxProfit;
 }
 public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 
 System.out.print("Number of elements: ");
 int n = scanner.nextInt();
 
 int[] profit = new int[n];
 int[] deadline = new int[n];
 		int seq[] = new int[n];

System.out.println("Enter Profit amount: ");
 for (int i = 0; i < n; i++) {
profit[i] = scanner.nextInt();
seq[i] = i + 1;
}
System.out.println("Enter deadline: ");
for (int i = 0; i < n; i++) {
 deadline[i] = scanner.nextInt();
}
int maxProfit = getMaxProfit(profit, deadline,seq, n);
System.out.println("Max profit is: " + maxProfit);


}
}