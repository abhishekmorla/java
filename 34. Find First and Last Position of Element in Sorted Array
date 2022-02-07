package com.morle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class firstandlast {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 10};
        int target = 7;
        int[] ans = searchRange(arr, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] searchRange(int[] arr, int tar) {
        int[] ans = {-1,1};
        int start = binarysearchs(arr,tar,true);
        int end = binarysearchs(arr,tar,false);
        ans[0] =start;
        ans[1] =end;
        return ans;
    }

    static int binarysearchs(int[] arr , int tar,boolean firstsindi) {
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (tar > arr[mid])
                start = mid + 1;
            else if (tar < arr[mid])
                end = mid - 1;
            else {
                ans = mid;
                if (firstsindi)
                {
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }


        // i can able to do by brute force approach of facebook interview question
        static int[] searchRange2 (int[] arr, int tar){
            ArrayList<Integer> list = new ArrayList<>(5);
            Scanner in = new Scanner(System.in);
            for (int i = 0; i < arr.length; i++) {
                if (tar == arr[i]) {
                    list.add(i);
                    break;
                }
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if (tar == arr[i]) {
                    list.add(i);
                    break;
                }
            }
            int[] arrs = list.stream().mapToInt(i -> i).toArray();
            int flag = 0;
            for (int i = 0; i < arr.length; i++) {
                if (tar == arr[i]) {
                    flag++;
                    break;
                }
            }
            if (flag == 1) {
                return arrs;
            }
            return new int[]{-1, 1};
        }
    }

