package system12306;

public class Window implements Runnable{
	private String windowName;
	public Window(String name) {
		this.windowName=name;
	}
	public void run() {
		this.sellTicket();
	}
	public void sellTicket() {
		System12306 sy = System12306.getSy();
		while(true) {
			Ticket t = sy.getTicket();
			if(t==null) {
				System.out.println(windowName+"Ʊ�����ˣ���");
				break;
			}else {
				System.out.println(windowName+"�۳���"+t);
			}
		}
	}
}
