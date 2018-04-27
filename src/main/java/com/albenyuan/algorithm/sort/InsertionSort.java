package com.albenyuan.algorithm.sort;

import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2017-11-10 08:52
 * <p>
 * 插入排序（insertion sorting）
 */
public class InsertionSort implements Sorting {

    @Override
    public List<Integer> sort(List<Integer> list) {

        int size = list.size();
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i) < list.get(j)) {

                }
            }
        }
        return list;
    }
}
