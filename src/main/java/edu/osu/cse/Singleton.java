package edu.osu.cse;

// http://www.ibm.com/developerworks/java/library/j-dcl/index.html
public class Singleton {
	// volatile is used to let compiler know that the value of this variable
	// should always be read from main memory and not from intermediate cache
	// to avoid any inconsistencies during concurrent access. This in some way
	// prevents the out-of-order execution of java constructors. Java constructors
	// contains 3 basic steps, allocate memory for instance, assign memory to 
	// instance and call constructor. These 3 steps can be executed out-of-order
	// by JIT even with double-checked locking. volatile prevents out-of-order 
	// execution of code but it creates further problems (code movement) as described
	// in the above article.
	private static volatile Singleton _instance = null;
	
	// cannot be used
	private Singleton() {}
	
	public static Singleton getInstance() {
		// if null check is required for performance reason. if the object is
		// already instantiated then none of the threads have to wait on the
		// synchronized block (which is expensive)
		if(_instance == null) {
			synchronized(Singleton.class) {
				// thread 1 enters synchronized block and gets preempted by 
				// thread 2, thread 2 waits on lock, thread 2 is preempted by
				// thread 1 and thread 1 creates a new instance and exits the
				// block. now thread 2 acquires the lock and checks if the
				// instance is null. if this check is not there then thread 2 
				// will also create another instance.
				if(_instance == null) {
					_instance = new Singleton();
				}
			}
		}
		return _instance;
	}
}
