package com.albenyuan.algorithm.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @Author Alben Yuan
 * @Date 2018-03-06 09:42
 */

public class SortingTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Integer length = 10000;

    private long before = 0l;

    private long after = 0l;

    private static List<Integer> DATA;

    private List<Integer> list = new ArrayList<>(length);

    @Before
    public void before() {
        if (DATA == null) {
            DATA = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < length; i++) {
                DATA.add(random.nextInt(length));
            }
        }
        list = new ArrayList<>(DATA);
        before = System.currentTimeMillis();
        logger.info("list  :{}", list);
//        logger.info("before:{}", before);
    }

    @After
    public void after() {
        after = System.currentTimeMillis();
        logger.info("result:{}", list);
//        logger.info("after  :{}", after);
        logger.info("times :{}", after - before);
    }

    @Test
    public void testInsertion() {
        SortUtil.insertionSort(list);
    }


    @Test
    public void testBubbleSort() throws Exception {
        SortUtil.bubbleSort(list);
    }

    @Test
    public void testSelectionSort() throws Exception {
        SortUtil.selectionSort(list);
    }

    @Test
    public void mergeSort() throws Exception {
        list = SortUtil.mergeSort(list);
    }

    @Test
    public void quickSort() throws Exception {
        list = SortUtil.quickSort(list);
    }


    @Test
    public void radixSort() throws Exception {
        list = SortUtil.radixSort(list);
    }
}
