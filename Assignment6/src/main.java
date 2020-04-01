import java.util.Random;
public class main {

	public static void randomNumberList(int[] array) {
		Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rand.nextInt(100);
		}
	}
	
	public static void printList(int[] m) {
		for(int i = 0; i < m.length; i ++) {
			System.out.println(m[i]);
		}
	}
	
	public static int[] mergeSort(int[] m) {
		if(m.length <= 1) {
			return m;
		}
		
		int[] left = new int[m.length/2];
		int[] right = new int[m.length - left.length];
		int j = 0;
		for(int i = 0; i < m.length; i++) {
			if(i < m.length/2) {
				left[i] = m[i];
			}else {
				right[j] = m[i];
				j++;
			}
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		return merge(left, right);
	}
	
	public static int[] merge(int[] Left, int[] Right) {
		int[] list = new int[Left.length + Right.length];
		int n = 0;
		while(Left.length != 0 && Right.length != 0) {
			if(Left[0] <= Right[0]) {
				list[n] = Left[0];
				Left = deleteFirst(Left);
				n++;
			}else {
				list[n] = Right[0];
				Right = deleteFirst(Right);
				n++;
			}
		}
		
		if(Left.length != 0) {
			for(int i = 0; i < Left.length; i++) {
				list[n] = Left[i];
				n++;
			}
		}
		if(Right.length != 0) {
			for(int i = 0; i < Right.length; i++) {
				list[n] = Right[i];
				n++;
			}
		}
		return list;
	}
	
	public static int[] deleteFirst(int[] array) {
		int[] tempArray = new int[array.length - 1];
		for(int i = 0; i < tempArray.length; i++) {
			tempArray[i] = array[i + 1];
		}
		return tempArray;
	}
	
	public static void main(String[] args) {
		int[] list = new int[100];
		randomNumberList(list);
		printList(list);
		int[] sortedList = mergeSort(list);
		printList(sortedList);
	}
	
}
