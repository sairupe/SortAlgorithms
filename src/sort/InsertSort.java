package sort;
/**
 * ≤Â»Î
 */
public class InsertSort {
	
	public static void main(String[] args){
		int[] a = ExampleArray.A;
		int length = a.length;
		for(int i = 1; i < length ; i++){
			int insertValue = a[i];
			int j = i - 1;
			while(j >= 0 && a[j] > insertValue)
			{
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = insertValue;
		}
		Util.print(a);
	}
}	
