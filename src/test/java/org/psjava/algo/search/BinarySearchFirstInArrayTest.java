package org.psjava.algo.search;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.Array;
import org.psjava.ds.array.MutableArrayUsingIntArray;
import org.psjava.javautil.DefaultComparator;


public class BinarySearchFirstInArrayTest {

	private static final DefaultComparator<Integer> COMP = new DefaultComparator<Integer>();

	@Test
	public void test() {
		Array<Integer> a = MutableArrayUsingIntArray.create(new int[] { 1, 3, 3, 5, 7, 9 });
		Assert.assertEquals(1, BinarySearchFirstInArray.search(a, 3, COMP, -1));
		Assert.assertEquals(-1, BinarySearchFirstInArray.search(a, 6, COMP, -1));
	}

}