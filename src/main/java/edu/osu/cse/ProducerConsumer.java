package edu.osu.cse;

public class ProducerConsumer {

	private static BoundedBlockingQueue queue = new BoundedBlockingQueue(10);
	
	public static class Producer implements Runnable {

		@Override
		public void run() {
			// ideally this should run in loop
			queue.enqueue("hello");
		}
		
	}
	
	public static class Consumer implements Runnable {

		@Override
		public void run() {
			// ideally this should run in loop
			System.out.println(queue.dequeue());
		}
		
	}
	
	public static void main(String[] args) {
		// FIXME: these threads should be run concurrently.
		Thread pthread = new Thread(new Producer());
		pthread.run();
		
		Thread cthread = new Thread(new Consumer());
		cthread.run();
	}
}
