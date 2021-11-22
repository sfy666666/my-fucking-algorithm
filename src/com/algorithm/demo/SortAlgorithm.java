package com.algorithm.demo;

import java.util.Arrays;

/**
 * 排序算法
 *
 * 相关概念
 *
 * 稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面。
 * 不稳定：如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面。
 * 时间复杂度：对排序数据的总的操作次数。反映当n变化时，操作次数呈现什么规律。
 * 空间复杂度：是指算法在计算机内执行时所需存储空间的度量，它也是数据规模n的函数。
 */
public class SortAlgorithm {

    static int[] arrays = {1, 9, 2, 88, 232, 545, 56, 121, 333, 666, 334, 999, 770, 550, 33, 23, 53, 7765, 6786, 4556, 9999, 9901, 2021, 8848, 342201};

    public static void main(String[] args) {
        //冒泡排序
//        bubbleSort(arrays);
        //选择排序
//        selectionSort(arrays);
        //插入排序
//        insertionSort(arrays);
        //希尔排序
//        shellSort(arrays);
    }

    /**
     * 冒泡排序 正序排序
     * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * 1.1 算法描述
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成
     * 1.2动图演示
     * https://images2017.cnblogs.com/blog/849589/201710/849589-20171015223238449-2146169197.gif
     * <p>
     * 稳定性 稳定
     * 时间复杂度 平均 O(n²) 最坏 O(n²) 最好 O(n)
     * 空间复杂度 O(1)
     *
     * @param array 数组
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                //小的元素放交换到前面
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * <p>
     * 2.1 算法描述
     * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，
     * 将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     * <p>
     * 2.2 动图演示
     * https://images2017.cnblogs.com/blog/849589/201710/849589-20171015224719590-1433219824.gif
     * <p>
     * 稳定性 不稳定
     * 时间复杂度 平均 O(n²) 最坏 O(n²) 最好 O(n)
     * 空间复杂度 O(1)
     *
     * @param array 需要排序的数组
     */
    public static void selectionSort(int[] array) {
        int len = array.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex]) {//寻找最小的数
                    minIndex = j;//将最小数的索引保存
                }
            }
            //交换元素
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 3.插入排序
     * 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
     * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 3.1 算法描述
     * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     * 3.2 动图演示  https://images2017.cnblogs.com/blog/849589/201710/849589-20171015225645277-1151100000.gif
     * 稳定性：不稳定
     * 时间复杂度：平均 O(n²)  最坏 O(n²)  最好 O(n²)
     * 空间复杂度：O(1)
     */
    public static void insertionSort(int[] array) {
        int len = array.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = array[i];
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 4.希尔排序
     * 1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。
     * 它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
     * 4.1 算法描述
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
     * <p>
     * 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
     * 按增量序列个数k，对序列进行k 趟排序；
     * 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，
     * 分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     */
    public static void shellSort(int[] arr) {
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            //多个分组交替执行
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = arr[i];
                while (j - gap >= 0 && current < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = current;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 5、归并排序（Merge Sort）
     * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的
     * 一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，
     * 再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
     *
     * 5.1 算法描述
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     * 5.2 动图演示 https://images2017.cnblogs.com/blog/849589/201710/849589-20171015230557043-37375010.gif
     *
     * 时间复杂度：平均 O(n㏒2n) 最坏 O(n㏒2n) 最好 O(n㏒2n)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp) {
        if(left<right){
            int mid=(left+right)/2;
            //左边归并排序
            mergeSort(arr,left,mid,temp);
            //右边归并排序
            mergeSort(arr,mid+1,right,temp);
            //合并左右两边的操作
            merge(arr,left,mid,right,temp);
        }

    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //左序列指针
        int i=left;
        //右序列指针
        int j=mid+1;
        //临时数组指针
        int t=0;
    }

    public static void a(int[] array1) {
        int len = array1.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (array1[j] > array1[j + 1]) {
                    int temp = array1[j];
                    array1[j] = array1[j + 1];
                    array1[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array1));
    }

    public static void b(int[] array1) {
        int temp, minIndex;
        int len = array1.length;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len - 1; j++) {
                if (array1[minIndex] > array1[j]) {
                    minIndex = j;
                }

            }
            temp = array1[i];
            array1[i] = array1[minIndex];
            array1[minIndex] = temp;
        }
        System.out.println(Arrays.toString(array1));
    }

    public static void c(int[] arr) {
        int current, preIndex;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void d(int[] arr) {
        int len = arr.length;
        for (int gap = len/2; gap >0 ; gap/=2) {
            for (int i = gap; i < len; i++) {
                int j=i;
                int current=arr[i];
                while(j-gap>=0&&arr[j-gap]>current){
                    arr[j]=arr[j-gap];
                    j=j-gap;
                }
                arr[j]=current;
            }
        }
        System.out.println(Arrays.toString(arr));
    }


}
