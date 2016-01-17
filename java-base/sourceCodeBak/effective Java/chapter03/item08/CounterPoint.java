// Trivial subclass of Point - doesn't add a value component - Page 39
package org.effectivejava.examples.chapter03.item08;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterPoint extends Point {
	private static final AtomicInteger counter = new AtomicInteger();

	public CounterPoint(int x, int y) {
		super(x, y);
		counter.incrementAndGet();
	}

	public int numberCreated() {
		return counter.get();
	}
}
