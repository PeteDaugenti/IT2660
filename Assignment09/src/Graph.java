import java.util.*;
import java.util.Queue;
import java.util.Stack;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Graph {
	
	public int vertexQuantity;
	Listing vertex[];
	int edge[][];
    int edgeWeight[][];
    int max, numVertices;
    int numVerticesIncluded;
    int a[][];
    int spt[][];

    private int randomNums3() {
        Random rand = new Random();
        int RandomNum = rand.nextInt(3);
        return RandomNum;
    }
    
    public Graph(int vertexValue)
    {
        vertex = new Listing[vertexValue];
        edge = new int[vertexValue][vertexValue];
        edgeWeight = new int[vertexValue][vertexValue];
        max = vertexValue;
        numVertices = 0;
    }
    
    public boolean insertVertex(int vertexNumber, Listing newListing)
    {
    	
        if (vertexNumber >= max)
            return false;
        vertex[vertexNumber] = newListing.deepCopy(); numVertices++;
        return true;
    }
    
    public boolean insertEdge(int fromVertex, int toVertex) {
    	
        if (vertex[fromVertex] == null || vertex[toVertex] == null) {
            return false;
        }
        
        if(edgeWeight[fromVertex][toVertex] >= 1)
        {
            return false;
        }
        edge[fromVertex][toVertex] = 1;
        edgeWeight[fromVertex][toVertex] = randomNums3();
        System.out.println("New edge at vertex " + fromVertex + " to " + toVertex + " with weight:" + + edgeWeight[fromVertex][toVertex]) ;
        return true;
    }

    public void BFS(int searchNumber) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> v = new ArrayList<>();
        for(int i = 0; i < numVertices; i++)
        {
            if(vertex[i] != null)
            {
                vertex[i].setPushed(false);
            }

        }
        queue.add(searchNumber);
        while (queue.size() != 0) {
            int nextListing;
            nextListing = queue.remove();
            
            if (!v.contains(nextListing)); {
                System.out.println("Went to: vertex "+ nextListing + " with value of: " + vertex[nextListing].getListing());
                
                if (vertex[nextListing].getListing() == searchNumber) {
                    System.out.println(searchNumber + "found at vertex" + v);
                }
                for (int i = 0; i < numVertices; i++)
                	
                    if (edge[nextListing][i] > 0 && !v.contains(i)) {
                        queue.add(i);
                    }
            }
        }
        
        if(queue.isEmpty())
        {
            System.out.println(searchNumber + " not found.");
        }
    }
    
    public void DFS(int searchNumber) {
        int v;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numVertices; i++) {
            {
            	
                if (vertex[i] != null)
                    vertex[i].setPushed(false);
            }
        }
        stack.push(searchNumber);
        vertex[searchNumber].setPushed(true);
        
        while (!stack.empty()) {
            v = stack.pop();
            vertex[v].visit(v);
            
            if(vertex[v].getListing() == searchNumber)
            {
                System.out.println(searchNumber + "found at vertex" + v);
            }
            System.out.println();
            for (int column = 0; column < numVertices; column++) {
            	
                if (edge[v][column] == 1 && !vertex[column].getPushed()) {
                    stack.push(column);
                    vertex[column].setPushed(true);
                }
            }
        }
        
        if(stack.isEmpty())
        {
            System.out.println(searchNumber + " not found..");
        }
    }

    public int[][] dijkstraAlgorithm(int searchNumber) {
        int numVerticesIncluded;

        int[] minPathLengths = new int[numVertices];
        int[] verticesIncluded = new int[numVertices];
        int[][] aCopy = a;
        int noEdge = Integer.MAX_VALUE;
        int noPath = Integer.MAX_VALUE;
        int minPath;
        int rowMin = 0;
        int colMin = 0;
        int weightMin = 0;
        int minWeight = 0;
        verticesIncluded[0] = searchNumber;
        numVerticesIncluded = 1;
        
        for (int i = 0; i < numVertices; i++) {
            minPathLengths[i] = noPath;
        }
        
        while (numVerticesIncluded < numVertices) {
            minPath = findMinWeightEdge(numVertices, aCopy, verticesIncluded, numVerticesIncluded, rowMin, colMin, minWeight);
            
            for (int i = 0; i < numVertices; i++) {
                aCopy[i][colMin] = noEdge;
            }
            spt[rowMin][colMin] = minWeight;
            minPathLengths[colMin] = minPath;
            verticesIncluded[numVerticesIncluded] = colMin;
            numVerticesIncluded++;
        }
        
        return spt;
    }
    
    public int findMinWeightEdge(int numVertices, int [][] aCopy, int[] verticesIncluded, int numVerticesIncluded, int rowMin, int colMin, int minWeight)
    {
        int index = -1;
        return index;
    }
}
