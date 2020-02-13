package com.company;

import org.junit.Test;
import java.lang.AssertionError;
import static org.junit.Assert.*;

public class sortsTest {
    @Test
    public void selectionSort() throws Exception
    {
        int[] a = new int[]{4,2,9};
        sorts sort = new sorts();
        int[] aa = new int[]{2,8,9};
        assertArrayEquals(aa, sort.selectionSort(a));
    }
}