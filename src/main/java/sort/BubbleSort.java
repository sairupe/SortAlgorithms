package sort;

/**
 * 冒泡
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = ExampleArray.A;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > i; j--) { // j-1边界条件要判断到a[0], 等于0时是j=i
                if (a[j] < a[j - 1]) {
                    Util.swap(a, j, j - 1);
                }
            }
        }
        Util.print(a);
    }
}
