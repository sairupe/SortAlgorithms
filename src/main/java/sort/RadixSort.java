package sort;

public class RadixSort {

	/**
	 * ���������������򻯴�����֤ÿ��Ͱ��ֻ��һ��Ԫ�أ���ÿ��λ�ϵ����ֲ��ظ�
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
			// ��ÿһ��Ͱ�ڵ�Ԫ�ؽ�����������ֻ��һ��Ԫ�أ���ʡ�Դ���һ���ѡ�����
			// TODO sortBucketInnerElement();
			// ��Ͱ�ڵ�Ԫ�ذ�˳��ȡ��������ֻ��һ���򻯴���
			// TODO takeOutBucketsElments();
			System.arraycopy(buckets, 0, array2, 0, buckets.length);
		}
		Util.print(array2);
	}
	
	// ================ ���߷�����  =====================
	/**
	 * �ҳ������У�λ�������м�λ��
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
