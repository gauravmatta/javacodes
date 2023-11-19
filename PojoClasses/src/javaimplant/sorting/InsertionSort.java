package javaimplant.sorting;

public class InsertionSort {
	public static void main(String[] args) {
		int arr[] = {7,8,3,1,2};
		logic1(arr);
		printArray(arr);
	}
	
	private static void printArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
	private static int[] logic1(int arr[]) {
		for(int i=1;i<arr.length;i++) {
			System.out.println("New Iteration===>");
			printArray(arr);
			int current = arr[i];
			int j= i-1;
			while(j >= 0 && current<arr[j]) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=current;
		}
		return arr;
	}
}
