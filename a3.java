import java.util.*;

public class a3
{
public static void main(String [] args)
{
Scanner sc=new Scanner(System.in);
System.out.println("Enter the no of rows and columns");
int a = sc.nextInt();
int b= sc.nextInt();

int[][] mat= new int[a][b];
int[][] matr=new int[a][b];

System.out.println("Enter the matrix:");
for(int i=0;i<a;i++)
{
for(int j=0;j<a;j++)
{
mat[i][j]=sc.nextInt();
}
}


for(int k=0;k<a;k++)
{
for(int i=0;i<a;i++)
{
for(int j=0;j<a;j++)
{
if(i==j||i==k||j==k)
{
matr[i][j]=mat[i][j];
}
else
{
matr[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);
}
}
}
for(int i=0;i<b;i++)
 {
 for(int j=0;j<b;j++)
 {
 mat[i][j]=matr[i][j];
 }
 }
 
}

System.out.println("Your sorted matrix is:");
for(int i=0;i<a;i++)
{
for(int j=0;j<a;j++)
{
System.out.print(mat[i][j]+" ");
}
System.out.println("");
}
}
}



//TC n3
//SC n2
