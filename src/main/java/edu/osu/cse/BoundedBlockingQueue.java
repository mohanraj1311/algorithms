package edu.osu.cse;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBlockingQueue {

	private Queue<Object> queue = new LinkedList<Object>();
	private int limit;

	public BoundedBlockingQueue(int capacity) {
		this.limit = capacity;
	}

	public synchronized void enqueue(Object msg) {

		// if queue is full then wait. To wait, current threads should own the
		// monitor. If the thread owns the monitor and if wait is called, the
		// thread revokes the ownership and wait till it is notified by other
		// threads. Since spurious notification/interrupts can occur, it is
		// best to wait on a loop until a condition is met like the while loop
		while (isFull()) {
			try {
				System.out.println("Queue is full. Waiting..");
				Thread.sleep(2);
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		queue.add(msg);

		// notify all waiting consumers if size becomes 1, which means a new
		// item is added and there might be consumers waiting on empty queue
		if (queue.size() == 1) {
			notifyAll();
		}
	}

	private boolean isFull() {
		return queue.size() == limit;
	}

	public synchronized Object dequeue() {
		Object msg = null;

		while (queue.isEmpty()) {
			try {
				System.out.println("Queue is empty. Waiting..");
				Thread.sleep(2);
				wait();
			} catch (InterruptedException e) {
				return null;
			}
		}

		msg = queue.remove();

		// notify all waiting producers that at least one space is available
		if (queue.size() == limit - 1) {
			notifyAll();
		}
		return msg;
	}
}

