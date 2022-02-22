package sort;


/**
 * 快排(小到大排序) 和QuickSort的原理一致,只不过是指针移动方向不同,这里从左统一往右移动检查
 * 历了整个数组,总遍历数是一样的
 */
public class QuickSort2 {

	public static void main(String[] args) {
		int[] a = ExampleArray.C;
		int length = a.length;
		//Util.print(a);
		quickSort(a, 0, length - 1);
		Util.print(a);
	}

	public static int partition2(int[] array, int start, int end){
		int mid = array[end];// 以划分数组最后一个值为主元
		int lastMinIndex = start - 1;
		for(int i = start; i < end; i++){
			if(array[i] <= mid){
				lastMinIndex++;
				Util.swap(array, lastMinIndex, i);
			}
		}
		Util.swap(array, lastMinIndex + 1, end);// 把主元位置交换
		return lastMinIndex + 1;
	}
	
	
	public static void quickSort(int[] a, int start, int end){
		if(start < end){
			int patition = partition2(a, start, end);
			quickSort(a, start, patition - 1);
			quickSort(a, patition + 1, end);
		}
	}
}
