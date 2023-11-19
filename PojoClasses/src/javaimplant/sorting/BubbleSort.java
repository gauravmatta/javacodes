package javaimplant.sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = {7,8,3,1,2};
		logic1(arr);
	}
	
	private static void printArray(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}
	
	private static int[] logic1(int arr[]) {
		for(int i =0; i<=arr.length-1;i++) {
			System.out.println("Next Iteration===>");
			printArray(arr);
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					//swap
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}

}
