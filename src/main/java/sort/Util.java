package sort;

import java.util.Arrays;

public class Util {

	public static final String NUM_SEPERATE_WIDTH = "   ";
	public static final String LEFT_BRANCH = "/";
	public static final String RIGHT_BRANCH = "\\\\";
	
	public static void swap(int[] array, int a, int b){
		int temp = array[b];
		array[b] = array[a];
		array[a] = temp;
		//Util.printBTree(array);
//		Util.print(array);
//		if(array[1] == 10){
//			System.out.println();
//		}
	}
	
	public static void printBTree(int[] array) {
		System.out.println("" +
				"                 " + array[0] + "                     \n" +
				"         " + array[1] + "               " + array[2] + "              \n" +
				"     " + array[3] + "        " + array[4] + "        " + array[5] + "   " + array[6] + "            \n" +
				"   " + array[7] + "   " + array[8] + "    " + array[9] + "   " + array[10] + "                       \n" +
				"");
		System.out.println("====================================================================================");
	}
	
	public static int getMin(int[] array, int... indexs){
		int[] index = indexs;
		int minIndex = indexs[0];
		for(int i = 1; i < index.length; i++){
			if(array[indexs[i]] < array[minIndex]){
				minIndex = indexs[i];
			}
		}
		return minIndex;
	}
	
	public static void print(int[] array){
		System.out.println(Arrays.toString(array));
	}
	
	public static void printLoop(String toPrint, int times){
		for(int i = 0; i < times; i++){
			System.out.print(toPrint);
		}
	}
	
	public static void printNum(int num){
		System.out.print(num + NUM_SEPERATE_WIDTH);
	}
	
	public static void printTree(int[] array){
		int deep = (int) (Math.log(array.length) / Math.log(2) + 1);
		int printDeep = 0;
		for(int i = 0; i < deep; i++){// 层打印
			printLoop(NUM_SEPERATE_WIDTH, deep - printDeep);
			int levelNumCount = (int) Math.pow(2, printDeep); 
			int firstNumIndex = (int) (levelNumCount - 1);
			int currentLevelWidth = (levelNumCount - 1) * NUM_SEPERATE_WIDTH.length();
			for(int j = 0; j < levelNumCount; j++){// 层的数字打印
				if(firstNumIndex > array.length - 1){
					break;
				}
				printNum(array[firstNumIndex]);
				firstNumIndex++;
			}
			printDeep++;
			System.out.println();
		}
	}
	
	public static void printTreeByMaxtri(int[] array){
		// 用矩阵带坐标来打印
		// 一个数字占1个数组元素位置，一个间隔占2个数组元素位置
		int deep = (int) (Math.log(array.length) / Math.log(2) + 1);
		int length = deep;
		int width = (int) (Math.pow(2, deep) * (NUM_SEPERATE_WIDTH.length() + 1));
		if(width % 2 == 0){
			width++;
		}
		String[][] maxtri = new String[length][width];
		int rootIndex = width / 2;
		for(int i = 0; i < maxtri.length; i++){
			for(int j = 0; j < maxtri[i].length; j++){
				maxtri[i][j] = " ";
			}
		}
		// 根据第一个数间隔打印
		for(int level = 0; level < deep; level++){
			int firtNumIndex = (int) (Math.pow(2, level) - 1);
			int firstNumRange = rootIndex / deep * (deep - level - 1);
			int levelNumCount = (int) Math.pow(2, level); 
			int lastNumY = firstNumRange;
			maxtri[level][firstNumRange] = array[firtNumIndex] + "";
			for(int i = 1; i < levelNumCount; i++){
				if(++firtNumIndex > array.length - 1){
					break;
				}
				lastNumY = lastNumY + NUM_SEPERATE_WIDTH.length();
				maxtri[level][lastNumY] = array[firtNumIndex] + "";
			}
		}
		for(int i = 0; i < maxtri.length; i++){
			for(int j = 0; j < maxtri[i].length; j++){
				System.out.print(maxtri[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void printTreeByMaxtri2(int[] array){
		// 用矩阵带坐标来打印
		// 一个数字占1个数组元素位置，一个间隔占2个数组元素位置
		int deep = (int) (Math.log(array.length) / Math.log(2) + 1);
		int length = deep;
		int width = (int) (Math.pow(2, deep) * (NUM_SEPERATE_WIDTH.length() + 1));
		if(width % 2 == 0){
			width++;
		}
		String[][] maxtri = new String[length][width];
		int rootIndex = width / 2;
		for(int i = 0; i < maxtri.length; i++){
			for(int j = 0; j < maxtri[i].length; j++){
				maxtri[i][j] = " ";
			}
		}
		// 从跟节点递归填充左右孩子节点
		fillChild(maxtri, array, 0, 0, rootIndex);
		
		for(int i = 0; i < maxtri.length; i++){
			for(int j = 0; j < maxtri[i].length; j++){
				System.out.print(maxtri[i][j]);
			}
			System.out.println();
		}
	}
	
	// 从叶子节点开始打印
	public static void printTreeByMaxtri3(int[] array){
		// 用矩阵带坐标来打印
		// 一个数字占1个数组元素位置，一个间隔占2个数组元素位置
		int deep = (int) (Math.log(array.length) / Math.log(2) + 1);
		int length = deep;
		int width = (int) (Math.pow(2, deep) * (NUM_SEPERATE_WIDTH.length() + 1));
		if(width % 2 == 0){
			width++;
		}
		String[][] maxtri = new String[length][width];
		int rootIndex = width / 2;
		for(int i = 0; i < maxtri.length; i++){
			for(int j = 0; j < maxtri[i].length; j++){
				maxtri[i][j] = " ";
			}
		}
		// 从跟节点递归填充左右孩子节点
		fillChild(maxtri, array, 0, 0, rootIndex);
		
		for(int i = 0; i < maxtri.length; i++){
			for(int j = 0; j < maxtri[i].length; j++){
				System.out.print(maxtri[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void fillChild(String[][] maxtri, int array[], int rootArrayIndex, int level, int rootY){
		maxtri[level][rootY] = array[rootArrayIndex] + "";
		int leftChildArrayIndex = 2 * rootArrayIndex + 1;
		int rightChildArrayIndex = 2 * rootArrayIndex + 2;
		if(leftChildArrayIndex > array.length - 1 || rightChildArrayIndex > array.length - 1){
			return;
		}
		int childLevel = level + 1;
		int leftChildY = rootY - NUM_SEPERATE_WIDTH.length();
		int rightChildY = rootY + NUM_SEPERATE_WIDTH.length();
		
		// 调整树结构, 往右偏移
//		if(!maxtri[childLevel][leftChildY].equals(" ")){
//			maxtri[level][rootY] = array[rootArrayIndex] + " ";
//			rootY = rootY + 2 * NUM_SEPERATE_WIDTH.length();
//			maxtri[level][rootY] = array[rootArrayIndex] + "";
//			leftChildY = rootY - NUM_SEPERATE_WIDTH.length();
//			rightChildY = rootY + NUM_SEPERATE_WIDTH.length();
//		}
		
		maxtri[childLevel][leftChildY] = array[leftChildArrayIndex] + "";
		maxtri[childLevel][rightChildY] = array[rightChildArrayIndex] + "";
		fillChild(maxtri, array, leftChildArrayIndex, childLevel, leftChildY);
		fillChild(maxtri, array, rightChildArrayIndex, childLevel, rightChildY);
	}
	
	
	public static void main(String[] args){
		printTreeByMaxtri2(ExampleArray.A);
//		printTree(ExampleArray.A);
	}
}
