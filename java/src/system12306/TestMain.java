package system12306;

public class TestMain {
	public static void main(String[] args) {
		Window r1 = new Window("Î÷Õ¾");
		Window r2 = new Window("±±Õ¾");
		Window r3 = new Window("ÄÏÕ¾");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		t1.start();
		t2.start();
		t3.start();
		
	}
}
