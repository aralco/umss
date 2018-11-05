package bo.edu.umss.algorithms.competitions.contest7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//UVA - 10687 - G - Monitoring the Amazon
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1628

//http://www.algorithmist.com/index.php/UVa_10687
//https://github.com/lamphanviet/competitive-programming/blob/master/uva-online-judge/accepted-solutions/10687%20-%20Monitoring%20the%20Amazon.cpp
//https://github.com/Diusrex/UVA-Solutions/blob/master/10687%20Monitoring%20the%20Amazon.cpp
//https://github.com/shahed-shd/Online-Judge-Solutions/blob/master/UVa-Online-Judge/10687%20-%20Monitoring%20the%20Amazon.cpp
//http://codealltheproblems.blogspot.com/2015/09/uva-10687-monitoring-amazon.html
//http://sound-system-79.blogspot.com/2015/03/uva-10687-monitoring-amazon.html
//https://omarsebres.com/2012/10/27/10687-monitoring-the-amazon/
public class Main_G_MonitoringTheAmazon {
    public static void main(String[] args)  throws IOException  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        while((n = Integer.parseInt(bufferedReader.readLine()))>0)  {
            String input = bufferedReader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input);
            int[][] coordinates = new int[n][2];
            int[][] distances = new int[n][n];
            //filling coordinates matrix for each vertex
            for(int i=0;i<n;i++)    {
                coordinates[i][0] = Integer.parseInt(tokenizer.nextToken());
                coordinates[i][1] = Integer.parseInt(tokenizer.nextToken());
                distances[i][i] = -1;
            }
            //Filling distances matrix among vertices
            for(int i=0;i<n-1;i++)  {
                for(int j=i+1;j<n;j++)  {
                    distances[i][j] = distances[j][i] = distance(coordinates[i][0], coordinates[j][0],coordinates[i][1], coordinates[j][1]);
                }
            }
            System.out.println("coordinates matrix");
            //coordinates matrix
            for(int i=0;i<n;i++)    {
                System.out.println(Arrays.toString(coordinates[i]));
            }
            System.out.println("distances matrix");
            //distances matrix
            for(int i=0;i<n;i++)    {
                System.out.println(Arrays.toString(distances[i]));
            }
            Graph graph = new Graph(n);
            for(int v=0;v<n;v++)    {
                graph.addEdge(v, findNearestDestination(v, coordinates, distances) , 1);
                graph.addEdge(v, findNearestDestination(v, coordinates, distances), 1);
            }
            graph.print();
//            System.out.println("DFS");
//            graph.dfs(0);

        }
    }

    static int findNearestDestination(int start, int[][] coordinates, int[][] distances)   {
        //consider nearest distance choose 2 min distances
        //if more than 2 more min distances compare with coordinates x2<x1 || (x2==x1 && y2<y1)
        //consider the Graph outDegree to be <=2 for each vertex
        return 0;
    }

    static int distance(int x1, int x2, int y1, int y2)  {
        return (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
    }

    static class Graph {
        List<LinkedList<Edge>> vertices;
        boolean[] visited;

        Graph(int n) {
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

        int outDegree(int v)    {
            return vertices.get(v).size();
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
    }
}
