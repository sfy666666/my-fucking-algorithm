package com.algorithm.demo;

import jdk.nashorn.internal.ir.CallNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不重复的字母长度
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(solution("abcdeeeeabdddeadafdpouywjeqeazx"));

    }
    private static int solution(String s){
        //排除空
        if(s.length()==0) return 0;
        //创建HashMap保存
        Map<Character,Integer> map = new HashMap<>();
        int n=s.length(),max=0;
        //设置两个指针
        for (int end=0,start=0;end<n;end++){
            char key = s.charAt(end);
            //出现重复的key 将start移动到
            if(map.containsKey(key)){
                start=Math.max(map.get(key),start);
            }
            max=Math.max(max,end-start+1);
            map.put(s.charAt(end),end+1);
            System.out.println("start="+start+"\tend="+end+"\tkey="+key+"\tvalue="+ map.get(key));
        }
        return max;

    }
}
