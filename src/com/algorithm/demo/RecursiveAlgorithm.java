package com.algorithm.demo;

public class RecursiveAlgorithm {
    public static void main(String[] args) {
        getAge(2021,1998);
    }
    private static void getAge(int year,int birthday){
        if(year==birthday)return;
        System.out.println(year+"年"+(year-birthday)+"岁");
        --year;
        getAge(year,birthday);
    }
}
