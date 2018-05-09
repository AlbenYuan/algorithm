package com.albenyuan.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序工具类
 *
 * @Author Alben Yuan
 * @Date 2018-04-28 15:11
 */
public class SortUtil {

    private static Logger logger = LoggerFactory.getLogger(SortUtil.class);

    /**
     * 插入排序
     * 已经有一个有序的数据序列。要求在这个有序的数据序列中，插入一个数据后依然有序。
     * <p>
     * 1.选择第一个元素作为一个有序组合
     * 2.从第个元素开始，和已有的有序序列中的元素依次比较，
     * 3. 待排序元素大于等于有序序列的n个元素
     *
     * @param list
     * @return
     */
    public static List<Integer> insertionSort(List<Integer> list) {

        int size = list.size();
        for (int i = 1; i < size; i++) {
            int j = i - 1;
            int temp = list.get(i);  // 1. 取出带插入的元素

            // 和已存在的有序序列从后向前，依次比较，
            while ((j >= 0) //  不是第一个元素位置
                    && temp < list.get(j)) { // 还没有找到合适的位置
                list.set(j + 1, list.get(j)); // 有序序列中第j个元素，后移一位。
                j--; // 和前一个与元素比较
            }
            list.set(j + 1, temp);  // 带插入元素插入到对应的位置
        }
        return list;
    }


    /**
     * 冒泡排序
     * 1.
     *
     * @param list
     * @return
     */
    public static List<Integer> bubbleSort(List<Integer> list) {

        Integer size = list.size();
        for (Integer i = 0; i < size; i++) {
            for (Integer j = 0; j < size - 1 - i; j++) {

                Integer dataJ = list.get(j);
                Integer dataJNext = list.get(j + 1);

                if (dataJ > dataJNext) {        // 相邻元素两两对比
                    list.set(j + 1, dataJ);
                    list.set(j, dataJNext);
                }
            }
        }
        return list;
    }

    /**
     * 选择排序
     * 选择为排序序列中的最小值，放到第一个位置
     *
     * @param list
     * @return
     */
    public static List<Integer> selectionSort(List<Integer> list) {
        int size = list.size();
        for (Integer i = 0; i < size - 1; i++) {
            int minIndex = i; // 取出无序序列的第一个元素作为最小值的下标
            int min = list.get(i); // 取出无序序列的第一个元素作为最小值
            for (Integer j = i + 1; j < size; j++) {
                //遍历后续全部数据
                Integer dataJ = list.get(j);
                if (dataJ < min) { // 比较判断，是否为已知最小值
                    min = dataJ; // 取出最小值
                    minIndex = j; // 记录最小值下标
                }
            }
            list.set(minIndex, list.get(i)); // 将无序序列第一个元素放到，最小值对应的位置，
            list.set(i, min); // 将最小值，放到无序的第一个位置
        }
        return list;
    }

    public static List<Integer> quickSort(List<Integer> list) {
        return quickSort(list, 0, list.size() - 1);
    }

    /**
     * 快速排序
     *
     * @param list
     * @param start
     * @param end
     * @return
     */
    public static List<Integer> quickSort(List<Integer> list, int start, int end) {
        int pivot, p_pos, i, t;
        if (start < end) {
            p_pos = start;
            pivot = list.get(p_pos);
            for (i = start + 1; i <= end; i++)
                if (list.get(i) < pivot) {
                    p_pos++;
                    t = list.get(p_pos);
                    list.set(p_pos, list.get(i));
                    list.set(i, t);
                }
            t = list.get(start);
            list.set(start, list.get(p_pos));
            list.set(p_pos, t);
            quickSort(list, start, p_pos - 1);
            quickSort(list, p_pos + 1, end);
        }
        return list;
    }

    /**
     * 基数排序
     *
     * @param list
     * @return
     */
    public static List<Integer> radixSort(List<Integer> list) {
        int max = list.get(0);
        int size = list.size();
        // 查询最大值
        for (int i = 1; i < size; i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        int times = 0;
        while (max > 0) {
            max /= 10;
            times++;
        }

        List<ArrayList> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < times; i++) {
            for (int j = 0; j < size; j++) {
                int x = list.get(j) % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> subList = dataList.get(x);
                subList.add(list.get(j));
                dataList.set(x, subList);
            }
            int count = 0;
            for (int k = 0; k < 10; k++) {
                while (dataList.get(k).size() > 0) {
                    ArrayList<Integer> subList = dataList.get(k);
                    list.set(count, subList.get(0));
                    subList.remove(0);
                    count++;
                }
            }
        }
        return list;
    }

    /**
     * 计数排序
     * 1 找出最大值，
     * 2 创建一个集合用于统计，每个数字出现的次数
     * 3 遍历集合，根据出现的次数，重新排序数据
     *
     * @param list
     * @return
     */
    public static List<Integer> countSort(List<Integer> list) {


        // 查找最大值
        int max = 0;
        for (Integer v : list) {
            if (v > max) {
                max = v;
            }
        }
        // 统计出现频率
        int[] counts = new int[max + 1];
        for (Integer v : list) {
            counts[v]++;
        }
        // 重新记录数据
        int index = 0;
        for (int value = 0; value <= max; value++) {
            int count = counts[value];
            while (count > 0) {
                count--;
                list.set(index++, value);
            }
        }

        return list;
    }


    /**
     * 归并排序
     *
     * @param list
     * @return
     */
    public static List<Integer> mergeSort(List<Integer> list) {
        int size = list.size();
        if (size > 1) {
            int middle = size / 2;
            List<Integer> left = list.subList(0, middle);
            List<Integer> right = list.subList(middle, size);
            list = merge(mergeSort(left), mergeSort(right));
        }
        return list;
    }


    /**
     * 归并排序
     *
     * @param left
     * @param right
     * @return
     */
    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        int rightSize = right.size();
        int leftSize = left.size();
        int size = leftSize + rightSize;
        List<Integer> list = new ArrayList<>(size);
        int leftIndex = 0, rightIndex = 0;
        while (leftIndex + rightIndex < size) {
            if (rightIndex == rightSize) {
                list.addAll(left.subList(leftIndex, leftSize));
                break;
            }
            if (leftIndex == leftSize) {
                list.addAll(right.subList(rightIndex, rightSize));
                break;
            }
            int leftValue = left.get(leftIndex);
            int rightValue = right.get(rightIndex);

            if (leftValue < rightValue) {
                list.add(leftValue);
                leftIndex++;
            } else {
                list.add(rightValue);
                rightIndex++;
            }
        }
        return list;
    }

}
