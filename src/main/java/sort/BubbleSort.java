package sort;
/**
 * 冒泡
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] a = ExampleArray.A;
		int length = a.length;
		for(int i = 1; i < length; i++){
			for(int j = length - i; j > 0; j--){
				if(a[j] > a[j - 1]){
					Util.swap(a, j, j-1);
				}
			}
		}
		Util.print(a);
	}
}
