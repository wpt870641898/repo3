package com.shiro.test.controller;

/**
 * Created by wang on 2019/3/26.
 */
public class Main {
    public static void main(String[] args){
        String[] str = {"abc","def","afc","faa","aghc","defs","afc","facc","sff"};
        //字符串本身排序
        for (int i = 0 ; i < str.length ; i++) {
            char[] arr = str[i].toCharArray();
            for (int j = 0; j < arr.length - 1; j++) {
                for (int k = 0; k < arr.length - 1 - j; k++) {
                    if (Integer.valueOf(arr[k + 1]) < Integer.valueOf(arr[k])) {
                        char a = arr[k + 1];
                        arr[k + 1] = arr[k];
                        arr[k] = a;
                    }
                }
            }
            str[i] = new String(arr);
        }
        //字符串整体排序
        for (int j = 0; j < str.length - 1; j++) {
            for (int k = 0; k < str.length - 1 - j; k++) {
                String str1 = str[k];
                String str2 = str[k+1];
                if (!sort(str1,str2)) {
                    String a = str1;
                    str[k] = str2;
                    str[k+1] = a;
                }
            }
        }
        for (String s:
             str) {
            System.out.println(s);
        }
    }

    public static boolean sort(String str1,String str2){
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int minSize = Math.min(arr1.length,arr2.length);
        for(int i = 0 ; i < minSize ; i++){
            if(arr2[i] > arr1[i]){
                return true;
            }else if(arr2[i] < arr1[i]){
                return false;
            }
        }
        if(arr1.length<arr2.length){
            return true;
        }

        return false;
    }
}
