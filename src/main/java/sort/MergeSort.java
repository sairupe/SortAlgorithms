package sort;


import java.util.Arrays;

public class MergeSort {

    static int[] a1 = {7, 3, 9, 2, 1, 5, 4, 6, 10};
    static int[] a2 = {7, 3, 9, 2, 1, 5, 4, 6, 10};
    static int[] aux = new int[a1.length];

    public static void main(String[] args) {
        // 递归算法
        recursiveSort(a1, 0, a1.length - 1);
        System.out.println("递归算法的结果是" + Arrays.toString(a1));
//        System.out.println(Arrays.toString(a1));
//        test(a1);
//        System.out.println(Arrays.toString(a1));
    }

    /**
     * 递归算法
     *
     * @return
     */
    private static void recursiveSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        recursiveSort(a, lo, mid);
        recursiveSort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * 非递归算法
     *
     * @return
     */
    private static int[] unRecursive(int[] a) {
        return null;
    }

    private static void merge(int[] a, int lo, int mid, int hi) {
//        System.out.printf("lo - %s, mid - %s, hi - %s \n ", lo, mid, hi);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) { // 开始传入边界是数组 a.length - 1
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }
}
