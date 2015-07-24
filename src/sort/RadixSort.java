package sort;

public class RadixSort {

	/**
	 * 基数排序，这里做简化处理，保证每个桶中只有一个元素，既每个位上的数字不重复
	 */
	static int[] array  = {13, 19, 12, 10, 11, 14, 16, 15, 18, 17};
	static int[] array2 = {93, 29, 62, 30, 41, 74, 86, 15, 58, 07};
	static int[] buckets = new int[10];
	
	public static void main(String[] args) {
		int maxDigits = getNumMaxDigits(array2);
		for(int digist = 0; digist < maxDigits; digist++){
			buckets = new int[10];
			for(int j = 0; j < array2.length; j++){
				int bucketNum = (int) (array2[j] / Math.pow(10, digist)) % 10;
				buckets[bucketNum] = array2[j];
			}
			// 对每一个桶内的元素进行排序，这里只有一个元素，故省略处理，一般可选择快排
			// TODO sortBucketInnerElement();
			// 把桶内的元素按顺序取出，现在只有一个简化处理
			// TODO takeOutBucketsElments();
			System.arraycopy(buckets, 0, array2, 0, buckets.length);
		}
		Util.print(array2);
	}
	
	// ================ 工具方法区  =====================
	/**
	 * 找出数组中，位数最多的有几位数
	 * @param array
	 * @return
	 */
	public static int getNumMaxDigits(int[] array){
		int rate = 1;
		for(int i = 0; i < array.length; i++){
			while((int)(array[i] / Math.pow(10, rate)) != 0){
				rate++;
			}
		}
		return rate;
	}
}
