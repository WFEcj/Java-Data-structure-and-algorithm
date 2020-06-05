package threadtest;

public class ThreadThree extends Thread{
	private ThreadTwo t;
	public ThreadThree(ThreadTwo t) {
		this.t = t;
	}
	public void run() {
		System.out.println("ThreadThree start");
		synchronized(t) {
			System.out.println("two is locked");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("two is free");
		}
		System.out.println("ThreadThree end");
	}
}
