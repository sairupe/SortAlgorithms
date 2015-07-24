package sort;

public class CountSort {
	
	public static int[] array = {2 , 5 , 3 , 0 , 2 , 3 , 0 , 3};
	public static int[] assistArray = new int[6];
	public static int[] newArray = new int[array.length];
	
	public static void main(String[] args) {
		for(int i = 0; i < array.length; i++){
			assistArray[array[i]]++;
		}
		for(int i = 1; i < assistArray.length; i++){
			assistArray[i] = assistArray[i - 1] + assistArray[i];
		}
		Util.print(assistArray);
		for(int i = array.length - 1; i >= 0; i--){
			newArray[assistArray[array[i]] - 1] = array[i];
			assistArray[array[i]]--;
		}
		Util.print(newArray);
	}
}
