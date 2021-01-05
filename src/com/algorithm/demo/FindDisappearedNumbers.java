package com.algorithm.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] arr=new int[]{4,4,2,2,5,6,1,1};
        System.out.println(Arrays.toString(findDisappearedNumbers(arr).toArray()));
    }

    public  static  List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> result = new ArrayList<>();
        // 遍历数组,如果arr[i]中的数字出现，则标记第i-1个位置为负数
        for (int i = 0; i < arr.length; i++) {
            // 获取第i个位置的值
            int value=Math.abs(arr[i]);
            // 设置当前值对应的数组下标，为负数
            arr[value-1]=-Math.abs(arr[value-1]);
        }
        // 遍历数组， 如果存在正数，则当前i位置的值缺失
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0){
                // +1是因为i从0开始
                result.add(i+1);
            }
        }
        return result;
    }
}
