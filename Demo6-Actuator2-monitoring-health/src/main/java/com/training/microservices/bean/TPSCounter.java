package com.training.microservices.bean;

import java.util.Calendar;
import java.util.concurrent.atomic.LongAdder;

public class TPSCounter {
	
	private LongAdder count;
	private int threshold = 2;
	private Calendar expiry = null;

	public TPSCounter() {
		this.count = new LongAdder();
		this.expiry = Calendar.getInstance();
		this.expiry.add(Calendar.MINUTE, 1);
	}

	public boolean isExpired() {
		return Calendar.getInstance().after(expiry);
	}

	public boolean isWeak() {
		return (count.intValue() > threshold);
	}

	public void increment() {
		count.increment();
	}
}
