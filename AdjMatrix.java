
// Dana Sader

import java.util.*;

public class AdjMatrix {

    public static int inDegree(int k, int[][] m) {

        // iterates through the rows in the Adjacency Matrix where the edge is pointed towards the node
        int Degree = 0;

        for (int i = 0; i < m.length; i++)
            Degree += m[i][k];
        return Degree;
    }

    public static int outDegree(int k, int[][] m) {


        //iterates through the columns in the Adjacency Matrix when the edge leaves a node
        int Degree= 0;

        for (int i = 0; i < m.length; i++)
            Degree += m[k][i];
        return Degree;
    }

    public static List<Integer> adjacent(int k, int[][] m) {

        /* all the neighbouring nodes for node k
    will be inserted to the Adjacency Matrix */
        LinkedList<Integer> Adjnode = new LinkedList<Integer>();
        for (int i = 0; i < m.length; i++)
            if (m[k][i] > 0)
                Adjnode.add(i);
        return Adjnode;
    }

    public static boolean hasTriangle(int[][] m) {  /* This Method iterates through all nodes
    of the graph using Adjacency Matrix */

        for (int i = 0; i < m.length; i++) {
            List<Integer> a = adjacent(i, m);
            for (Integer b : a) {
                List<Integer> c = adjacent(b, m);
                for (Integer d : c) {
                    List<Integer> e = adjacent(d, m);
                    for (Integer h : e) {
                        if (i != b && i != d && i == h) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {

        int[][] Adjmatrix =  {   {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0}
        };

        for (int i = 0; i <= 5; i++) {

            int inDegree = inDegree(i,Adjmatrix);
            System.out.println("InDegree " + i +  inDegree);
            int outDegree = outDegree(i, Adjmatrix);
            System.out.println("OutDegree " + i +  outDegree);
            System.out.println(hasTriangle(Adjmatrix));
        }
    }
}

