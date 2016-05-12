package org.psjava.util;

import org.psjava.ds.array.Array;
import org.psjava.ds.array.MutableArrayFromIterable;

public class SubSetIterable {

	public static <T> Iterable<Iterable<T>> create(final Iterable<T> superSet) {
		final Array<T> array = MutableArrayFromIterable.create(superSet);
		AssertStatus.assertTrue(array.size() <= 30, "too big set to iterate sub set");
		return ConvertedIterable.create(ZeroTo.get(1 << array.size()), new Converter<Integer, Iterable<T>>() {
			@Override
			public Iterable<T> convert(final Integer bits) {
				// Cannot get size of the sub st at this time. Because we use filter way
				return ConvertedIterable.create(FilteredIterable.create(ZeroTo.get(array.size()), new Filter<Integer>() {
					@Override
					public boolean isAccepted(Integer index) {
						return IntBitUtil.get(bits, index);
					}
				}), new Converter<Integer, T>() {
					@Override
					public T convert(Integer index) {
						return array.get(index);
					}
				});
			}
		});
	}

	private SubSetIterable() {
	}
}