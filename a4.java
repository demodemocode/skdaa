import java.util.*;
public class a4{
public static void dij(int[][] graph,int source)
{
int max_value=999;
int num_vert=graph.length;
boolean[] visited=new boolean[num_vert];
int[] dist= new int[num_vert];

for(int i=0;i<num_vert;i++)
{
dist[i]=max_value;
visited[i]=false;
}
dist[source]=0;

for(int count=0;count<num_vert-1;count++)
{
int u=-1;
for(int i=0;i<num_vert;i++)
{
if(!visited[i] && (u==-1||dist[i]<dist[u]))
{
u=i;
}
}

visited[u]=true;
for(int v=0;v<num_vert;v++)
{
if(!visited[v] && graph[u][v]!=0 && dist[u]!=max_value && dist[u]+graph[u][v]<dist[v])
{
dist[v]=dist[u]+graph[u][v];
}
}
}
System.out.println("VERTEX\t\t\t\tDISTANCE");
for(int i=0;i<num_vert;i++)
{
System.out.println(i+"\t\t\t"+dist[i]);
}
}

public static void main(String[] args)
{
Scanner scanner=new Scanner(System.in);
System.out.println("Enter the no of nodes:");
int nodes=scanner.nextInt();

int[][] input=new int[nodes][nodes];
System.out.println("Enter the values of graph in matrix:");
for(int i=0;i<nodes;i++)
{
for(int j=0;j<nodes;j++)
{
input[i][j]=scanner.nextInt();
}
}
System.out.println("Enter the source node");
int source=scanner.nextInt();

dij(input,source);
}
}

