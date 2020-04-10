package bo.edu.umss.algorithms.exams.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GiraDePromocion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        for(int t=1;t<=testCases;t++)   {
            //comment for submission
            //String input = bufferedReader.readLine();
            int m = Integer.parseInt(bufferedReader.readLine());
            int n = Integer.parseInt(bufferedReader.readLine());
            Graph graph = new Graph();
            for(int i=0;i<n;i++)    {
                StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
                String originVertex = tokenizer.nextToken();
                String destinyVertex = tokenizer.nextToken();
                int weight = Integer.parseInt(tokenizer.nextToken());
                graph.addEdge(originVertex, destinyVertex, weight);
                graph.addEdge(destinyVertex, originVertex, weight);
            }
            prims(graph);
        }
    }

    static void prims(Graph graph)   {
        Map<String, Vertex> vertices = new HashMap();
        PriorityQueue<Vertex> vertexPriorityQueue = new PriorityQueue<>();
        int i=0;
        for(Map.Entry<String, LinkedList<Edge>> entry:graph.vertices.entrySet()) {
            Vertex vertex = new Vertex(entry.getKey(),Integer.MAX_VALUE,null);
            vertices.put(entry.getKey(), vertex);
            vertexPriorityQueue.add(vertex);
            if(i==0)
                vertex.key=0;
            i++;
        }
        Set<Vertex> mstSet = new HashSet<>();
        int total=0;
        while(!vertexPriorityQueue.isEmpty()) {
            Vertex min = vertexPriorityQueue.poll();
            mstSet.add(min);
            total = total+min.key;
            for(Edge e:graph.vertices.get(min.index))  {
                Vertex v = vertices.get(e.destination);
                if(v.key>e.weight && !mstSet.contains(v))    {
                    vertexPriorityQueue.remove(v);
                    v.key = e.weight;
                    v.parent = e.origin;
                    vertexPriorityQueue.add(v);
                }
            }
        }
        System.out.println(total);
    }

    static class Graph {
        Map<String, LinkedList<Edge>> vertices;

        Graph() {
            vertices = new HashMap<>();
        }

        void addEdge(String origin, String destination, int weight) {
            addVertex(origin, destination);
            Edge edge = new Edge(origin, destination, weight);
            vertices.get(origin).add(edge);

        }

        void addVertex(String... vertex)   {
            for (String v:vertex) {
                if(!vertices.containsKey(v))
                    vertices.put(v, new LinkedList<>());
            }
        }

        void print() {
            for(Map.Entry<String, LinkedList<Edge>> entry:vertices.entrySet()) {
                StringBuilder adjacentList = new StringBuilder();
                adjacentList.append(entry.getKey());
                LinkedList<Edge> edges = vertices.get(entry.getKey());
                for(Edge e : edges) {
                    adjacentList.append("-> ").append(e.destination);
                }
                System.out.println(adjacentList.toString());
            }
        }

    }


    static class Edge implements Comparable<Edge> {
        String origin;
        String destination;
        int weight;

        Edge(String origin, String destination, int weight) {
            this.origin = origin;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight-e.weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "origin=" + origin +
                    ", destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class Vertex implements Comparable<Vertex>{
        String index;
        int key;
        String parent;

        Vertex(String index, int key, String parent) {
            this.index = index;
            this.key = key;
            this.parent = parent;
        }

        @Override
        public int compareTo(Vertex v) {
            if(this.key>v.key)
                return 1;
            else if (v.key>this.key)
                return -1;
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex vertex = (Vertex) o;

            if (key != vertex.key) return false;
            if (index != null ? !index.equals(vertex.index) : vertex.index != null) return false;
            return parent != null ? parent.equals(vertex.parent) : vertex.parent == null;
        }

        @Override
        public int hashCode() {
            int result = index != null ? index.hashCode() : 0;
            result = 31 * result + key;
            result = 31 * result + (parent != null ? parent.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "index=" + index +
                    ", key=" + key +
                    ", parent=" + parent +
                    '}';
        }
    }

}

/**
 1

 4
 5
 oruro laPaz 6
 oruro tarija 5
 laPaz tarija 1
 laPaz beni 2
 tarija beni 10

 out:
 8

 9
 14
 0 1 4
 0 7 8
 1 7 11
 1 2 8
 2 8 2
 2 3 7
 2 5 4
 3 5 14
 3 4 9
 4 5 10
 5 6 2
 6 7 1
 6 8 6
 7 8 7

 out:
 37

 */