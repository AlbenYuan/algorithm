package com.albenyuan.algorithm.sort;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author Alben Yuan
 * @Date 2018-03-06 09:42
 */

public class SortingTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Integer length = 100;

    private List<Integer> list = new ArrayList<>(length);

    @Before
    public void before() {
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            list.add(random.nextInt(length));
        }
    }

    @Test
    public void testInsertion() {
        long before = System.currentTimeMillis();

        logger.info("list  :{}", list);
        logger.info("before:{}", before);
        long end = System.currentTimeMillis();
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(list);
        logger.info("result:{}", list);
        logger.info("end   :{}", end);
        logger.info("times :{}", end - before);

    }

}
