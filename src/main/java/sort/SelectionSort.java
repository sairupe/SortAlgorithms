package sort;
/**
 * 选择排序
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] a = ExampleArray.A;
		int length = a.length;
		int minIndex = 0;
		for(int i = 0; i < length; i++){
			minIndex = i;
			for(int j = i + 1; j < length; j++){
				if(a[j] < a[minIndex]){
					minIndex = j;
				}
			}
			if(minIndex != i){
				Util.swap(a, i, minIndex);
			}
		}
		Util.print(a);
	}

}
