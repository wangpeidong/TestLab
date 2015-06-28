package org.testlab;

import java.util.*;
import java.util.concurrent.*;

final class RandomFillTask {

	private final Random _random = new Random(System.currentTimeMillis());

	final public void fill(final int[] array, final int low, final int high) {
		for (int i = low; i < high; i++)
			array[i] = _random.nextInt(10_000);

	}
}

class RecursiveRandomFillTask extends RecursiveAction {

	private static final long serialVersionUID = -1159560937529397844L;

	private final RandomFillTask _task = new RandomFillTask();

	private final int[] _array;
	private final int _low;
	private final int _high;
	private static final int _splitSize = 40_000;

	public RecursiveRandomFillTask(final int[] array, final int low, final int high) {
		_array = array;
		_low = low;
		_high = high;
	}

	@Override
	protected void compute() {
		if (_high - _low > _splitSize) {
			final int mid = (_low + _high) >>> 1;
			invokeAll(Arrays.asList(new RecursiveRandomFillTask(_array, _low, mid), new RecursiveRandomFillTask(_array,
					mid, _high)));
		} else {
			_task.fill(_array, _low, _high);
		}

	}

}

public class ForkJoinTest {

	public static void main(final String[] args) {
		final int arrayLength = 30_000_000;
		final int[] array = new int[arrayLength];
		final int iterations = 10;
		for (int i = 0; i < iterations; i++) {
			final long start = System.currentTimeMillis();
			new RandomFillTask().fill(array, 0, arrayLength);
			System.out.println("Sequential processing time: " + (System.currentTimeMillis() - start) + " ms");
		}

		System.out.println("Number of processor available : " + Runtime.getRuntime().availableProcessors());

		final ForkJoinPool fjPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		for (int i = 0; i < iterations; i++) {
			final long start = System.currentTimeMillis();
			fjPool.invoke(new RecursiveRandomFillTask(array, 0, arrayLength));
			System.out.println("Parallel processing time: " + (System.currentTimeMillis() - start) + " ms");
		}

		System.out.println("Number of steals : " + fjPool.getStealCount());

	}

}
