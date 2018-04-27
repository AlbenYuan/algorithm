package com.albenyuan.algorithm.sort;

import java.util.List;

/**
 * @Author albenyuan
 * @Date 2017-11-10 08:53
 * <p>
 * 排序接口
 */

public interface Sorting {

    /**
     * 输入无序序列，输出有序的序列
     *
     * @param list
     * @return
     */
    List<Integer> sort(List<Integer> list);
    
}
