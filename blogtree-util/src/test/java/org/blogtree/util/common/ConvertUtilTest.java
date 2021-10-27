package org.blogtree.util.common;

import org.blogtree.util.base.BaseTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ConvertUtilTest extends BaseTest {

    @Test
    public void toList1() {
        int[] intArr = {1, 2, 3, 4, 5};
        List intList = ConvertUtil.toList(intArr);
        log.info("toList1, intArr={}, intList={}", intArr, intList);
    }

    @Test
    public void toList2() {
        int[] intArr = {};
        List intList = ConvertUtil.toList(intArr);
        log.info("toList2, intArr={}, intList={}", intArr, intList);
    }

    @Test
    public void toList3() {
        int[] intArr = null;
        List intList = ConvertUtil.toList(intArr);
        log.info("toList2, intArr={}, intList={}", intArr, intList);
    }

    @Test
    public void toListAndAdd() {
        int[] intArr = {1, 2, 3, 4, 5};
        List<Integer> intList = ConvertUtil.toList(intArr);
        intList.add(6);
        log.info("toListAndAdd, intArr={}, intList={}", intArr, intList);
    }

    @Test
    public void toArray() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Integer[] array = ConvertUtil.toArray(list);
        log.info("array={}", Arrays.toString(array));
    }
}