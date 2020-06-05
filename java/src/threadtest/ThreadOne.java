package threadtest;

public class ThreadOne extends Thread{
	public void run() {
		System.out.println("ThreadOne start");
		ThreadTwo two = new ThreadTwo();
		two.start();
		try {
			two.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ThreadOne end");
	}
}