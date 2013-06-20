package edu.osu.cse;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is an unbounded blocking queue. This methods are thread-safe.
 * @author pjayachandran
 *
 */
public class BlockingQueue {

	private Queue<Object> queue = new LinkedList<Object>();

	public synchronized void enqueue(Object msg) {
		// since the queue is unbounded, keep adding messages
		queue.add(msg);

		// if any threads wait on empty queue then wake them up
		notifyAll();
	}

	public synchronized Object dequeue() {
		Object msg = null;

		// if the queue is empty then wait. to avoid interrupts or spurious
		// wakeup, wait() is used in a loop
		while (queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// return null msg
				return msg;
			}
		}

		msg = queue.remove();
		return msg;
	}
}
