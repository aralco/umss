package bo.edu.umss.algorithms.others.classroom;

import java.util.*;

public class TravellingSalesmanProblem_DynamicProgramming {
    static int[][] adjacencyMatrix;
    static Integer[][] memo;
    static Integer[][] verticesMemo;

    static void calculateShortestRoute(int[][] map) {
        adjacencyMatrix = map;
        int n = adjacencyMatrix.length;
        int state = 1;
        int k = 1 << n;
        memo = new Integer[n][k];
        verticesMemo = new Integer[n][k];

        // The finished state is when the finished state mask has all bits are set to
        // one (meaning all the nodes have been visited).
        int finishedState = k - 1;

        int minWeight = calculateShortestRoute(0, state, finishedState);
        List<Integer> shortestRoute = buildShortestRoute(state);
        System.out.println("=====Shortest Route - Min Weight=====");
        System.out.println(shortestRoute + " , Weight=" + minWeight);
    }

    static int calculateShortestRoute(int vertex, int state, int finishedState) {
        if (memo[vertex][state] != null)
            return memo[vertex][state];

        if (state == finishedState)
            return distance(vertex, 0);

        int minWeight = Integer.MAX_VALUE;
        int index = -1;
        for (int next = 0; next < adjacencyMatrix.length; next++) {
            // Skip if the next node has already been visited.
            int pivot = 1 << next;
            if ((state & pivot) == 0) {
                int nextState = state | pivot;
                int weight = distance(vertex, next) + calculateShortestRoute(next, nextState, finishedState);
                if (weight < minWeight) {
                    minWeight = weight;
                    index = next;
                }
            }
        }

        verticesMemo[vertex][state] = index;
        memo[vertex][state] = minWeight;
        return memo[vertex][state];
    }

    static int distance(int origin, int destination)    {
        return adjacencyMatrix[origin][destination];
    }

    static List<Integer> buildShortestRoute(int state) {
        List<Integer> shortestRoute = new ArrayList<>();
        int index = 0;
        while (true) {
            shortestRoute.add(index);
            Integer nextIndex = verticesMemo[index][state];
            if (nextIndex == null)
                break;
            int nextState = state | (1 << nextIndex);
            state = nextState;
            index = nextIndex;
        }
        shortestRoute.add(0);
        return shortestRoute;
    }

    public static void main(String[] args) {
        System.out.println("=====TSP - Traveller Salesman Problem=====");
        int[][] adjacencyMatrix = new int[][]{
                {0, 3, 8, 5, 3, 1, 2, 6, 10, 4, 1, 3, 4},
                {3, 0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2},
                {8, 1, 0, 5, 3, 1, 4, 8, 2, 2, 9, 7, 4},
                {5, 3, 5, 0, 8, 2, 9, 8, 6, 11, 9, 2, 7},
                {3, 4, 3, 8, 0, 3, 6, 9, 5, 4, 2, 5, 6},
                {1, 5, 1, 2, 3, 0, 1, 1, 4, 2, 7, 3, 1},
                {2, 6, 4, 9, 6, 1, 0, 6, 5, 1, 4, 4, 2},
                {6, 7, 8, 8, 9, 1, 6, 0, 8, 5, 7, 3, 8},
                {10, 8, 2, 6, 5, 4, 5, 8, 0, 5, 2, 1, 9},
                {4, 9, 2, 11, 4, 2, 1, 5, 5, 0, 10, 11, 1},
                {1, 10, 9, 9, 2, 7, 4, 7, 2, 10, 0, 4, 8},
                {3, 1, 7, 2, 5, 3, 4, 3, 1, 11, 4, 0, 9},
                {4, 2, 4, 7, 6, 1, 2, 8, 9, 1, 8, 9, 0}
        };
        for (int[] adjacentArray : adjacencyMatrix)
            System.out.println(Arrays.toString(adjacentArray));
        calculateShortestRoute(adjacencyMatrix);
    }
}

/** Output
 =====TSP - Traveller Salesman Problem=====
 [0, 3, 8, 5, 3, 1, 2, 6, 10, 4, 1, 3, 4]
 [3, 0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2]
 [8, 1, 0, 5, 3, 1, 4, 8, 2, 2, 9, 7, 4]
 [5, 3, 5, 0, 8, 2, 9, 8, 6, 11, 9, 2, 7]
 [3, 4, 3, 8, 0, 3, 6, 9, 5, 4, 2, 5, 6]
 [1, 5, 1, 2, 3, 0, 1, 1, 4, 2, 7, 3, 1]
 [2, 6, 4, 9, 6, 1, 0, 6, 5, 1, 4, 4, 2]
 [6, 7, 8, 8, 9, 1, 6, 0, 8, 5, 7, 3, 8]
 [10, 8, 2, 6, 5, 4, 5, 8, 0, 5, 2, 1, 9]
 [4, 9, 2, 11, 4, 2, 1, 5, 5, 0, 10, 11, 1]
 [1, 10, 9, 9, 2, 7, 4, 7, 2, 10, 0, 4, 8]
 [3, 1, 7, 2, 5, 3, 4, 3, 1, 11, 4, 0, 9]
 [4, 2, 4, 7, 6, 1, 2, 8, 9, 1, 8, 9, 0]
 =====Shortest Route - Min Weight=====
 [0, 4, 10, 8, 2, 1, 3, 11, 7, 5, 12, 9, 6, 0] , Weight=24
 */

//(n-1)! = (13-1)! = 479001600 permutations
//                        {0, 3, 8, 5, 3, 1, 2, 6, 10, 4, 1, 3, 4},
//                        {3, 0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2},
//                        {8, 1, 0, 5, 3, 1, 4, 8, 2, 2, 9, 7, 4},
//                        {5, 3, 5, 0, 8, 2, 9, 8, 6, 11, 9, 2, 7},
//                        {3, 4, 3, 8, 0, 3, 6, 9, 5, 4, 2, 5, 6},
//                        {1, 5, 1, 2, 3, 0, 1, 1, 4, 2, 7, 3, 1},
//                        {2, 6, 4, 9, 6, 1, 0, 6, 5, 1, 4, 4, 2},
//                        {6, 7, 8, 8, 9, 1, 6, 0, 8, 5, 7, 3, 8},
//                        {10, 8, 2, 6, 5, 4, 5, 8, 0, 5, 2, 1, 9},
//                        {4, 9, 2, 11, 4, 2, 1, 5, 5, 0, 10, 11, 1},
//                        {1, 10, 9, 9, 2, 7, 4, 7, 2, 10, 0, 4, 8},
//                        {3, 1, 7, 2, 5, 3, 4, 3, 1, 11, 4, 0, 9},
//                        {4, 2, 4, 7, 6, 1, 2, 8, 9, 1, 8, 9, 0}
//[0, 4, 10, 8, 2, 1, 3, 11, 7, 5, 12, 9, 6, 0] , Weight=24

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
