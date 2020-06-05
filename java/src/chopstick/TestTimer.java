package chopstick;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
	public void testTimer() {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("1");
			}
		}, 3000,1000);
	}
	public static void main(String[] args) {
		TestTimer tt =new TestTimer();
		tt.testTimer();
	}
}
