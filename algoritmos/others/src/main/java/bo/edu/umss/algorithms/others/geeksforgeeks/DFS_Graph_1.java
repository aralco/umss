package bo.edu.umss.algorithms.others.geeksforgeeks;

import java.util.*;

//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
//https://practice.geeksforgeeks.org/problems/nodes-at-even-distance/0
public class DFS_Graph_1 {
    List<LinkedList<Edge>> vertices;
    boolean[] visited;

    DFS_Graph_1(int n) {
        vertices = new ArrayList<>(n);
        for(int i=0;i<n;i++) {
            vertices.add(i, new LinkedList<>());
        }
        visited = new boolean[n];
        Arrays.fill(visited, false);

    }

    void addEdge(int origin, int destination, int weight)  {
        Edge edge = new Edge(origin, destination, weight);
        vertices.get(origin).add(edge);
    }

    void print()    {
        for(int i=0;i<vertices.size();i++)    {
            StringBuilder vertexDestination = new StringBuilder();
            vertexDestination.append(i);
            LinkedList<Edge> edges = vertices.get(i);
            for(Edge e:edges)   {
                vertexDestination.append("-> ").append(e.destination);
            }
            System.out.println(vertexDestination.toString());
        }
    }

    //Depth First Search
    void dfs(int start) {
        if(!visited[start]) {
            System.out.print(start+" ");
            visited[start] = true;
            LinkedList<Edge> neighbors = vertices.get(start);
            for(Edge neighbor:neighbors) {
                if(!visited[neighbor.destination])
                    dfs(neighbor.destination);
            }
        }
    }
    //Breadth First Search
    void bfs(int start) {
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        while(!queue.isEmpty())   {
            int pivot = queue.remove();
            if(!visited[pivot])    {
                visited[pivot] = true;
                System.out.print(pivot+" ");
                for(Edge e:vertices.get(pivot))    {
                    if(!visited[e.destination])
                        queue.add(e.destination);
                }
            }
        }
    }

    static class Edge   {
        int origin;
        int destination;
        int weight;

        Edge(int origin, int destination, int weight) {
            this.origin = origin;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int t=1;t<=testCases;t++)    {
            int vertex = scanner.nextInt();
            int edges = scanner.nextInt();
            DFS_Graph_1 graph = new DFS_Graph_1(vertex);
            for(int e=0;e<edges;e++)    {
                int origin = scanner.nextInt();
                int destination = scanner.nextInt();
                graph.addEdge(origin, destination, 1);
            }
            graph.print();
            System.out.println("DFS");
            graph.dfs(2);
            System.out.println("\nBFS");
            Arrays.fill(graph.visited, false);
            graph.bfs(2);
        }
    }
}
//TestCase
/*
in:
1
4 6
0 1
0 2
1 2
2 0
2 3
3 3

out:
DFS
2 0 1 3
BFS
2 0 3 1
*/