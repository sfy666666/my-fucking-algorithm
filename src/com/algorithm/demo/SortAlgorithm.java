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

    static int[] arrays = {1,9,2,88,232,545,56,121,333,666,334,999,770,550,33,23,53,7765,6786,4556,9999,9901,2021,8848,342201};

    public static void main(String[] args) {
        //冒泡排序
        bubbleSort(arrays);
        //选择排序
        selectionSort(arrays);
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
     *
     * 稳定性 稳定
     * 时间复杂度 平均 O(n²) 最坏 O(n²) 最好 O(n)
     * 空间复杂度 O(1)
     * @param array 数组
     */
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                //小的元素放交换到前面
                if(array[j]>array[j+1]) {
                    int temp = array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     *
     * 2.1 算法描述
     * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，
     * 将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     *
     * 2.2 动图演示
     * https://images2017.cnblogs.com/blog/849589/201710/849589-20171015224719590-1433219824.gif
     *
     * 稳定性 不稳定
     * 时间复杂度 平均 O(n²) 最坏 O(n²) 最好 O(n)
     * 空间复杂度 O(1)
     * @param array 需要排序的数组
     */
    public  static void selectionSort(int[] array){
        int len=array.length;
        int minIndex,temp;
        for (int i = 0; i < len-1; i++) {
            minIndex=i;
            for (int j = i+1; j <len; j++) {
                if(array[j]<array[minIndex]){//寻找最小的数
                    minIndex=j;//将最小数的索引保存
                }
            }
            //交换元素
            temp=array[i];
            array[i]=array[minIndex];
            array[minIndex]=temp;
        }
        System.out.println(Arrays.toString(array));
    }


}
