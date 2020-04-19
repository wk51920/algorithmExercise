package com.wk.algorithm.sortAlgorithm;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @program: algorithm
 * @description:
 * @author: wk
 * @create: 2020-04-19 21:20
 **/
final public class QuickSort {
    public static int[] sort(int[] sourceArray) {
        return quickSort(sourceArray, 0, sourceArray.length - 1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int alreadySortedIndex = partition(arr, left, right);
            quickSort(arr, left, alreadySortedIndex - 1);
            quickSort(arr, alreadySortedIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int benchmarkIndex = left;
        // startComparedIndex是一趟比较的准线，所以比arr[benchmarkIndex]小的都在startComparedIndex左侧，反之在右侧
        int startComparedIndex = benchmarkIndex + 1;
        for (int i = startComparedIndex; i <= right; i++) {
            if (arr[i] < arr[benchmarkIndex]) {
                ArrayUtils.swap(arr, i, startComparedIndex);
                startComparedIndex++;
            }
        }
        ArrayUtils.swap(arr, benchmarkIndex, startComparedIndex - 1);
        return startComparedIndex - 1;
    }

    public static void main(String[] args) {
        int[] sourceArray = {4, 36, 2, 5, 2, 222, 12, 3, 44, 5566, 6777, 888};
        System.out.println(ArrayUtils.toString(sort(sourceArray)));
    }
}
