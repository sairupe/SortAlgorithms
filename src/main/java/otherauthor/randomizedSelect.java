package otherauthor;

import sort.ExampleArray;
import sort.Util;

/**
 * 根据算法导论的伪代码，完成快速排序快速选择的代码。
 * @author zy
 *
 */
public class randomizedSelect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int a[] = ExampleArray.A;
		 //a=quickSort(a,0,a.length-1);
//		 System.out.print("排序结果：");
//		 for(int i=0;i<a.length;i++){
//			 System.out.print(a[i]+" ");
//		 }
		 int result=randomizedSelect(a, 0, a.length-1, 8);//产生第三小的数
		 System.out.print("\n"+result);
	}
	
	/**
	 * 
	 * @param a 数组
	 * @param p 数组的第一个元素
	 * @param r 数组的最后一个元素
	 * @param i 需要求第几小的元素
	 * @return
	 */
	private static int randomizedSelect(int[] a,int p,int r,int i){
		if(p==r){
			return a[p];//这种情况就是数组内只有一个元素
		}
//		int q=randomizedPartition(a,p,r);
		int q = partition(a,p,r);
		int k=q-p+1;//拿到上一句中作为枢纽的数是第几小的数
		if(i==k){
			return a[q];
		}else if(i<k){
			return randomizedSelect(a,p,q-1,i);
		}else{
			return randomizedSelect(a,q+1,r,i-k);
		}
		
	}
	
	private static int partition(int[] a, int p, int r) {
		int x=a[r];
		int i=p-1;
		for(int j=p;j<r;j++){
			if(a[j]<=x){
				i=i+1;
				swap(a, i, j);
			}
		}
		swap(a, i+1, r);
		return i+1;
	}
	
//	private static int[] quickSort(int[] a,int p,int r){
//		if(p<r){
//			int q=partition(a,p,r);
//			quickSort(a,p,q-1);
//			quickSort(a,q+1,r);
//		}
//		return a;
//	}
	
//	private static int[] randomizedquickSort(int[] a,int p,int r){
//		if(p<r){
//			int q=randomizedPartition(a,p,r);
//			randomizedPartition(a,p,q-1);
//			randomizedPartition(a,q+1,r);
//		}
//		return a;
//	}
	private static int randomizedPartition(int[] a,int p,int r){
		java.util.Random random = new java.util.Random();
		int i=Math.abs(random.nextInt() % (r-p+1)+p);//产生指定范围内的随机数
		swap(a,i,r);
		return partition(a,p,r);
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		Util.print(a);
	}
}