package otherauthor;

import sort.ExampleArray;
import sort.Util;

public class HeapSort4 {
	private static int[] sort = new int[] { 1, 0, 10, 20, 3, 5, 6, 4, 9, 8, 12,
			17, 34, 11 };
	
	private static int[] sort1 = ExampleArray.C;

	public static void main(String[] args) {
		buildMaxHeapify(sort1);
		heapSort(sort1);
		print(sort1);
	}

	private static void buildMaxHeapify(int[] data) {
		// û���ӽڵ�Ĳ���Ҫ�������ѣ������һ���ĸ��ڵ㿪ʼ
		int startIndex = getParentIndex(data.length - 1);
		// ��β�˿�ʼ�������ѣ�ÿ�ζ�����ȷ�Ķ�
		for (int i = startIndex; i >= 0; i--) {
			maxHeapify(data, data.length, i);
		}
	}

	/**
	 * ��������
	 * 
	 * @paramdata
	 * @paramheapSize��Ҫ�������ѵĴ�С��һ����sort��ʱ���õ�����Ϊ���ֵ����ĩβ��ĩβ�Ͳ��ٹ���������
	 * @paramindex��ǰ��Ҫ�������ѵ�λ��
	 */
	private static void maxHeapify(int[] data, int heapSize, int index) {
		// ��ǰ���������ӽڵ�Ƚ�
		int left = getChildLeftIndex(index);
		int right = getChildRightIndex(index);

		int largest = index;
		if (left < heapSize && data[index] < data[left]) {
			largest = left;
		}
		if (right < heapSize && data[largest] < data[right]) {
			largest = right;
		}
		// �õ����ֵ�������Ҫ��������������ˣ����ӽڵ���ܾͲ��������ˣ���Ҫ���µ���
		if (largest != index) {
			int temp = data[index];
			data[index] = data[largest];
			data[largest] = temp;
			Util.printBTree(data);
			maxHeapify(data, heapSize, largest);
		}
	}

	/**
	 * �������ֵ����ĩβ��data��Ȼ�����ѣ��������ͳ��˵�����
	 * 
	 * @paramdata
	 */
	private static void heapSort(int[] data) {
		// ĩβ��ͷ�������������������
		for (int i = data.length - 1; i > 0; i--) {
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			Util.printBTree(data);
			maxHeapify(data, i, 0);
		}
	}

	/**
	 * ���ڵ�λ��
	 * 
	 * @paramcurrent
	 * @return
	 */
	private static int getParentIndex(int current) {
		return (current - 1) >> 1;
	}

	/**
	 * ���ӽڵ�positionע�����ţ��ӷ����ȼ�����
	 * 
	 * @paramcurrent
	 * @return
	 */
	private static int getChildLeftIndex(int current) {
		return (current << 1) + 1;
	}

	/**
	 * ���ӽڵ�position
	 * 
	 * @paramcurrent
	 * @return
	 */
	private static int getChildRightIndex(int current) {
		return (current << 1) + 2;
	}

	private static void print(int[] data) {
		int pre = -2;
		for (int i = 0; i < data.length; i++) {
			if (pre < (int) getLog(i + 1)) {
				pre = (int) getLog(i + 1);
				System.out.println();
			}
			System.out.print(data[i] + "|");
		}
	}

	/**
	 * ��2Ϊ�׵Ķ���
	 * 
	 * @paramparam
	 * @return
	 */
	private static double getLog(double param) {
		return Math.log(param) / Math.log(2);
	}
}