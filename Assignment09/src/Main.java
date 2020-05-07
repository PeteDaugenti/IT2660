import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static int randomNums() {
		
		Random rand = new Random();
		return rand.nextInt(100);
	}
	
	public static int randomNums2() {
		
		Random rand = new Random();
		return rand.nextInt(5);
	}
	
	public static int generateRandomInt(int min, int max){
		
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }
	
    public static void main(String [] args) {
        int MAX = 300;
        int firstVertex2 = MAX-1;

        int searchNumber;
        Scanner scan = new Scanner(System.in);
        Graph graph = new Graph(301);
        
        System.out.println("Enter a number between 1 and 300");
        searchNumber = Integer.parseInt(scan.nextLine());
        
        for (int i = 0; i < 100; i++) {
            Listing newListing = new Listing((int) generateRandomInt(1, 300));
            graph.insertVertex(i, newListing);

        }
        for (int j = 0; j < 100; j++) {
            int toVertex = randomNums2();
            for (int k = 0; k <= toVertex; k++) {
                int randomVertex = generateRandomInt(1, 300);
                graph.insertEdge(j, randomVertex);
            }

        }

        System.out.println("Depth first traversal for " + searchNumber);
        graph.DFS(searchNumber);
        System.out.println("Breadth first traversal for " + searchNumber);
        graph.BFS(searchNumber);
        graph.dijkstraAlgorithm(searchNumber);


    }
}

