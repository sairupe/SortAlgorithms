package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 	堆排
 */
public class HeapSort2 {
	
	//ExampleArray
	//public static int[] A = {10 , 9 , 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 , 0};
	//public static int[] C = {3 , 1 , 2 , 0 , 4 , 9 , 6 , 7 , 8 , 5 , 10};
	//public static int[] B = {0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10};
	
	//A.{ 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10}  // 待排序的数组真实索引 
	//A.{10 , 9 , 8 , 7 , 6 , 5 , 4 , 3 , 2 , 1 , 0 }  // 待排序的数组
	//B.{ 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10, 11}  // 构建完全二叉树的索引
	
	public static int[] array = ExampleArray.A;
	public static List<Integer> result = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		heapSort();
		Util.print(array);
	}
	
	public static void heapSort(){
		Util.printBTree(array);
		buildMinHeap();
		// 进行N-1次交换并构建堆
		for(int i = array.length - 1; i > 0; i--){
			if(array[0] == 8){
				System.out.println();
			}
			Util.swap(array, 0, i);
			minHeapify(array, i, 0);
		}
	}
	
	/**
	 * @param array 数组
	 * @param heapSize 数组长度
	 * @param i 父节点所在索引
	 */
	public static void minHeapify(int[] array, int heapSize, int i){
		int leftChildIndex = getLeftChild(i);
		int rightChildIndex = getRightChild(i);
		int minIndex = i;
		
//CODE A:
		// 原来自己写的是CODE B，却为什么采用CODE A而不是CODE B
		// 发现，在临界最后一次排序时，根节点array[0]的右孩子节点已经 大于 size，但此时仍需和左孩子比较
		// 故CODE B直接 RETURN了是不对的
		// 在最后一次排序交换根节点前，array[0]和array[1]互换, 但在呼唤前是满足堆性质的，故最终还是被换回来
		// 所以，这就是为什么不用比较右节点的问题
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
		// EG. 数组下标从0开始，1-6的完全二叉树和1-5的完全二叉树的第一个叶子节点都是 array.length / 2
		// 索引最后一个父节点肯定是 array.length / 2 - 1
		int lastParentIndex = array.length / 2 - 1;
		for(int i = lastParentIndex; i >= 0; i--){
			minHeapify(array, array.length, i);
		}
	}
	
	/**
	 *	传进来的是真实数组的索引，故还需要转化成完全二叉树组的索引，然后再转化成真实数组的叶子索引，故有
	 *	设 真实的数组的父节点索引为 Ai , 因为真实数组索引比完全二叉树组索引值少1，故 Bi = Ai + 1 
	 *	根据B的完全二叉树性质，设 L(Bi)为Bi节点的左孩子， R(Bi)为Bi节点的右孩子,则
	 *	L(Bi) = 2 * Bi; R(Bi) = 2 * Bi  + 1
	 *	带入则有
	 *	L(Ai) = 2 * Ai + 1; R(Ai) = 2 * Ai  + 2
	 */
	public static int getLeftChild(int root){
		return (root + 1) * 2 - 1;// 2i + 1
	}
	
	public static int getRightChild(int root){
		return (root + 1) * 2 + 1 - 1;// 2i + 2
	}
}
