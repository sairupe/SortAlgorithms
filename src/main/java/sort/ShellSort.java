package sort;

import java.util.Arrays;

public class ShellSort {
    static int[] a = {7, 3, 9, 2, 1, 5, 4, 6, 10};

    public static void main(String[] args) {
        int[] result = shellSort(a);
        System.out.println(Arrays.toString(result));
        System.exit(0);
    }

    //希尔排序
    public static int[] shellSort(int[] arr) {
        int length = a.length;
        int gap = 1;
        while (gap < length / 3) gap = 3 * gap + 1;
        while (gap >= 1) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j >= gap && a[j] < a[j - gap]; j -= gap) {
                    Util.swap(a, j, j - gap);
                }
            }
            gap = gap / 3;
        }
        return arr;
    }

}
