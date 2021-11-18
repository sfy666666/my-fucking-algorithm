package com.algorithm.demo;


import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String string="abcabcbb";
        System.out.println(lengthOfLongestSubstring(string));

    }

    private static int lengthOfLongestSubstring(String s) {
        //排除异常情况
        int n=s.length();
        if (n == 0) return 0;
        int result=0;
        //使用HashMap 让每个char对应一个int （下标 +1）
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0,start=0; end < n; end++) {//定义指针start end分别指向不重复的字符串的开始和结束的下标位置
            char key=s.charAt(end);
            if(map.containsKey(key)){
                //出现重复字符串 用最大的value作为新的开始下标
                start=Math.max(map.get(key),start);
            }
            //结束下标-开始下标+1
            result=Math.max(result,end-start+1);
            //存入下标+1
            map.put(key,end+1);
        }
        return result;
    }
}
