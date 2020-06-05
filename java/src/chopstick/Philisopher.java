package chopstick;

public class Philisopher extends Thread{
	private String name;
	private Chopsticks left;
	private Chopsticks right;
	public Philisopher(String name,Chopsticks left,Chopsticks right) {
		this.name=name;
		this.left=left;
		this.right=right;
	}
	public void run() {
		System.out.println(this.name+"拿起了左手的筷子");
		synchronized(left) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized(right) {
				System.out.println(this.name+"拿起了右手的筷子");
				System.out.println(this.name+"吃了");
			}
		}
	}
}
