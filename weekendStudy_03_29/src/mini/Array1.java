package mini;

public class Array1 {
	public static void main(String[] args) {
		int[] array = {3, 24, 1, 55, 17, 43, 5};
		
		for(int i=0; i<array.length-1; i++ ) {
			for(int j=0;j<array.length-1; j++) {
				
				int temp01 = array[j];
				int temp02 = array[j+1];
				
				if(array[j]>array[j+1]) {
					array[j]=temp02;
					array[j+1]=temp01;
				}
			}
		}
		
		for(int num : array) {
			System.out.print(num+" ");
		}
		
	}
}
