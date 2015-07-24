package sort;

/**
 * ɸѡ���ڼ�С��Ԫ��
 * �������ǴӴ�С�����
 * �е��¶�����ҵĸо�
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
			return array[start];//�����������������ֻ��һ��Ԫ��
		}
		
		int partition = QuickSort2.partition2(array, start, end);
		// �õ���һ������Ϊ��Ŧ�����ǵڼ�С����
		// ��array[start, p]�ж��ٸ���
		int smallIndex = partition - start + 1;
		
		// ע������������IF-ELSE��֧
		if(smallIndex == howSmall){
			return array[partition];
		}
		else if(howSmall < smallIndex){
			return randomMizedSort(array, start, partition - 1, howSmall);
		}
		else { //if(howSmall > smallIndex){
			//array[start, p]��smallIndex������������ڼ�������ں�������ĵ� howSmall - smallIndex��
			// [smallIndex][smallIndex+1][smallIndex+2]...[howSmall]
			// smallIndex��howSmall�� howSmall-smallIndex + 1������
			// �ʴ�smallIndex�����ǵ�howSmall-smallIndex + 1λ
			// �������������smallIndex+1���𣬹� howSmall-smallIndex+1-1 = howSmall-smallIndex			
			return randomMizedSort(array, partition + 1, end, howSmall - smallIndex);
		}
	}
}
