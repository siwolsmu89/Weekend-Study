package mini;

public class ArrayCompare {
	public static void main(String[] args) {
		
	int[] arr1 = {3,5,6,9,10,2,7};
	int[] arr2 = {3,5,6,9,10,2,7};
	
	int[] arr3 = {3,5,6,9};
	int[] arr4 = {3,5,6,9,8};
	
	if(equalsArr(arr1,arr2)) {
		System.out.println("two array equals");
	} else {
		System.out.println("two array not-equals");
	}
	System.out.println("------------------------------------------");
	
	if(equalsArr(arr3,arr4)) {
		System.out.println("two array equals");
	} else {
		System.out.println("two array not-equals");
	}
	System.out.println("------------------------------------------");
	
	}

	private static boolean equalsArr(int[] arr1, int[] arr2) {
		boolean result = false;
		
		if(!(arr1.length==arr2.length)) {
			return result;
		} else {
			for(int i=0;i<arr1.length;i++) {
					if(!(arr1[i] == arr2[i])) {
						return result;
					}
				}
			result = true;
		}
		
		return result;
	}


}


