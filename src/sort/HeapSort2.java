package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 	����
 */
public class HeapSort2 {
	
	//ExampleArray
	//public static int[] A = {10 , 9 , 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 , 0};
	//public static int[] C = {3 , 1 , 2 , 0 , 4 , 9 , 6 , 7 , 8 , 5 , 10};
	//public static int[] B = {0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10};
	
	//A.{ 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10}  // �������������ʵ���� 
	//A.{10 , 9 , 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 , 0 }  // �����������
	//B.{ 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10, 11}  // ������ȫ������������
	
	public static int[] array = ExampleArray.A;
	public static List<Integer> result = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		heapSort();
		Util.print(array);
	}
	
	public static void heapSort(){
		Util.printBTree(array);
		buildMinHeap();
		// ����N-1�ν�����������
		for(int i = array.length - 1; i > 0; i--){
			if(array[0] == 8){
				System.out.println();
			}
			Util.swap(array, 0, i);
			minHeapify(array, i, 0);
		}
	}
	
	/**
	 * @param array ����
	 * @param heapSize ���鳤��
	 * @param i ���ڵ���������
	 */
	public static void minHeapify(int[] array, int heapSize, int i){
		int leftChildIndex = getLeftChild(i);
		int rightChildIndex = getRightChild(i);
		int minIndex = i;
		
//CODE A:
		// ԭ���Լ�д����CODE B��ȴΪʲô����CODE A������CODE B
		// ���֣����ٽ����һ������ʱ�����ڵ�array[0]���Һ��ӽڵ��Ѿ� ���� size������ʱ��������ӱȽ�
		// ��CODE Bֱ�� RETURN���ǲ��Ե�
		// �����һ�����򽻻����ڵ�ǰ��array[0]��array[1]����, ���ں���ǰ����������ʵģ������ջ��Ǳ�������
		// ���ԣ������Ϊʲô���ñȽ��ҽڵ������
		if(leftChildIndex <= heapSize - 1 && array[leftChildIndex] < array[i]){
			minIndex = leftChildIndex;
		}
		if(rightChildIndex <= heapSize - 1 && array[rightChildIndex] < array[minIndex]){
			minIndex = rightChildIndex;
		}
//CODE B:		
//		if(leftChildIndex > heapSize - 1 || rightChildIndex > heapSize - 1){
//			return;
//		}
//		int leftValue = array[leftChildIndex];
//		int rightValue = array[rightChildIndex];
//		int minIndx = Util.getMin(array, i, leftChildIndex, rightChildIndex);
			
		if(minIndex != i){
			Util.swap(array, i, minIndex);
			minHeapify(array, heapSize, minIndex);
		}
	}
	
	public static void buildMinHeap(){
		// EG. �����±��0��ʼ��1-6����ȫ��������1-5����ȫ�������ĵ�һ��Ҷ�ӽڵ㶼�� array.length / 2
		// �������һ�����ڵ�϶��� array.length / 2 - 1
		int lastParentIndex = array.length / 2 - 1;
		for(int i = lastParentIndex; i >= 0; i--){
			minHeapify(array, array.length, i);
		}
	}
	
	/**
	 *	������������ʵ������������ʻ���Ҫת������ȫ���������������Ȼ����ת������ʵ�����Ҷ������������
	 *	�� ��ʵ������ĸ��ڵ�����Ϊ Ai , ��Ϊ��ʵ������������ȫ������������ֵ��1���� Bi = Ai + 1 
	 *	����B����ȫ���������ʣ��� L(Bi)ΪBi�ڵ�����ӣ� R(Bi)ΪBi�ڵ���Һ���,��
	 *	L(Bi) = 2 * Bi; R(Bi) = 2 * Bi  + 1
	 *	��������
	 *	L(Ai) = 2 * Ai + 1; R(Ai) = 2 * Ai  + 2
	 */
	public static int getLeftChild(int root){
		return (root + 1) * 2 - 1;// 2i + 1
	}
	
	public static int getRightChild(int root){
		return (root + 1) * 2 + 1 - 1;// 2i + 2
	}
}
