package sort;

/**
 * 筛选出第几小的元素
 * 既数组是从大到小排序的
 * 有点下二叉查找的感觉
 * @author Zh
 *
 */
public class RandomMizedSort {

	static int[] array = ExampleArray.A;
	
	public static void main(String[] args) {
		System.out.println(randomMizedSort(array, 0, array.length - 1, 8));
	}

	public static int randomMizedSort(int[] array, int start, int end, int howSmall){
		if(start == end){
			return array[start];//这种情况就是数组内只有一个元素
		}
		
		int partition = QuickSort2.partition2(array, start, end);
		// 拿到上一句中作为枢纽的数是第几小的数
		// 既array[start, p]有多少个数
		int smallIndex = partition - start + 1;
		
		// 注意下面连续的IF-ELSE分支
		if(smallIndex == howSmall){
			return array[partition];
		}
		else if(howSmall < smallIndex){
			return randomMizedSort(array, start, partition - 1, howSmall);
		}
		else { //if(howSmall > smallIndex){
			//array[start, p]有smallIndex个数，则所求第几大的数在后面数组的第 howSmall - smallIndex个
			// [smallIndex][smallIndex+1][smallIndex+2]...[howSmall]
			// smallIndex到howSmall有 howSmall-smallIndex + 1个数，
			// 故从smallIndex算起是第howSmall-smallIndex + 1位
			// 但现在新数组从smallIndex+1算起，故 howSmall-smallIndex+1-1 = howSmall-smallIndex			
			return randomMizedSort(array, partition + 1, end, howSmall - smallIndex);
		}
	}
}
