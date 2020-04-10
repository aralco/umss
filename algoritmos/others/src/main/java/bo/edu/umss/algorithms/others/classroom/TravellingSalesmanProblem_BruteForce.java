package bo.edu.umss.algorithms.others.classroom;

import java.util.*;

public class TravellingSalesmanProblem_BruteForce {

    static void calculateShortestRoute(int[][] adjacentMatrix) {
        List<Integer> elements = new ArrayList<>(adjacentMatrix.length-1);
        for(int e=1;e<adjacentMatrix.length;e++)
            elements.add(e);

        System.out.println("=====Route permutations=====");
        List<List<Integer>> routePermutations = generateRoutePermutations(elements);
        List<Integer> shortestRoute = new ArrayList<>(adjacentMatrix.length+1);
        int minWeight = Integer.MAX_VALUE;
        int tmpWeight;
        for (List<Integer> route:routePermutations) {
            route.add(0, 0);
            route.add(0);
            System.out.print(route);
            tmpWeight = calculateRouteDistance(adjacentMatrix, route);
            System.out.println(" , Weight="+tmpWeight);
            if(tmpWeight<minWeight) {
                minWeight = tmpWeight;
                shortestRoute = route;
            }
        }

        System.out.println("=====Shortest Route - Min Weight=====");
        System.out.println(shortestRoute + " , Weight="+minWeight);
    }

    static List<List<Integer>> generateRoutePermutations(List<Integer> elements)  {
        int permutationSize = factorial(elements.size());
        System.out.println("---Number of permutations is:"+permutationSize);
        List<List<Integer>> permutations = new ArrayList<>(permutationSize);
        for(int i=0;i<permutationSize;i++)
            permutations.add(permutation(i, elements));
        return permutations;
    }

    static int calculateRouteDistance(int[][] map, List<Integer> route)    {
        int distance = 0;
        for(int i=0;i<route.size()-1;i++) {
            distance = distance + distance(map, route.get(i), route.get(i+1));
        }
        return distance;
    }

    static int distance(int[][] route, int origin, int destination)    {
        return route[origin][destination];
    }

    static int factorial(int n) {
        if(n==0)
            return 1;
        return n*factorial(n-1);
    }

    static List<Integer> permutation(int no, List<Integer> elements) {
        return permutationHelper(no,
                new LinkedList<>(elements),
                new ArrayList<>());
    }

    static List<Integer> permutationHelper(long no, LinkedList<Integer> in, List<Integer> out) {
        if (in.isEmpty())
            return out;
        long subFactorial = factorial(in.size() - 1);
        out.add(in.remove((int) (no / subFactorial)));
        return permutationHelper((int) (no % subFactorial), in, out);
    }

    public static void main(String[] args) {
        System.out.println("=====TSP - Traveller Salesman Problem=====");
        int[][] adjacencyMatrix = new int[][]{
            //(n-1)! = (4-1)! = 6 permutations
            {0, 3, 8, 5},
            {3, 0, 7, 2},
            {8, 7, 0, 6},
            {5, 2, 6, 0}
            //[0, 1, 3, 2, 0] , Weight=19
        };
        for (int[] adjacentArray : adjacencyMatrix)
            System.out.println(Arrays.toString(adjacentArray));
        calculateShortestRoute(adjacencyMatrix);
    }

}

/** Output
 =====TSP - Traveller Salesman Problem=====
 [0, 3, 8, 5]
 [3, 0, 7, 2]
 [8, 7, 0, 6]
 [5, 2, 6, 0]
 =====Route permutations=====
 ---Number of permutations is:6
 [0, 1, 2, 3, 0] , Weight=21
 [0, 1, 3, 2, 0] , Weight=19
 [0, 2, 1, 3, 0] , Weight=22
 [0, 2, 3, 1, 0] , Weight=19
 [0, 3, 1, 2, 0] , Weight=22
 [0, 3, 2, 1, 0] , Weight=21
 =====Shortest Route - Min Weight=====
 [0, 1, 3, 2, 0] , Weight=19
*/

//(n-1)! = (13-1)! = 479001600 permutations
//                        {0, 3, 8, 5, 8, 3, 1, 9, 8, 10, 5, 11, 9},
//                        {3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
//                        {8, 1, 0, 5, 8, 3, 1, 9, 8, 10, 5, 11, 9},
//                        {5, 2, 8, 0, 8, 3, 1, 9, 8, 10, 5, 11, 9},
//                        {8, 3, 8, 5, 0, 3, 1, 9, 8, 10, 5, 11, 9},
//                        {3, 4, 8, 5, 8, 0, 1, 9, 8, 10, 5, 11, 9},
//                        {1, 5, 8, 5, 8, 3, 0, 9, 8, 10, 5, 11, 9},
//                        {9, 6, 8, 5, 8, 3, 1, 0, 8, 10, 5, 11, 9},
//                        {8, 7, 8, 5, 8, 3, 1, 9, 0, 10, 5, 11, 9},
//                        {10, 8, 8, 5, 8, 3, 1, 9, 8, 0, 5, 11, 9},
//                        {5, 9, 8, 5, 8, 3, 1, 9, 8, 10, 0, 11, 9},
//                        {11, 10, 8, 5, 8, 3, 1, 9, 8, 1, 5, 0, 15},
//                        {9, 11, 8, 5, 8, 3, 1, 9, 8, 10, 5, 11, 0}
//OutOfMemory
//[0, 3, 1, 2, 4, 5, 7, 8, 10, 11, 9, 12, 6, 0] , Weight=64

//(n-1)! = (12-1)! = 39916800 permutations
//                        {0, 3, 8, 5, 8, 3, 1, 9, 8, 10, 5, 11},
//                        {3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
//                        {8, 1, 0, 5, 8, 3, 1, 9, 8, 10, 5, 9},
//                        {5, 2, 8, 0, 8, 3, 1, 9, 8, 10, 11, 9},
//                        {8, 3, 8, 5, 0, 3, 1, 9, 8, 5, 11, 9},
//                        {3, 4, 8, 5, 8, 0, 1, 9, 10, 5, 11, 9},
//                        {1, 5, 8, 5, 8, 3, 0, 8, 10, 5, 11, 9},
//                        {9, 6, 8, 5, 8, 3, 1, 0, 8, 10, 5, 7},
//                        {8, 7, 8, 5, 8, 3, 1, 9, 0, 10, 5, 3},
//                        {10, 8, 8, 5, 8, 3, 1, 9, 8, 0, 5, 1},
//                        {5, 9, 8, 5, 8, 3, 1, 9, 8, 10, 0, 9},
//                        {11, 10, 8, 5, 8, 3, 1, 9, 8, 1, 5, 0}
//OutOfMemory
//[0, 3, 1, 2, 4, 5, 7, 8, 11, 9, 10, 6, 0] , Weight=47

/********************************Breakpoint**********************************/
//(n-1)! = (11-1)! = 3628800 permutations
//                {0, 3, 8, 5, 3, 1, 2, 6, 10, 4, 1},
//                {3, 0, 1, 3, 4, 5, 6, 7, 8, 9, 10},
//                {8, 1, 0, 5, 3, 1, 4, 8, 2, 2, 9},
//                {5, 3, 5, 0, 8, 2, 9, 8, 6, 11, 9},
//                {3, 4, 3, 8, 0, 3, 6, 9, 5, 4, 2},
//                {1, 5, 1, 2, 3, 0, 1, 1, 4, 2, 7},
//                {2, 6, 4, 9, 6, 1, 0, 6, 5, 1, 4},
//                {6, 7, 8, 8, 9, 1, 6, 0, 8, 5, 7},
//                {10, 8, 2, 6, 5, 4, 5, 8, 0, 5, 2},
//                {4, 9, 2, 11, 4, 2, 1, 5, 5, 0, 10},
//                {1, 10, 9, 9, 2, 7, 4, 7, 2, 10, 0}
//[0, 4, 10, 8, 2, 1, 3, 5, 7, 9, 6, 0] , Weight=24

//(n-1)! = (10-1)! = 362880 permutations
//                {0, 3, 8, 5, 4, 10, 1, 3, 11},
//                {3, 0, 7, 2, 3, 9, 2, 1, 6},
//                {8, 7, 0, 6, 1, 3, 4, 4, 7},
//                {5, 2, 6, 0, 2, 1, 12, 9, 2},
//                {5, 2, 6, 3, 0, 3, 10, 5, 3},
//                {5, 2, 6, 3, 4, 0, 8, 1, 9},
//                {5, 2, 6, 3, 4, 4, 0, 7, 3},
//                {5, 2, 3, 4, 4, 6, 9, 0, 2},
//                {5, 2, 3, 4, 4, 6, 9, 7, 0}
//[0, 6, 3, 5, 7, 8, 2, 4, 9, 1, 0] , Weight=18


//(n-1)! = (9-1)! = 40320 permutations
//                {0, 3, 8, 5, 4, 10, 1, 3, 11},
//                {3, 0, 7, 2, 3, 9, 2, 1, 6},
//                {8, 7, 0, 6, 1, 3, 4, 4, 7},
//                {5, 2, 6, 0, 2, 1, 12, 9, 2},
//                {5, 2, 6, 3, 0, 3, 10, 5, 3},
//                {5, 2, 6, 3, 4, 0, 8, 1, 9},
//                {5, 2, 6, 3, 4, 4, 0, 7, 3},
//                {5, 2, 3, 4, 4, 6, 9, 0, 2},
//                {5, 2, 3, 4, 4, 6, 9, 7, 0}
//[0, 6, 3, 5, 7, 8, 2, 4, 1, 0] , Weight=17

//(n-1)! = (8-1)! = 5040 permutations
//                {0, 3, 8, 5, 4, 10, 1, 3},
//                {3, 0, 7, 2, 3, 9, 2, 1},
//                {8, 7, 0, 6, 1, 3, 4, 4},
//                {5, 2, 6, 0, 2, 1, 12, 12},
//                {5, 2, 6, 3, 0, 3, 10, 5},
//                {5, 2, 6, 3, 4, 0, 8, 1},
//                {5, 2, 6, 3, 4, 4, 0, 7},
//                {5, 2, 3, 4, 4, 6, 9, 0}
//[0, 6, 3, 5, 7, 2, 4, 1, 0] , Weight=15

//(n-1)! = (7-1)! = 720 permutations
//                {0, 3, 8, 5, 4, 10, 1},
//                {3, 0, 7, 2, 3, 9, 2},
//                {8, 7, 0, 6, 1, 3, 4},
//                {5, 2, 6, 0, 2, 1, 12},
//                {5, 2, 6, 3, 0, 3, 10},
//                {5, 2, 6, 3, 4, 0, 8},
//                {5, 2, 6, 3, 4, 4, 0}
//[0, 6, 2, 4, 3, 5, 1, 0] , Weight=17

//(n-1)! = (6-1)! = 120 permutations
//                {0, 3, 8, 5, 4, 10},
//                {3, 0, 7, 2, 3, 9},
//                {8, 7, 0, 6, 1, 3},
//                {5, 2, 6, 0, 2, 1},
//                {5, 2, 6, 3, 0, 3},
//                {5, 2, 6, 3, 4, 0}
//[0, 1, 3, 5, 2, 4, 0] , Weight=18

//(n-1)! = (5-1)! = 24 permutations
//                {0, 3, 8, 5, 4},
//                {3, 0, 7, 2, 3},
//                {8, 7, 0, 6, 1},
//                {5, 2, 6, 0, 2},
//                {5, 2, 6, 3, 0}
//[0, 1, 3, 2, 4, 0] , Weight=17


//(n-1)! = (4-1)! = 6 permutations
//                {0, 3, 8, 5},
//                {3, 0, 7, 2},
//                {8, 7, 0, 6},
//                {5, 2, 6, 0}
//[0, 1, 3, 2, 0] , Weight=19
