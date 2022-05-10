package sort;


public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {

            //num代表此次循环中需要找到的最小值
            int num = arr[i];

            //k代表最小值对应的索引
            int k = i;

            //找到最小值num,并记录索引k
            for (int j = i; j < n; j++) {
                if (num > arr[j]) {
                    k = j;
                    num = arr[j];
                }
            }

            //将找到的最小值放到当前轮次的最前面
            arr[k] = arr[i];
            arr[i] = num;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 2, 10};
        selectionSort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
