package javaimplant.arrays;

public class JavaArrayDemo {

	public static void main(String[] args) {
		int[] sourceArray= {1,2,3,4,5,6};
		int[] destinationArray=new int[3];
		System.arraycopy(sourceArray,3,destinationArray,0,2);
		for(int i:sourceArray)
		{
			System.out.println(i);
		}
		for(int j:destinationArray)
		{
			System.out.println(j);
		}
	}

}
