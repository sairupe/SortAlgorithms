package sort;


/**
 * 快排(小到大排序)
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] a = ExampleArray.A;
		int length = a.length;
		Util.print(a);
		quickSort(a, 0, length - 1);
		Util.print(a);
	}

	public static int partition(int[] a, int start, int end){
		int mid = (start + end) / 2;
		int midValue= a[mid];
		int head = start;
		int tail = end;
		while(head < tail && a[head] < midValue){
			head++;
		}
		while(head < tail && a[tail] > midValue){
			tail--;
		}
		Util.swap(a, head, tail);
		return head;
	}
	
	public static void quickSort(int[] a, int start, int end){
		if(start >= end){
			return;
		}
		int patition = partition(a, start, end);
		quickSort(a, start, patition - 1);// 注意这里的END从patition-1开始
		quickSort(a, patition + 1, end);// 注意这里的START从patition+1开始
	}
}
