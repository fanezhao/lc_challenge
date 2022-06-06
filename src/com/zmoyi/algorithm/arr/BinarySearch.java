package com.zmoyi.algorithm.arr;

/**
 * @author niou.zhao@tuya.com
 * @description
 * @date 2022-05-31 21:53
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, Integer target) {
        int l = 0, r = arr.length - 1; // 在[l....r]区间内寻找target
        while (l <= r) {    // l = r时，区间[l....r]区间依然有效
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                l = mid + 1;   // 区间【mid+1....r】
            } else {
                r = mid - 1;    // 区间[l....mid-1]
            }
        }

        return -1;
    }

    public static int binarySearch2(int[] arr, Integer target) {
        int l = 0, r = arr.length; // 在[l....r)区间内寻找target
        while (l < r) {    // l = r时，区间[l....r)区间无效，例如[42,42)是没有值的；[42,43)有一个有效值42
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                l = mid + 1;   // 区间[mid+1....r)
            } else {
                r = mid;    // 区间[l....mid)
            }
        }

        return -1;
    }

    public static int binarySearch3(int[] arr, Integer target) {
        int l = 0, r = arr.length; // 在[l....r)区间内寻找target
        while (l < r) {    // l = r时，区间[l....r)区间无效，例如[42,42)是没有值的；[42,43)有一个有效值42
            int mid = l + (r - l) / 2;  // 这种当l,r足够在时也不会整形溢出
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                l = mid + 1;   // 区间[mid+1....r)
            } else {
                r = mid;    // 区间[l....mid)
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};
        System.out.println(binarySearch(arr, 3));
        System.out.println(binarySearch(arr, 0));
        System.out.println(binarySearch2(arr, 3));
        System.out.println(binarySearch2(arr, 0));
    }
}
