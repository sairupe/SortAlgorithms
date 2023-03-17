package sort;


import java.util.Arrays;

public class MergeSort {

    static int[] a1 = {7, 3, 9, 2, 1, 5, 4, 6, 10};
    static int[] a2 = {7, 3, 9, 2, 1, 5, 4, 6, 10};
    static int[] aux = new int[a1.length];

    public static void main(String[] args) {
        // 递归算法
        recursiveSort(a1, 0, a1.length - 1);
        System.out.println("递归算法的结果是\n" + Arrays.toString(a1));
        // 非递归算法
        unRecursive(a2);
        System.out.println("非递归算法的结果是\n" + Arrays.toString(a2));
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
        int mid = lo + (hi - lo) / 2;// (lo + hi) / 2 ?
        recursiveSort(a, lo, mid);
        recursiveSort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * 非递归算法
     *
     * @return
     */
    private static void unRecursive(int[] a) {
        int N = a2.length;
        for (int cs = 1; cs < N; cs = cs * 2) {// 子数组每次扩容两倍大小进行合并 childSize
            for (int lo = 0; lo < N - cs; lo += cs * 2) { // 子数组索引, 小于 N - cs, 因为 lo + cs 是mid的位置, lo后要预留2个数组
                merge(a2, lo, lo + cs - 1, Math.min(lo + cs + cs - 1, N - 1));
            }
        }
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
