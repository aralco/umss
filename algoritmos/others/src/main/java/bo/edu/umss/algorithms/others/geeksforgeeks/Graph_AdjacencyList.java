package bo.edu.umss.algorithms.others.geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/print-adjacency-list/0
public class Graph_AdjacencyList {
    List<LinkedList<Edge>> vertices;

    Graph_AdjacencyList(int n) {
        vertices = new ArrayList<>(n);
        for(int i=0;i<n;i++) {
            vertices.add(i, new LinkedList<>());
        }
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
            Graph_AdjacencyList graph = new Graph_AdjacencyList(vertex);
            for(int e=0;e<edges;e++)    {
                int origin = scanner.nextInt();
                int destination = scanner.nextInt();
                graph.addEdge(origin, destination, 1);
                graph.addEdge(destination, origin, 1);
            }
            graph.print();
        }
    }
}
